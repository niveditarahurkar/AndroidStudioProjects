package com.example.nirahurk.apples_new;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


import android.content.Intent;

public class Bacon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);
        Bundle appleData = getIntent().getExtras();
        if (appleData== null){
            return;
        }
        String applesMessage = appleData.getString("applesMessage");
        TextView tvBacon = (TextView) findViewById(R.id.baconText);
        tvBacon.setText(applesMessage);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void applesClick(View view){
        Intent I = new Intent(this, MainActivity.class);
        startActivity(I);
    }

}
