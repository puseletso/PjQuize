package com.example.android.pjquize;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;



public class resultsPage extends AppCompatActivity {

    Button button;
    private String totalCorrect;
    private String totalInCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);

        addListenerOnButton();


        Intent intent2 = getIntent();

        //  totalCorrect = Integer.parseInt(intent2.getStringExtra("totalCorrect"));
        //  totalInCorrect = Integer.parseInt(intent2.getStringExtra("totalInCorrect"));

        totalCorrect = intent2.getStringExtra("vIntenttotalCorrect");
        totalInCorrect = intent2.getStringExtra("vIntenttotalIncorrect");


        // ===============================================totalCorrect_textview

        TextView textView = (TextView) findViewById(R.id.totalCorrect_textview);

        textView.setText("Correct answers :" + totalCorrect);


        // ===============================================IncorrectCorrect_textview

        TextView textView2 = (TextView) findViewById(R.id.totalIncorrect_textview);

        textView2.setText("Incorrect answers :" + totalInCorrect);


    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.backtocategories_button);

        button.setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View arg0) {

                        Intent intent = new Intent(context, CategoryList.class);
                        startActivity(intent);

                    }

                });


    }



}
