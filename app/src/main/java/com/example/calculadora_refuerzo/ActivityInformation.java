package com.example.calculadora_refuerzo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ActivityInformation extends AppCompatActivity {

    private Toolbar miToolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        miToolbar=findViewById(R.id.toolBar);
        setSupportActionBar(miToolbar);

    }
    public void OnClick(View v)
    {
        onPause();
        finish();
    }
}
