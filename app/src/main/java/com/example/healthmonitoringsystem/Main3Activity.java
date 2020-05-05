package com.example.healthmonitoringsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private Button btn_save;
    private EditText et_weight;
    private EditText et_quantity_steps;
    private List<VitalIndicator> indicators = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }

    private void init() {
        btn_save = findViewById(R.id.bt_save);
        et_weight = findViewById(R.id.et_weight);
        et_quantity_steps = findViewById(R.id.et_quantity_steps);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");
                try {
                    double weight = Double.parseDouble(et_weight.getText().toString());
                    int steps = Integer.parseInt(et_quantity_steps.getText().toString());
                    indicators.add(new VitalIndicator(weight, steps));
                } catch (Exception ex) {
                    Toast.makeText(Main3Activity.this, R.string.InputError2,
                            Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Пользователь ввел не корректные данные");
                }
            }
        });
    }
}
