package com.example.darshana.notesafeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtSignIn;
    EditText edEmail,edPassword;
    Button btnLogin;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSignIn = (TextView) findViewById(R.id.txtsignin);
        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent );
            }
        });

        db = new DatabaseHelper(this);
        edEmail = (EditText) findViewById(R.id.etEmail);
        edPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLog);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();

                Boolean CheckEmailPass = db.emailpassword(email,password);
                if (CheckEmailPass == true){
                    Toast.makeText(getApplicationContext(),"SuccessFull Login",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this,NoteHome.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong Email or Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
