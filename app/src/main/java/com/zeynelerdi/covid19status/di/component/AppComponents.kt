package com.zeynelerdi.covid19status.di.component

import android.content.Context
import com.zeynelerdi.covid19status.data_source.local.AppDao
import com.zeynelerdi.covid19status.data_source.local.AppDb
import com.zeynelerdi.covid19status.di.modules.*
import com.zeynelerdi.covid19status.ui.details_stats.DetailsCountriesStatsActivity
import com.zeynelerdi.covid19status.ui.list_stats.ListCountriesStatsFragment
import com.zeynelerdi.covid19status.ui.main.MainActivity
import com.zeynelerdi.covid19status.ui.onboarding.OnboardingActivity
import com.zeynelerdi.covid19status.ui.search_history.SearchHistoryFragment
import com.zeynelerdi.covid19status.ui.world_stats.WorldStatsFragment
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        CoroutinesModule::class,
        StorageModule::class
    ]
)
interface AppComponents {
    fun context(): Context

    fun retrofit(): Retrofit

    fun appDao(): AppDao

    fun appDatabase(): AppDb

    fun inject(mainActivity: MainActivity)
    fun inject(listCountriesStatsActivity: ListCountriesStatsFragment)
    fun inject(detailsCountriesStatsActivity: DetailsCountriesStatsActivity)
    fun inject(worldStatsActivity: WorldStatsFragment)
    fun inject(onBoardingActivity: OnboardingActivity)
    fun inject(searchHistoryFragment: SearchHistoryFragment)
}