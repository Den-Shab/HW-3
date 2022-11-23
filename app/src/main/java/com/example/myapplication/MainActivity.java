package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.activities.ClubActivity;
import com.example.myapplication.activities.NationActivity;
import com.example.myapplication.activities.PlayerActivity;

public class MainActivity extends AppCompatActivity {

    private Button playerBt;
    private Button nationBt;
    private Button clubBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        config();
    }

    private void config() {
        nationBt = findViewById(R.id.nationB);
        nationBt.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), NationActivity.class)));

        playerBt = findViewById(R.id.playerB);
        playerBt.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), PlayerActivity.class)));

        clubBt = findViewById(R.id.clubB);
        clubBt.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ClubActivity.class)));
    }


}