package com.akh.cash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Denomination extends AppCompatActivity {
    EditText n2000, n500, n100;
    String two, five, one;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denomination);
        n2000 = (EditText) findViewById(R.id.two);
        n500 = (EditText) findViewById(R.id.five);
        n100 = (EditText) findViewById(R.id.one);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] str=new String[3];
                str[0] = n2000.getText().toString();
                str[1] = n500.getText().toString();
                str[2] = n100.getText().toString();
                //Toast.makeText(Denomination.this, "2000 : " + two + " 500 : " + five + " 100 : " + one, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Denomination.this, Display.class);
                i.putExtra("strings", str);
                startActivity(i);
            }
        });
    }
}


