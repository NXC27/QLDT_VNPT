package com.example.qldt_vnpt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qldt_vnpt.DataBaseHandler.ICallAPI;
import com.example.qldt_vnpt.DataBaseHandler.ICallBack;
import com.example.qldt_vnpt.DataBaseHandler.RetrofitClient;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ICallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edname = (EditText) findViewById(R.id.editUserName);
        EditText edpassword = (EditText) findViewById(R.id.editPassword);

        Button btn_submit = (Button) findViewById(R.id.btnLogin);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var name = edname.getText().toString().toLowerCase();
                var pwd = edpassword.getText().toString();
                if (name == "" || pwd == ""){
                    Toast.makeText(MainActivity.this,"Email and Password must be fill",Toast.LENGTH_SHORT);
                }else
                {
                    processLogin(name,pwd);
                }
            }
        });
    }

    private void processLogin(String name, String pwd) {
        var loginService = RetrofitClient.getInstance().create(ICallAPI.class);
        Call<JSONObject> call = loginService.Login(name,pwd);
        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if (response.isSuccessful()){
                    MainActivity.this.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                MainActivity.this.onError(t);
            }
        });
    }

    @Override
    public void onResponse(JSONObject jsonObject) {
        System.out.println(jsonObject);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println(t.getLocalizedMessage());
    }
}