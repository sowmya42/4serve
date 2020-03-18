package com.example.a4serve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

import io.realm.Realm;

public class SignUp extends AppCompatActivity {
    private EditText etName;
    private EditText etPass;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName = findViewById(R.id.etUsername);
        etPass = findViewById(R.id.etPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();

                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void signUpUser() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Profile profile = new Profile(etName.getText().toString(), etPass.getText().toString());

        realm.insert(profile);

        realm.commitTransaction();
        realm.close();
    }
}