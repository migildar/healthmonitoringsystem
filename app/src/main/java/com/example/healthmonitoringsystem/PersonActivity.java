package com.example.healthmonitoringsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonActivity extends AppCompatActivity {

    private Button saveValuePressureBtn;
    private Button saveVitalStatisticsBtn;
    private Button saveBtn;
    private EditText nameEt;
    private EditText ageEt;
    private User user;
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        saveBtn = findViewById(R.id.saveBtn);
        nameEt = findViewById(R.id.nameEt);
        ageEt = findViewById(R.id.ageEt);
        saveValuePressureBtn = findViewById(R.id.saveValuePressureBtn);
        saveVitalStatisticsBtn = findViewById(R.id.saveVitalStatisticsBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");
                String nameStr = nameEt.getText().toString();
                String ageStr = ageEt.getText().toString();

                try {
                    if (nameStr.equals("")) {
                        throw new RuntimeException("Введите ФИО пользователя!");
                    }
                    user = new User(nameStr, Integer.parseInt(ageStr));
                    Toast.makeText(PersonActivity.this, user.toString(), Toast.LENGTH_LONG).show();
                } catch (RuntimeException ex) {
                    Toast.makeText(PersonActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Пользователь ввел не корректные данные");
                } catch (Exception ex) {
                    Toast.makeText(PersonActivity.this, "Введите целое число!", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Пользователь ввел не корректные данные");
                }
            }
        });

        saveValuePressureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IndividualActivity.class);
                startActivity(intent);
            }
        });

        saveVitalStatisticsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VitalActivity.class);
                startActivity(intent);
            }
        });

    }
}
