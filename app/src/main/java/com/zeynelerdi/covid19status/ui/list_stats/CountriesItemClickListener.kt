package com.zeynelerdi.covid19status.ui.list_stats

import com.zeynelerdi.covid19status.model.CountryStat


interface CountriesItemClickListener {
    fun onCountryItemClicked(countryStat: CountryStat)
}