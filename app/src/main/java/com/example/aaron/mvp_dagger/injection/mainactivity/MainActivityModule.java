package com.example.aaron.mvp_dagger.injection.mainactivity;

import com.example.aaron.mvp_dagger.view.mainActivityPackage.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aaron on 8/21/17.
 */
@Module
public class MainActivityModule {
    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }
}
