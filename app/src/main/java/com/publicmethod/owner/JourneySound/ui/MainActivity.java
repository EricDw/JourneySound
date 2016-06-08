package com.publicmethod.owner.JourneySound.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.publicmethod.owner.JourneySound.R;
import com.publicmethod.owner.JourneySound.databinding.ActivityMainBinding;
import com.publicmethod.owner.JourneySound.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new MainActivityViewModel(this));

        setSupportActionBar(activityMainBinding.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


    }

}
