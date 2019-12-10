package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginActivity extends AppCompatActivity {
    private static final  String URL = "http://192.168.0.27:8000/user";
    Login[] users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StringRequest stringRequest = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Login",response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                users = gson.fromJson(response,Login[].class);
                /*for(Login i : users){
                    if(i.getUsername().equalsIgnoreCase(email.getText().toString())){
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }*/
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        /*if(flag[0]) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }*/
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void loginClicked(View view) {
        final EditText email = findViewById(R.id.firstName);
        final EditText password = findViewById(R.id.password);
        boolean flag = false;
        for(Login l:users){
            if(email.getText().toString().equalsIgnoreCase(l.getUsername())&&password.getText().toString().equalsIgnoreCase(l.getPassword())){
                flag=true;
                break;
            }
        }
        if(flag){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Sorry Username or Password is Wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
