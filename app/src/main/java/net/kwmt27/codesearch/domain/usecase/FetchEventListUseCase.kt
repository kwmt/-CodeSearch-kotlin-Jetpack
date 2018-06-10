package net.kwmt27.codesearch.domain.usecase

import io.reactivex.Single
import net.kwmt27.codesearch.domain.model.Event
import net.kwmt27.codesearch.domain.repository.EventListRepository

/**
 *
 */
interface FetchEventListUseCase {
    fun execute(user: String, page: Int): Single<List<Event>>
}

class FetchEventListUseCaseImpl(
        private val eventListRepository: EventListRepository
): FetchEventListUseCase {
    override fun execute(user: String, page: Int): Single<List<Event>> {
        // TODO
        return eventListRepository.fetchEventList(user, page)
    }

}