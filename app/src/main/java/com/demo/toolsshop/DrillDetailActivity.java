package com.demo.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewDrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewDrill = findViewById(R.id.imageViewDrill);
        Intent intent = getIntent(); // получение созданного раннее интента для получения информации из него
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
                String title = intent.getStringExtra("title"); // получение данных из интента
                String info = intent.getStringExtra("info"); // получение данных из интента
                int resId = intent.getIntExtra("resId", -1); // получение данных из интента, второе - знач.по.умолч
                textViewTitle.setText(title);
                textViewInfo.setText(info);
                imageViewDrill.setImageResource(resId);
        } else {
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}
