package com.example.unittestdemo_test.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unittestdemo.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HiltTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hilt_test);
    }
}