package com.stivenduque.myapplication;


import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9, btn_equal,btn_mult,btn_add,btn_sub,btn_div,btn_clear;
    private TextView textView;
    private TextView textViewNumber;
    private String value;
    private float valueOne,result = 0;
    private int operation = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectComponent();
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView,10,30,3,3);
        //TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textViewNumber,5,20,2,3);


    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_0:
                setValue(concatenate(R.id.inputNumber,"0"));
                textView.setText(getValue());
                break;
            case R.id.btn_1:
                setValue( concatenate(R.id.inputNumber, "1"));
                textView.setText(value);

                break;
            case R.id.btn_2:
                setValue( concatenate(R.id.inputNumber, "2"));
                textView.setText(value);
                break;
            case R.id.btn_3:
                setValue( concatenate(R.id.inputNumber, "3"));
                textView.setText(value);
                break;
            case R.id.btn_4:
                setValue( concatenate(R.id.inputNumber, "4"));
                textView.setText(value);
                break;
            case R.id.btn_5:
                setValue( concatenate(R.id.inputNumber, "5"));
                textView.setText(value);
                break;
            case R.id.btn_6:
                setValue( concatenate(R.id.inputNumber, "6"));
                textView.setText(value);
                break;
            case R.id.btn_7:
                setValue( concatenate(R.id.inputNumber, "7"));
                textView.setText(value);
                break;
            case R.id.btn_8:
                setValue( concatenate(R.id.inputNumber, "8"));
                textView.setText(value);
                break;
            case R.id.btn_9:
                setValue(concatenate(R.id.inputNumber, "9"));
                textView.setText(value);
                break;

            case R.id.btn_add:
                setValue(textView.getText().toString());
                if (textView.getText().equals("")){
                }else{
                    setValueOne(Float.valueOf(getValue()));
                    if (textViewNumber.getText().equals("")) {
                        setResult(getValueOne());
                        textViewNumber.setText(String.valueOf(getResult()) + "+");
                        textView.setText("");
                    }else{
                        operations(operation);
                        textViewNumber.setText(String.valueOf(getResult()) + "+");
                        textView.setText("");
                    }
                }
                operation = 1;
                break;

            case R.id.btn_mult:
                setValue(textView.getText().toString());
                if (textView.getText().equals("")){
                }else{
                    setValueOne(Float.valueOf(getValue()));
                    if (textViewNumber.getText().equals("")) {
                        setResult(getValueOne());
                        textViewNumber.setText(String.valueOf(getResult()) + "*");
                        textView.setText("");
                    }else{
                        operations(operation);
                        textViewNumber.setText(String.valueOf(getResult()) + "*");
                        textView.setText("");
                    }
                }
                operation = 2;
                break;

            case R.id.btn_div:
                setValue(textView.getText().toString());
                if (textView.getText().equals("")){

                }else{
                    setValueOne(Float.valueOf(getValue()));
                    if (textViewNumber.getText().equals("")) {
                        setResult(Float.valueOf(getValueOne()));
                        textViewNumber.setText(String.valueOf(getResult()) + "/");
                        textView.setText("");
                    }else{
                        operations(operation);
                        textViewNumber.setText(String.valueOf(getResult()) + "/");
                        textView.setText("");
                    }
                }
                operation = 3;
                break;
            case R.id.btn_subtr:
                setValue(textView.getText().toString());
                if (textView.getText().equals("") || textView.getText().equals("-")){
                    textView.setText("-");
                }else{
                    setValueOne(Float.valueOf(getValue()));
                    if (textViewNumber.getText().equals("")) {
                        setResult(getValueOne() - getResult());
                        textViewNumber.setText(String.valueOf(getResult()) + "-");
                        textView.setText("");
                    }else{
                        operations(operation);
                        textViewNumber.setText(String.valueOf(getResult()) + "-");
                        textView.setText("");
                    }
                }
                operation =4;
                break;
            case R.id.btn_clear:
                setValue(textView.getText().toString());
                if (getValue().equals("")) {}
                else{
                    setValue(getValue().substring(0, getValue().length() - 1));
                    textView.setText(getValue());
                }
                operation = 0;
                break;

            case R.id.btn_equal:
                if (textView.getText().equals("")){
                    if (textViewNumber.getText().equals("")){
                        Toast.makeText(getApplicationContext(),"Debes ingresar un valor", Toast.LENGTH_SHORT).show();
                    }else{
                        textView.setText(String.valueOf(getResult()));
                        operation = 0;
                        textViewNumber.setText("");
                    }
                }else {operations(operation);
                    textView.setText(String.valueOf(getResult()));
                    textViewNumber.setText("");
                }
                break;
        }
    }

    private void operations(int operation) {
        switch (operation){
            case 1:
                setValueOne(Float.valueOf(getValue()));
                setResult(getValueOne() + getResult());
                break;
            case 2:
                setValueOne(Float.valueOf(getValue()));
                setResult(getValueOne() * getResult());
                break;
            case 3:
                setValueOne(Float.valueOf(getValue()));
                setResult(getResult()/getValueOne());
                break;
            case 4:
                setValueOne(Float.valueOf(getValue()));
                setResult(getResult() - getValueOne());
                break;
        }

    }


    private String concatenate(int IdText, String string){
        String value = null;
        TextView textView = findViewById(IdText);
        if (textView.equals("")){
            textView.setText(string);
        }else
        {
            value = textView.getText().toString() + string;
        }

       return value;
    }


    private void conectComponent() {
        btn_0 = findViewById(R.id.btn_0);
        btn_0.setOnClickListener(this);
        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);
        btn_3 = findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);
        btn_4 = findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);
        btn_5 = findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);
        btn_6 = findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);
        btn_7 = findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);
        btn_8 = findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);
        btn_9 = findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);
        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        btn_div = findViewById(R.id.btn_div);
        btn_div.setOnClickListener(this);
        btn_mult = findViewById(R.id.btn_mult);
        btn_mult.setOnClickListener(this);
        btn_sub = findViewById(R.id.btn_subtr);
        btn_sub.setOnClickListener(this);
        btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);
        btn_equal = findViewById(R.id.btn_equal);
        btn_equal.setOnClickListener(this);
        textViewNumber = findViewById(R.id.textNumber);
        textView = findViewById(R.id.inputNumber);
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public float getValueOne() {
        return valueOne;
    }

    public void setValueOne(float valueOne) {
        this.valueOne = valueOne;
    }
}
