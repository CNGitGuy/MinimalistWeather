package com.minimalist.weather.kotlin.view.contract


import com.minimalist.weather.kotlin.model.data.entity.city.City

interface SelectCityContract {

    interface View : BaseView {

        fun displayCities(cities: List<City>)
    }

    interface Presenter : BasePresenter<View> {

        fun loadCities()
    }
}
