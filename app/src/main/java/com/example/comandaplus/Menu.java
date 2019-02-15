package com.example.comandaplus;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class Menu extends AppCompatActivity {


    private static final String PATH_START="start";
    public  static final String PATH_MESSAGE="message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menutabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.navigationView);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

    }

}
