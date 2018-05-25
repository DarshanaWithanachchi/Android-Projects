package com.example.darshana.notesafeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText edName,edEmail,edPassword,edConPassword;
    Button btnRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        edName = findViewById(R.id.etName);
        edEmail = findViewById(R.id.etEmail);
        edPassword = findViewById(R.id.etPassword);
        edConPassword = findViewById(R.id.etConfirmPassword);
        btnRegister =(Button) findViewById(R.id.btnregister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stName = edName.getText().toString();
                String stEmail = edEmail.getText().toString();
                String stPassword = edPassword.getText().toString();
                String stConPassword = edConPassword.getText().toString();

                if (stName.equals("")||stEmail.equals("")||stPassword.equals("")||stConPassword.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are Empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (stPassword.equals(stConPassword)){
                        Boolean chckemail = db.chckemail(stEmail);
                        if (chckemail == true){
                            Boolean insert = db.insert(stName,stEmail,stPassword);
                            if (insert == true){
                                Toast.makeText(getApplicationContext(),"Registation Successful",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Registation Unsuccess",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email Alredy Exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Password Missmatched",Toast.LENGTH_SHORT).show();
                        edPassword.setText("");
                        edConPassword.setText("");
                    }
                }
            }
        });

    }
}
