package com.youxiang8727.peronatw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView textview_start_time, textview_end_time, textview_degree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        getTime();
    }

    private void initView(){
        textview_start_time = findViewById(R.id.textview_start_time);
        textview_end_time = findViewById(R.id.textview_end_time);
        textview_degree = findViewById(R.id.textview_degree);
    }

    private void getTime(){
        Intent intent = getIntent();
        ApiResult.Records.Location.WeatherElement.Time time = (ApiResult.Records.Location.WeatherElement.Time) intent.getSerializableExtra("time");
        textview_start_time.setText(time.getStartTime());
        textview_end_time.setText(time.getEndTime());
        textview_degree.setText(time.getParameter().getParameterName() + "C");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "歡迎回來", Toast.LENGTH_SHORT).show();
    }
}