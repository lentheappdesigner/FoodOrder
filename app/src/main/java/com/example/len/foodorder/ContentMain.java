package com.example.len.foodorder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class ContentMain extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_main);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){

        @Override
        public void onAuthStateChanged (@NonNull FirebaseAuth firebaseAuth){
            if (firebaseAuth.getCurrentUser() == null) {
                Intent loginIntent = new Intent(ContentMain.this, MainActivity.class);
                loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(loginIntent);
            }
        }
    };

}




    public void viewOrders(View view){
        startActivity(new Intent(ContentMain.this, OpenOrders.class));

    }

    public void addFoodButtonClicked(View view) {
        Intent loginIntent = new Intent(ContentMain.this, AddFood.class);
        startActivity(loginIntent);
    }

}

