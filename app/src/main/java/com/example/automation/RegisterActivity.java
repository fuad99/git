package com.example.automation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText etUsername,etEmail,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUsername = findViewById(R.id.etUsername);
        etEmail  = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    public void postRegist(View view){
        if(TextUtils.isEmpty(etEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Harus Diisi",Toast.LENGTH_LONG).show();
        } else if(TextUtils.isEmpty(etPassword.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Password Harus Diisi",Toast.LENGTH_LONG).show();
        } else if(TextUtils.isEmpty(etEmail.getText().toString().trim()) && TextUtils.isEmpty(etPassword.getText().toString().trim()) && TextUtils.isEmpty(etUsername.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Lengkapi Data Anda",Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(etUsername.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Username Harus Diisi",Toast.LENGTH_LONG).show();
        } else {
            Intent i = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(i);
        }
    }
}
