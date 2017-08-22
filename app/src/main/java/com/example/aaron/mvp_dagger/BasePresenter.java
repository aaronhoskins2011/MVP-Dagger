package com.example.aaron.mvp_dagger;

/**
 * Created by aaron on 8/21/17.
 */

public interface BasePresenter<V extends BaseView> {
    void attatchView(V view);
    void removeView();

}
