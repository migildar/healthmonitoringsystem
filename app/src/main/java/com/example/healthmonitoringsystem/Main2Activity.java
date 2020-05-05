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

public class Main2Activity extends AppCompatActivity {

    private EditText et_top_pressure;
    private EditText et_lower_pressure;
    private EditText et_pulse;
    private CheckBox check_tachycardia;
    private Button btn_save;

    private List<IndividualIndicators> indicators = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    private void init() {
        et_top_pressure = findViewById(R.id.et_top_pressure);
        et_lower_pressure = findViewById(R.id.et_lower_pressure);
        et_pulse = findViewById(R.id.et_pulse);
        check_tachycardia = findViewById(R.id.check_tachycardia);
        btn_save = findViewById(R.id.bt_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");
                try {
                    int top_pressure = Integer.parseInt(et_top_pressure.getText().toString());
                    int lower_pressure = Integer.parseInt(et_lower_pressure.getText().toString());
                    int pulse = Integer.parseInt(et_pulse.getText().toString());
                    indicators.add(new IndividualIndicators(
                            Integer.parseInt(et_top_pressure.getText().toString()),
                            Integer.parseInt(et_lower_pressure.getText().toString()),
                            Integer.parseInt(et_pulse.getText().toString()),
                            check_tachycardia.isChecked(),
                            new Date()));
                } catch (Exception ex) {
                    Toast.makeText(Main2Activity.this, R.string.InputError,
                            Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Пользователь ввел не корректные данные");
                }
            }
        });
    }
}
