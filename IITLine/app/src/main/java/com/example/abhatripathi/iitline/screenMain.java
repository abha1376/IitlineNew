package com.example.abhatripathi.iitline;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class screenMain extends AppCompatActivity {
    Button btn,btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_screen_one);
        btn = findViewById(R.id.mathsm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmaths();
            }
        });
//        btn1=findViewById(R.id.chemistrym);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openchem();
//            }
//        });
//        btn2=findViewById(R.id.physicsm);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openphy();
//            }
//        });
//        btn=findViewById(R.id.chemistrym);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openmaths();
//            }
//        });
//    }

    }


    public void openchem() {
        Intent i = new Intent(this, chemistry.class);
        startActivity(i);
    }

    public void openphy() {
        Intent i = new Intent(this, physics.class);
        startActivity(i);
    }
    public void openmaths() {
        Intent i = new Intent(this, maths.class);
        startActivity(i);
    }
}
