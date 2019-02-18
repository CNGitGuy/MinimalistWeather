package com.baronzhang.android.weather.view.home;

import com.baronzhang.android.weather.di.ApplicationComponent;
import com.baronzhang.android.weather.di.ActivityScoped;

import dagger.Component;

/**
 * @author baronzhang (baron[dot]zhanglei[at]gmail[dot]com)
 *         2016/11/29
 */
@ActivityScoped
@Component(modules = HomePageModule.class, dependencies = ApplicationComponent.class)
public interface HomePageComponent {

    void inject(MainActivity mainActivity);
}
