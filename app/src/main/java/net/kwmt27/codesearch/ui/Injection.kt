package net.kwmt27.codesearch.ui

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import net.kwmt27.codesearch.domain.repository.EventListRepository
import net.kwmt27.codesearch.domain.usecase.FetchEventListUseCase
import net.kwmt27.codesearch.domain.usecase.FetchEventListUseCaseImpl
import net.kwmt27.codesearch.infrastructure.api.GithubApi
import net.kwmt27.codesearch.infrastructure.datesource.GithubApiDataSource
import java.util.concurrent.Executors

object Injection {

    /**
     * Creates an instance of [GithubLocalCache] based on the database DAO.
     */
//    private fun provideCache(context: Context): GithubLocalCache {
//        val database = RepoDatabase.getInstance(context)
//
//   return GithubLocalCache(database.reposDao(), Executors.newSingleThreadExecutor())
//    }


    private fun provideEventListRepository() : EventListRepository {
        return GithubApiDataSource(GithubApi.create())
    }
    /**
     * Creates an instance of [GithubRepository] based on the [GithubService] and a
     * [GithubLocalCache]
     */
    private fun provideFetchEventListUseCase(context: Context): FetchEventListUseCase {
//        return FetchEventListUseCaseImpl(GithubService.create(), provideCache(context))
        return FetchEventListUseCaseImpl(provideEventListRepository())
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideFetchEventListUseCase(context))
    }

}