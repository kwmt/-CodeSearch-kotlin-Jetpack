package net.kwmt27.codesearch.ui.event

import androidx.lifecycle.*
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import io.reactivex.rxkotlin.addTo
import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.domain.usecase.FetchEventListUseCase

class EventListViewModel(private val fetchEventListUseCase: FetchEventListUseCase) : ViewModel() {

    private var compositeDisposable = CompositeDisposable()

//    /** リストの状態をリセットするフラグ */
//    @get:Bindable
//    var resetLoadingState: Boolean = false
//        set(resetLoadingState) {
//            field = resetLoadingState
//            notifyPropertyChanged(BR.resetLoadingState)
//        }

    var hasMore = BehaviorRelay.createDefault(false)

    val eventViewModelList = MutableLiveData<EventListResult>()

    var currentPage: Int = 0

    private lateinit var paginator: PublishProcessor<Int>


    val eventList: LiveData<List<Event>> = Transformations.switchMap(eventViewModelList, { it ->
        it.data
    })

    fun initialize(user: String) {
        currentPage = 1
        paginator = PublishProcessor.create()
        paginator.onBackpressureDrop()
                .filter { !hasMore.value }
                .doOnNext { hasMore.accept(true) }
                .concatMap {
                    val events = loadEvents(user, it).toFlowable()
                    Flowable.just(EventListResult(LiveDataReactiveStreams.fromPublisher(events)))
                }

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    hasMore.accept(false)
                    eventViewModelList.postValue(it)
                    currentPage++
                }, {
                    hasMore.accept(false)
                }).addTo(compositeDisposable)
        onLoadMore(currentPage)
    }

    fun onLoadMore(page: Int) {
        paginator.onNext(page)
    }

    private fun loadEvents(user: String, page: Int): Single<List<Event>> {
        return fetchEventListUseCase.execute(user, page)
    }

}

