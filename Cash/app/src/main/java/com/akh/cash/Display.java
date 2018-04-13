package com.akh.cash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Display extends AppCompatActivity {
EditText two,five,one,total;
    String tot;
    Integer t1,t2,t3,t;
    Button confirm;
    private FirebaseAuth auth;
    private DatabaseReference data;
    Map mp;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        mp = new HashMap();
        data= FirebaseDatabase.getInstance().getReference();
        user=FirebaseAuth.getInstance().getCurrentUser();
        data.child("UserDetails").child(user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mp=(HashMap)dataSnapshot.getValue();
                System.out.println("user"+mp);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Intent intent = getIntent();
        String[] str = intent.getStringArrayExtra("strings");
        two=(EditText)findViewById(R.id.two2);
        five=(EditText)findViewById(R.id.five5);
        one=(EditText)findViewById(R.id.one1);
        total=(EditText)findViewById(R.id.total) ;
        confirm=(Button)findViewById(R.id.confirm);
        t1=Integer.parseInt(str[0])*2000;
        two.setText(t1.toString());
        t2=Integer.parseInt(str[1])*500;
        five.setText(t2.toString());
        t3=Integer.parseInt(str[2])*100;
        one.setText(t3.toString());
        t=(Integer.parseInt(str[0])*2000)+(Integer.parseInt(str[1])*500)+(Integer.parseInt(str[2])*100);
        tot=t.toString();
        total.setText(tot);
        confirm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(Display.this, "Success", Toast.LENGTH_SHORT).show();

                mp.put("two",t1);
                mp.put("five",t2);
                mp.put("one",t3);
                mp.put("total",t);
               FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser();
                Log.i("user","sdhsidhsd");
                Log.i("userid",user.getUid());
               String uid=user.getUid();
                System.out.println("user"+mp);
              //  System.out.print("userid : "+uid);
               data.child("UserDetails").child(uid).setValue(mp);
            }
        });

    }
}

