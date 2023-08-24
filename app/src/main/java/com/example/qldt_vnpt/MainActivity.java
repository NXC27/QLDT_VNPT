package com.example.qldt_vnpt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = (TextView) findViewById(R.id.name);
        TextView password = (TextView) findViewById(R.id.pasword);

        Button btn_submit = (Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("name_db") &&
                    password.getText().toString().equals("password_db")){
                    Toast.makeText(MainActivity.this,"success", Toast.LENGTH_SHORT);
                }
            }
        });
    }
}