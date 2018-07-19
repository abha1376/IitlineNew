package com.example.abhatripathi.iitline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class FragmentQues extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ques,container,false);

            final Button btnSubmit1 = findViewById(R.id.radioButton1);
        final Button btnSubmit2 = findViewById(R.id.radioButton2);
        final Button btnSubmit3 = findViewById(R.id.radioButton3);
        final Button btnSubmit4 = findViewById(R.id.radioButton4);

            final FirebaseDatabase firebaseDatabase = FirebaseDatabase.
                    getInstance();

            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

            firebaseAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    // This is called in 3 scenarious :
                    // 1. As soon as you attach the listener
                    // 2. When the user logs in
                    // 3. When the user logs out

                    //Check to see if the user is logged in?
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

                    if (firebaseUser == null) {
                        //An unauthenticated user is using the app
                        //Log the user in
                        //Use this to sign the user out
//                    AuthUI.getInstance().signOut(getBaseContext());
                        Intent loginIntent = AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setIsSmartLockEnabled(false)
                                .setAvailableProviders(Arrays.asList(
                                        new AuthUI.IdpConfig.GoogleBuilder().build(),
//                                    new AuthUI.IdpConfig.FacebookBuilder().build(),
//                                    new AuthUI.IdpConfig.TwitterBuilder().build(),
//                                    new AuthUI.IdpConfig.GitHubBuilder().build(),
                                        new AuthUI.IdpConfig.EmailBuilder().build(),
                                        new AuthUI.IdpConfig.PhoneBuilder().build())
                                )
                                .build();
                        startActivity(loginIntent);
                    } else {


                        final DatabaseReference rootRef = firebaseDatabase.getReference();

                        final DatabaseReference childRef = rootRef.child(firebaseUser.getUid());
                        final EditText etName = findViewById(R.id.etName);
                        childRef.addChildEventListener(MainActivity.this);
                        //An authenticated user is using the app
                        btnSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String name = etName.getText().toString();
                                Task task = new Task(System.currentTimeMillis(), name, "Test");

                                //Calling push() will create a random key for us

//                DatabaseReference pushRef = childRef.push();

//                childRef.child("dfjdhdhjfh");

//                            com.google.android.gms.tasks.Task<Void> asyncTask;

                                childRef.push().setValue(task);
//                            asyncTask.addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    //The data push was completed successfully
//                                }
//                            }).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> task) {
//                                    //This will always be called, similar to the `finally` block in java
//                                }
//                            });

                                //Push the content of EditText to my Firebase DB
                            }
                        });
                    }

                }
            });


        }

        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            Task myTask = dataSnapshot.getValue(Task.class);
            Log.e("TAG", "onChildAdded: " + myTask.getTitle());
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    }


