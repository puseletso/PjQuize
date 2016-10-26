package com.example.android.pjquize;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.android.pjquize.R.layout.activity_category_list;

public class CategoryList extends AppCompatActivity {



    private Button buttonCountry,buttonCars,buttonGeneral;

    private EditText oldEmail, newEmail, password, newPassword;
    private ProgressBar progressBar;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_category_list);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(CategoryList.this, LoginActivity.class));
                    finish();
                }
            }
        };


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.item_userprofile:
               // Toast.makeText(CategoryList.this," UserProfile  ",Toast.LENGTH_SHORT).show();
                Intent intentUserProfile = new Intent(CategoryList.this,UserProfile.class);
                startActivity(intentUserProfile);
                finish();

                return true;

            case R.id.item_exit:
                //Toast.makeText(CategoryList.this," Exit to Login  ",Toast.LENGTH_SHORT).show();
                Intent intentLogin = new Intent(CategoryList.this,LoginActivity.class);
                startActivity(intentLogin);
                finish();

                //auth.signOut();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }



    }

    public void onClick(View v)
    {
        buttonCountry = (Button) findViewById(R.id.southAfrica_button);
        buttonCars=(Button) findViewById(R.id.cars_button);
        buttonGeneral=(Button) findViewById(R.id.general_button);





        if(v.getId()==R.id.cars_button)
        {
            Intent intent=new Intent(this, MainActivity.class);
            intent.putExtra("category",buttonCars.getText().toString());
            startActivity(intent);

        }



        if(v.getId()==R.id.southAfrica_button)
        {
            Intent intent=new Intent(this, MainActivity.class);
            intent.putExtra("category",buttonCountry.getText().toString());
            startActivity(intent);

        }

        if(v.getId()==R.id.general_button)
        {
            Intent intent=new Intent(this, MainActivity.class);
            intent.putExtra("category",buttonGeneral.getText().toString());
            startActivity(intent);

        }











    }












}
