package com.zeynelerdi.covid19status.datasource

import com.zeynelerdi.covid19status.data.ResponseHistoryCountry
import com.zeynelerdi.covid19status.data.ResponseListCountriesAffected
import com.zeynelerdi.covid19status.data.ResponseListCountriesStats
import com.zeynelerdi.covid19status.data.ResultData
import com.zeynelerdi.covid19status.data_source.remote.RemoteDataSource
import com.zeynelerdi.covid19status.helpers.getJson
import com.zeynelerdi.covid19status.model.WorldStats

class AppDataSourceImplTest : RemoteDataSource {

    override suspend fun worldWithStats(): ResultData<WorldStats> {
        TODO("Not yet implemented")
    }

    override suspend fun listCountriesWithStats(): ResultData<ResponseListCountriesStats> {
        val list = getJson("country_stats.json") as ResponseListCountriesStats
        return ResultData.Success(list)
    }

    override suspend fun historyByDateByCountryStats(
        country: String,
        date: String
    ): ResultData<ResponseHistoryCountry> {
        TODO("Not yet implemented")
    }

    override suspend fun affectedCountries(): ResultData<ResponseListCountriesAffected> {
        TODO("Not yet implemented")
    }


}