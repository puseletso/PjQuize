package com.example.android.pjquize;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;


public class StartGamePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        addListenerOnButton();


    }


    public void addListenerOnButton() {

        final Context context = this;

        Button button = (Button) findViewById(R.id.start_page_button);

        button.setOnClickListener(
                new OnClickListener()
        {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, CategoryList.class);
                startActivity(intent);

            }

        });

    }
}
