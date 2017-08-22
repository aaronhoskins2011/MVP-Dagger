package com.example.aaron.mvp_dagger.injection.mainactivity;

import com.example.aaron.mvp_dagger.view.mainActivityPackage.MainActivity;
import com.example.aaron.mvp_dagger.view.mainActivityPackage.MainActivityPresenter;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by aaron on 8/21/17.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
