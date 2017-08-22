package com.example.aaron.mvp_dagger.view.mainActivityPackage;

import com.example.aaron.mvp_dagger.BasePresenter;
import com.example.aaron.mvp_dagger.BaseView;

/**
 * Created by aaron on 8/21/17.
 */

public interface MainActivityContract {

    interface View extends BaseView {
        void isPersonSaved(boolean isSaved);
        void sendPerson(String person);
    }

    interface Presenter extends BasePresenter<View> {
        void savePerson(String person);
        String getPerson();

    }
}
