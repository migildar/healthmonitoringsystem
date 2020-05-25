package com.example.healthmonitoringsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndividualActivity extends AppCompatActivity {

    private EditText upPressure;
    private EditText lowerPressure;
    private EditText pulseСheck;
    private CheckBox tachycardiaСheck;
    private Button saveBtn;

    private List<IndividualIndicators> indicators = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init() {
        upPressure = findViewById(R.id.pressureUpEt);
        lowerPressure = findViewById(R.id.pressureDownEt);
        pulseСheck = findViewById(R.id.pulseEt);
        tachycardiaСheck = findViewById(R.id.tachycardiaCheck);
        saveBtn = findViewById(R.id.saveBt);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");
                try {
                    indicators.add(new IndividualIndicators(
                            Integer.parseInt(upPressure.getText().toString()),
                            Integer.parseInt(lowerPressure.getText().toString()),
                            Integer.parseInt(pulseСheck.getText().toString()),
                            tachycardiaСheck.isChecked(),
                            new Date()));
                    Toast.makeText(IndividualActivity.this, indicators.toString(), Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(IndividualActivity.this, R.string.InputError,
                            Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Пользователь ввел не корректные данные");
                }
            }
        });
    }
}
