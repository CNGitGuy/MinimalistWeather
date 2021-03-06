package com.minimalist.weather.kotlin.feature.selectcity

import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import butterknife.BindView
import butterknife.ButterKnife
import com.jakewharton.rxbinding.support.v7.widget.RxSearchView
import com.minimalist.weather.kotlin.R
import com.minimalist.weather.kotlin.feature.base.BaseActivity
import com.minimalist.weather.kotlin.utils.ActivityUtils
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SelectCityActivity : BaseActivity() {
    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar
    @Inject
    lateinit var mSelectCityFragmentProvider: dagger.Lazy<SelectCityFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_city)
        ButterKnife.bind(this)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        var selectCityFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as? SelectCityFragment
        if (selectCityFragment == null) {
            selectCityFragment = mSelectCityFragmentProvider.get()
            ActivityUtils.addFragmentToActivity(supportFragmentManager, selectCityFragment, R.id.fragment_container)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_city, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_search) {
            val searchView = MenuItemCompat.getActionView(item) as SearchView
            RxSearchView.queryTextChanges(searchView)
                    .map<String> { charSequence -> charSequence?.toString()?.trim { it <= ' ' } }
                    .throttleLast(100, TimeUnit.MILLISECONDS)
                    .debounce(100, TimeUnit.MILLISECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { searchText ->
                        mSelectCityFragmentProvider.get().cityListAdapter.filter.filter(searchText)
                    }
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}