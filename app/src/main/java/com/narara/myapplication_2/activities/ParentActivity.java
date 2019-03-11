package com.narara.myapplication_2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.narara.myapplication_2.R;

public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
    }
}
