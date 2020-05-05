package com.example.healthmonitoringsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_save_value_pressure;
    private Button btn_save_vital_statistics;
    private Button btn_save;
    private EditText et_fio;
    private EditText et_age;
    private User user;
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btn_save = findViewById(R.id.bt_save);
        et_fio = findViewById(R.id.et_fio);
        et_age = findViewById(R.id.et_age);
        btn_save_value_pressure = findViewById(R.id.id_save_value_pressure);
        btn_save_vital_statistics = findViewById(R.id.id_save_vital_statistics);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Пользователь нажал кнопку сохранить");
                String string_age = et_age.getText().toString();
                try {
                    user = new User(et_fio.getText().toString(), Integer.parseInt(string_age));
                    Toast.makeText(MainActivity.this, user.toString(), Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, R.string.InputError,
                            Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Пользователь ввел не корректные данные");
                }
            }
        });

        btn_save_value_pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

        btn_save_vital_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(intent);
            }
        });

    }
}
