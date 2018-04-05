package com.example.darshana.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edText;
    Double num1,num2;
    Button btn;
    String txt;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edText = (EditText) findViewById(R.id.editText);
    }

    public void btn1(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"1");
    }

    public void btn2(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"2");
    }

    public void btn3(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"3");
    }

    public void btn4(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"4");
    }

    public void btn5(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"5");
    }

    public void btn6(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"6");
    }

    public void btn7(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"7");
    }

    public void btn8(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"8");
    }

    public void btn9(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"9");
    }
    public void btn0(View v){
        txt = edText.getText().toString();
        edText.setText(txt+"0");
    }

    public void btn(View v){
        txt = edText.getText().toString();
        edText.setText(txt+".");
    }

    public void btnPluse(View v){
        txt = edText.getText().toString();
        num1 = Double.parseDouble(txt);
        edText.setText("");
        operator = '+';
    }

    public void btnmin(View v){
        txt = edText.getText().toString();
        num1 = Double.parseDouble(txt);
        edText.setText("");
        operator = '-';
    }

    public void btnmul(View v){
        txt = edText.getText().toString();
        num1 = Double.parseDouble(txt);
        edText.setText("");
        operator = '*';
    }

    public void btndiv(View v){
        txt = edText.getText().toString();
        num1 = Double.parseDouble(txt);
        edText.setText("");
        operator = '/';
    }

    public void btnclear(View v){
        edText.setText("");
    }

    public void btnback(View v){
        edText.setText(txt);
    }

    public void btneq(View v){
        txt = edText.getText().toString();
        num2 = Double.parseDouble(txt);
        double total = 0;

        switch (operator){
            case '+' : total = num1+num2;break;
            case '-' : total = num1-num2;break;
            case '*' : total = num1*num2;break;
            case '/' : total = num1/num2;break;

        }

        edText.setText(String.valueOf(total));
    }

}
