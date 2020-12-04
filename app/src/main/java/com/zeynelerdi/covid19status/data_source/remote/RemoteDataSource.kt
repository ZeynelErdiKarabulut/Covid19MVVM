package com.zeynelerdi.covid19status.data_source.remote

import com.zeynelerdi.covid19status.data.ResponseHistoryCountry
import com.zeynelerdi.covid19status.data.ResponseListCountriesAffected
import com.zeynelerdi.covid19status.data.ResponseListCountriesStats
import com.zeynelerdi.covid19status.data.ResultData
import com.zeynelerdi.covid19status.model.WorldStats

interface RemoteDataSource {

    suspend fun worldWithStats(): ResultData<WorldStats>
    suspend fun listCountriesWithStats(): ResultData<ResponseListCountriesStats>
    suspend fun historyByDateByCountryStats(
        country: String,
        date: String
    ): ResultData<ResponseHistoryCountry>

    suspend fun affectedCountries(): ResultData<ResponseListCountriesAffected>

}