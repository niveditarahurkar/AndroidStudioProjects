package com.example.nirahurk.myfirstopencvproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

    static {
        if(!OpenCVLoader.initDebug()){
            Log.i("opencv","opencv initialization failed");
        }else {
            Log.i("opencv","opencv initialization successful");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
