package com.example.nhf;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {
    private Spinner alivecSpinner;
    private Spinner deadcSpinner;
    private Spinner gridcSpinner;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPref;
    String keyalive = "alive_cell_color";
    String keydead = "dead_cell_color";
    String keygrid = "grid_line_color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Button apply = findViewById(R.id.applybtn);
        alivecSpinner = findViewById(R.id.ac);
        deadcSpinner = findViewById(R.id.dc);
        gridcSpinner = findViewById(R.id.gc);
        getApplicationContext();
        sharedPref = getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();

                editor.putString(keyalive, alivecSpinner.getSelectedItem().toString());
                editor.putString(keydead, deadcSpinner.getSelectedItem().toString());
                editor.putString(keygrid, gridcSpinner.getSelectedItem().toString());
                editor.commit();


            }
        });


        Button test = findViewById(R.id.testbtn);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared = getPreferences(Context.MODE_PRIVATE);
                Toast toast = Toast.makeText(getBaseContext(),
                        "" + shared.getString(keyalive, "") + " " + shared.getString(keydead, "") + " " + shared.getString(keygrid, "") + " ",
                        Toast.LENGTH_SHORT);

                toast.show();
            }
        });
    }


}
