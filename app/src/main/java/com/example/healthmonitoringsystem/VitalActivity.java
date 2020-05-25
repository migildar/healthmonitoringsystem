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

public class VitalActivity extends AppCompatActivity {

    private Button saveBtn;
    private EditText weightValue;
    private EditText quantitySteps;
    private List<VitalIndicator> indicators = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }

    private void init() {
        saveBtn = findViewById(R.id.saveBt);
        weightValue = findViewById(R.id.weightEt);
        quantitySteps = findViewById(R.id.quantityStepsEt);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");
                try {
                    double weight = Double.parseDouble(weightValue.getText().toString());
                    int steps = Integer.parseInt(quantitySteps.getText().toString());
                    indicators.add(new VitalIndicator(weight, steps));
                    Toast.makeText(VitalActivity.this, indicators.toString(), Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(VitalActivity.this, R.string.InputError2,
                            Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Пользователь ввел не корректные данные");
                }
            }
        });
    }
}
