package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinUnitSour;
    Spinner spinUnitDes;
    TextView textDes;
    TextView textNote;
    TextView textSour;
    float rate = 1;

    String[] items={"Singapore - Dollar","Europe - Euro", "VietNam - Dong","United States - Dollar", "ThaiLan - Baht"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.buttonCE).setOnClickListener(this);
        findViewById(R.id.buttonBS).setOnClickListener(this);
        findViewById(R.id.buttonPoint).setOnClickListener(this);

        spinUnitDes= findViewById(R.id.spinUnitDes);
        spinUnitSour= findViewById(R.id.spinUnitSour);
        textNote= findViewById(R.id.txtNote);
        textDes= findViewById(R.id.txtCurDes);
        textSour= findViewById(R.id.txtCurSour);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinUnitSour.setAdapter(adapter);
        spinUnitDes.setAdapter(adapter);

        spinUnitDes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinUnitSour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        switch (id){
            case R.id.button0: {
                AddDigits("0");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.button1:{
                AddDigits("1");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.button2:{
                AddDigits("2");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.button3:{
                AddDigits("3");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.button4:{
                AddDigits("4");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.button5:{
                AddDigits("5");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.button6:{
                AddDigits("6");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.button7:{
                AddDigits("7");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.button8:{
                AddDigits("8");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.button9:{
                AddDigits("9");
                ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                break;
            }
            case R.id.buttonPoint:{
                try {
                    AddDigits(".");
                    ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                    break;
                }catch(Exception e){
                }
            }
            case R.id.buttonBS:{
                CharSequence name= textSour.getText().toString();
                if(name.length()==1){
                    textSour.setText("0");
                    textDes.setText("0");
                }
                else{
                    textSour.setText(name.subSequence(0, name.length()-1));
                    ChangeCurrency(spinUnitSour.getSelectedItem().toString(), spinUnitDes.getSelectedItem().toString(), Float.parseFloat(textSour.getText().toString()));
                }
                break;
            }
            case R.id.buttonCE:{
                textSour.setText("0");
                textDes.setText("0");
                break;
            }
        }
    }

    private void AddDigits(String digit){
        if(Float.parseFloat(textSour.getText().toString())==0)
            textSour.setText("");
        textSour.append(digit);
    }

    @SuppressLint("SetTextI18n")
    private void ChangeCurrency(String Sour, String Des, float source){
        if(Sour.equals("Singapore - Dollar") && Des.equals("Singapore - Dollar")){
            rate=1.f;
            textNote.setText("1 SGD= "+ rate + " SGD");
            textDes.setText(String.valueOf(rate*source));
        }

        if(Sour.equals("Singapore - Dollar")&& Des.equals("Europe - Euro")){
            rate= 0.6477f;
            textNote.setText("1 SGD= "+ rate + " EUR");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("Singapore - Dollar")&& Des.equals("VietNam - Dong")){
            rate= 16559.7173f;
            textNote.setText("1 SGD= "+ rate + " VNĐ");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("Singapore - Dollar")&& Des.equals("United States - Dollar")){
            rate= 0.7067f;
            textNote.setText("1 SGD= "+ rate + " USD");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("Singapore - Dollar")&& Des.equals("ThaiLan - Baht")){
            rate= 23.1025f;
            textNote.setText("1 SGD= "+ rate + " THB");
            textDes.setText(String.valueOf(rate*source));
        }

        if(Sour.equals("Europe - Euro")&& Des.equals("Singapore - Dollar")){
            rate= 1.5439f;
            textNote.setText("1 EUR= "+ rate + " SGD");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("Europe - Euro")&& Des.equals("Europe - Euro")){
            rate= 1.f;
            textNote.setText("1 EUR= "+ rate + " EUR");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("Europe - Euro")&& Des.equals("VietNam - Dong")){
            rate= 25566.8303f;
            textNote.setText("1 EUR= "+ rate + " VNĐ");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("Europe - Euror")&& Des.equals("United States - Dollar")){
            rate= 1.0911f;
            textNote.setText("1 EUR= "+ rate + " USD");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("Europe - Euro")&& Des.equals("ThaiLan - Baht")){
            rate= 35.6683f;
            textNote.setText("1 EUR= "+ rate + " THB");
            textDes.setText(String.valueOf(rate*source));
        }

        if(Sour.equals("VietNam - Dong")&& Des.equals("Singapore - Dollar")){
            rate= 0.00006039f;
            textNote.setText("1 VNĐ= "+ rate + " SGD");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("VietNam - Dong")&& Des.equals("Europe - Euro")){
            rate= 0.00003911f;
            textNote.setText("1 VNĐ= "+ rate + " EUR");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("VietNam - Dong")&& Des.equals("VietNam - Dong")){
            rate= 1.f;
            textNote.setText("1 VNĐ= "+ rate + " VNĐ");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("VietNam - Dong")&& Des.equals("United States - Dollar")){
            rate= 0.00004268f;
            textNote.setText("1 VNĐ= "+ rate + " USD");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("VietNam - Dong")&& Des.equals("ThaiLan - Baht")){
            rate= 0.001395f;
            textNote.setText("1 VNĐ= "+ rate + " THB");
            textDes.setText(String.valueOf(rate*source));
        }

        if(Sour.equals("United States - Dollar")&& Des.equals("Singapore - Dollar")){
            rate= 1.415f;
            textNote.setText("1 USD= "+ rate + " SGD");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("United States - Dollar")&& Des.equals("Europe - Euro")){
            rate= 0.9165f;
            textNote.setText("1 USD= "+ rate + " EUR");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("United States - Dollar")&& Des.equals("VietNam - Dong")){
            rate= 23432;
            textNote.setText("1 USD= "+ rate + " VND");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("United States - Dollar")&& Des.equals("United States - Dollar")){
            rate= 1.f;
            textNote.setText("1 USD= "+ rate + " USD");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("United States - Dollar")&& Des.equals("ThaiLan - Baht")){
            rate= 32.69f;
            textNote.setText("1 USD= "+ rate + " THB");
            textDes.setText(String.valueOf(rate*source));
        }

        if(Sour.equals("ThaiLan - Baht")&& Des.equals("Singapore - Dollar")){
            rate= 0.04329f;
            textNote.setText("1 THB= "+ rate + " SGD");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("ThaiLan - Baht")&& Des.equals("Europe - Euro")){
            rate= 0.02804f;
            textNote.setText("1 THB= "+ rate + " EUR");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("ThaiLan - Baht")&& Des.equals("VietNam - Dong")){
            rate= 716.7941f;
            textNote.setText("1 THB= "+ rate + " VNĐ");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("ThaiLan - Baht")&& Des.equals("United States - Dollar")){
            rate= 0.03059f;
            textNote.setText("1 THB= "+ rate + " USD");
            textDes.setText(String.valueOf(rate*source));
        }
        if(Sour.equals("ThaiLan - Baht")&& Des.equals("ThaiLan - Baht")){
            rate= 1.f;
            textNote.setText("1 THB= "+ rate + " THB");
            textDes.setText(String.valueOf(rate*source));
        }
    }
}
