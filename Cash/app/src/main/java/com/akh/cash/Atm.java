package com.akh.cash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Atm extends AppCompatActivity implements View.OnClickListener{
    EditText code;
    Button submt;
    String cod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm);
        code=(EditText)findViewById(R.id.code);
submt=(Button)findViewById(R.id.submit);
        submt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        cod=code.getText().toString();
        if(cod.equals("KOT_MAC_ECE")){
            Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(Atm.this, Denomination.class);
            startActivity(in);
        }
        else
            Toast.makeText(this, "Invalid ATM code!!!", Toast.LENGTH_SHORT).show();
    }
}
