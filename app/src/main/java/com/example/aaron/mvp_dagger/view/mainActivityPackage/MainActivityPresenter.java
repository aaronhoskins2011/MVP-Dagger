package com.example.aaron.mvp_dagger.view.mainActivityPackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.aaron.mvp_dagger.view.mainActivityPackage.MainActivityContract.Presenter;

/**
 * Created by aaron on 8/21/17.
 */

public class MainActivityPresenter implements Presenter {
    MainActivityContract.View view;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    Context context;
    @Override
    public void attatchView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void savePerson(String person) {
        SharedPreferences.Editor prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        prefEditor.putString("NAME", person);
        prefEditor.apply();
        view.isPersonSaved(true);
    }

    @Override
    public String getPerson() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String myStrValue = prefs.getString("NAME", "NO NAME FOUND");
        return myStrValue;
    }

}
