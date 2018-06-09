package net.kwmt27.codesearch.ui.event

import android.view.View
import androidx.databinding.BaseObservable
import io.reactivex.disposables.CompositeDisposable
import net.kwmt27.codesearch.domain.model.GithubUser
import timber.log.Timber

/**
 * イベント一覧の各リストアイテムに対応するViewModel
 */
class EventViewModel(
        githubUser: GithubUser
) : BaseObservable() {

    private val compositeDisposable = CompositeDisposable()

    val name: String = githubUser.name
    val imageUrl: String = githubUser.imageUrl


    fun onClickEvent(@Suppress("UNUSED_PARAMETER") view: View) {
        Timber.d("onClick Event")
    }
}
