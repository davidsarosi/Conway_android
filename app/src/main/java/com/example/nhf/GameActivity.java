package com.example.nhf;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    private GameView gameOfLifeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameOfLifeView = findViewById(R.id.game_of_life);


        System.out.println("something");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button startbtn=findViewById(R.id.gamestartbtn);
        Button stopbtn=findViewById(R.id.gamestopbtn);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!gameOfLifeView.isRunning)
                    gameOfLifeView.start();
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameOfLifeView.isRunning)
                    gameOfLifeView.stop();
            }
        });
        gameOfLifeView.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        gameOfLifeView.stop();
    }
}


