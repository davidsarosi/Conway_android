package com.example.nhf;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.startbtn);
        Button load = findViewById(R.id.loadbtn);
        Button options = findViewById(R.id.optionsbtn);
        Button quit = findViewById(R.id.quitbtn);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GameIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(GameIntent);
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoadIntent = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(LoadIntent);
            }
        });
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OptionsIntent = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(OptionsIntent);
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }
        });




    }

}
