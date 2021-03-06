package com.baronzhang.android.weather.feature.selectcity;

import com.baronzhang.android.weather.di.ApplicationComponent;
import com.baronzhang.android.weather.di.ActivityScoped;

import dagger.Component;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         2016/11/30
 */
@ActivityScoped
@Component(modules = SelectCityModule.class, dependencies = ApplicationComponent.class)
public interface SelectCityComponent {

    void inject(SelectCityActivity selectCityActivity);
}
