package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_time;
    private Button btn_start;
    private TextView tv_missing_time;
    private int time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializations
        et_time = findViewById(R.id.et_time);
        btn_start = findViewById(R.id.btn_start);
        tv_missing_time = findViewById(R.id.tv_missing_time);

        btn_start.setOnClickListener(this::startCounting);

    }

    public void startCounting(View v){
        try{
            time = Integer.parseInt(et_time.getText().toString());

            new CountDownTimer(time*1000, 1000) {
                public void onTick(long millisUntilFinished) {
                    tv_missing_time.setText("Seconds remaining:\n\n" + millisUntilFinished / 1000);
                }
                public void onFinish() {
                    tv_missing_time.setText("Time's up!");
                }
            }.start();

        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "No time inserted.", Toast.LENGTH_SHORT).show();
        }

    }
}