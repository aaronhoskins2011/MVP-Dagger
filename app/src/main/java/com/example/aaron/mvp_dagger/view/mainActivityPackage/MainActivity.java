package com.example.aaron.mvp_dagger.view.mainActivityPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.aaron.mvp_dagger.R;
import com.example.aaron.mvp_dagger.injection.mainactivity.DaggerMainActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{
    @Inject
    MainActivityPresenter presenter;

    TextView tvPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //MVP has a one-to-one between Model-View-Presenter
        /*                        |->>--presenter interface>>--V
                Model           View                      Presenter----->> DATA
                  ^                ^----------view interface---| |           local
                  ^           (Activity, frag)                   V            remote
                  ^---<<----Repository class--------<<-----------|

         */
        DaggerMainActivityComponent.create().inject(this); //creates object graph
        presenter = new MainActivityPresenter();
        presenter.attatchView(this);
        presenter.setContext(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tvPerson = (TextView)findViewById(R.id.tvPerson);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void isPersonSaved(boolean isSaved) {
        Log.d("TAG", "isPersonSaved: " + isSaved);

    }

    @Override
    public void sendPerson(String person) {

    }


    public void doMagic(View view) {
       switch (view.getId()){
           case R.id.btnSavePerson:
               presenter.savePerson("Someone Lastname");
               break;
           case R.id.btnGetPerson:
               tvPerson.setText(presenter.getPerson());
               break;
       }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.removeView();
    }
}
