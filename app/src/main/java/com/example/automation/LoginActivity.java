package com.example.automation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail,etPassword;
    public static final String Key_Register = "Key_RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
    }
    public void postLogin(View view){


        if(TextUtils.isEmpty(etEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Harus Diisi",Toast.LENGTH_LONG).show();
        } else if(TextUtils.isEmpty(etPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Password Harus Diisi",Toast.LENGTH_LONG).show();
        } else if(TextUtils.isEmpty(etEmail.getText().toString().trim()) && TextUtils.isEmpty(etPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Lengkapi Data Anda",Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
        }
    }
    public void register(View view){
        String username = etEmail.getText().toString().trim();

        Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
        i.putExtra("name",username);
        startActivity(i);
    }
}
