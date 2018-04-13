package com.akh.cash;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText email,pass;
    Button log;
    String em,pas;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        email=(EditText) findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.pass);

        log=(Button)findViewById(R.id.login) ;
        log.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        em=email.getText().toString();
        pas=pass.getText().toString();

 mAuth.signInWithEmailAndPassword(em,pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
     @Override
     public void onComplete(@NonNull Task<AuthResult> task) {
         if(task.isSuccessful()){
             Intent i = new Intent(MainActivity.this, Atm.class);
             startActivity(i);
         }
         else
             Toast.makeText(MainActivity.this, "Invalid Credentials!!!", Toast.LENGTH_SHORT).show();

 }});
    }
}
