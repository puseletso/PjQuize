package com.example.android.pjquize;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    //-----------------------------------------------variables declaration
    private int currentQuestion;
    private String[] questions;
    private String category;
    private String[] answers;
    private Button answerButton;
    private TextView questionView;
    private EditText answerText;
    private int totalCorrect = 0;
    private int totalIncorrect = 0;
    private String[] images;
    private ImageView ivImage;

    //---------------------------------------------------end variable declaration


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //===============================================array for column memo





//------------------------------------------------intent to get variable from category activity
        Intent intent2 = getIntent();

        category = intent2.getStringExtra("category");

//--------------------------------------------------------end of intent


//----------------------------------------------------------------------------------view category selected from received intent varable categroy
        TextView textView = (TextView) findViewById(R.id.category_label_textView);
        textView.setText("Category selected - " + category);


        //----------------------------call int method
        init();


    }


    //=======================================================================================================   start public void init()
    public void init() {
        currentQuestion = 0;
//====================================================================================country array
        if (category.equals("South Africa")) {

            questions = new String[]{"which province is south africa union building located ",
                    "how many  are the offical lanuages of south africa",
                    "what is the administravie capital city  of south africa ",
                    "how many provinces does South Africa have",
                    "Which year was the first democratic  election held in south africa",
                    "What is the leading party in sotuh africa",
                    "What is the smallest province in south africa",
                    "Which campany generates two-thirds of south africa electricity",
                    "Which university is the largest correspondence university in the world",
                    "The first MBA program outside of the US was started by which University"};


            answers = new String[]{"gauteng",
                    "11",
                    "pretoria",
                    "9",
                    "1994",
                    "anc",
                    "gauteng",
                    "eskom",
                    "unisa",
                    "universityofpretoria"
            };

            images = new String[]{"android.resource://com.example.android.pjquize/" + R.drawable.unionbuilding,
                    "android.resource://com.example.android.pjquize/" + R.drawable.officallanuages,
                    "android.resource://com.example.android.pjquize/" + R.drawable.capitalcity,
                    "android.resource://com.example.android.pjquize/" + R.drawable.provinces,
                    "android.resource://com.example.android.pjquize/" + R.drawable.election,
                    "android.resource://com.example.android.pjquize/" + R.drawable.leadingparty,
                    "android.resource://com.example.android.pjquize/" + R.drawable.smallestprovince,
                    "android.resource://com.example.android.pjquize/" + R.drawable.electricity,
                    "android.resource://com.example.android.pjquize/" + R.drawable.correspondenceuniversity,
                    "android.resource://com.example.android.pjquize/" + R.drawable.mbaprogram};


        }

        if (category.equals("cars")) {

            questions = new String[]{"Which campany manufactures Rolls-Royce  ",
                    "what is the fastest car in the world",
                    "what is the second fastest car in the world",
                    "who invented the first car",
                    "which highway in germany has no speed limit",
                    "what is the toughest onroad vehicle in the world",
                    "what is the  world's first car that can be driven both on land and under water",
                    "In which country it’s a criminal offense to drive around in dirty car",
                    "what is the most bought car brand in south africa",
                    "What is the top selling car in the wolrd."};

            answers = new String[]{"bmw",
                    "hennessey",
                    "bugatti",
                    "karl benz",
                    "autobahn",
                    "marauder",
                    "rinspeed",
                    "russia",
                    "vw",
                    "toyota"};


            images = new String[]{"android.resource://com.example.android.pjquize/" + R.drawable.bmw,
                    "android.resource://com.example.android.pjquize/" + R.drawable.hennessey,
                    "android.resource://com.example.android.pjquize/" + R.drawable.hennessey,
                    "android.resource://com.example.android.pjquize/" + R.drawable.karlbenz,
                    "android.resource://com.example.android.pjquize/" + R.drawable.autobahn,
                    "android.resource://com.example.android.pjquize/" + R.drawable.marauder,
                    "android.resource://com.example.android.pjquize/" + R.drawable.rinspeed,
                    "android.resource://com.example.android.pjquize/" + R.drawable.russia,
                    "android.resource://com.example.android.pjquize/" + R.drawable.vw,
                    "android.resource://com.example.android.pjquize/" + R.drawable.toyota};


        }



        if (category.equals("general")) {

            questions = new String[]{"What falling object is said to have inspired Isaac Newton's theories about gravity?   ",
                    "What color is a NYC taxi?",
                    "Where in the world does the largest tropical rainforest grow?",
                    "Which logo on a flag identifies a ship's crew as pirates?",
                    "In which country do the famous pyramids of Giza stand?",
                    "What kind of reptile is the chameleon?",
                    "What used to advertise its products as \"Fingerlickin good\"?",
                    "In the Arabian Nights, who met with 40 thieves?",
                    "According to the fairy tale, who had to leave the ball before midnight",
                    "What cord connects a fetus with the placenta?"};
            answers = new String[]{"Apple",
                    "Yellow",
                    "Amazon",
                    "Skullandcrossbones",
                    "Egypt",
                    "Lizard",
                    "KentuckyFriedChicken",
                    "AliBaba",
                    "Cinderella",
                    "Umbilicalcord"};


            images = new String[]{"android.resource://com.example.android.pjquize/" + R.drawable.apple,
                    "android.resource://com.example.android.pjquize/" + R.drawable.yellow,
                    "android.resource://com.example.android.pjquize/" + R.drawable.amazon,
                    "android.resource://com.example.android.pjquize/" + R.drawable.skullandcrossbones,
                    "android.resource://com.example.android.pjquize/" + R.drawable.egypt,
                    "android.resource://com.example.android.pjquize/" + R.drawable.lizard,
                    "android.resource://com.example.android.pjquize/" + R.drawable.kentuckyfriedchicken,
                    "android.resource://com.example.android.pjquize/" + R.drawable.alibaba,
                    "android.resource://com.example.android.pjquize/" + R.drawable.cinderella,
                    "android.resource://com.example.android.pjquize/" + R.drawable.umbilicalcord};


        }


        //================================================================declare xml content
        answerButton = (Button) findViewById(R.id.answer_button);

        questionView = (TextView) findViewById(R.id.question_textView);


        questionView.setText(questions[0]);




        answerText = (EditText) findViewById(R.id.answer_editText);

        ivImage = (ImageView) findViewById(R.id.unionbuilding_imageView);

        Picasso.with(MainActivity.this).load(Uri.parse(images[0])).into(ivImage);


//============================================================================initialse answerButton
        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                checkAnswer();


            }

        });


    }
    //============================================================================================================end of public void inti() method


    //==========================================================end show question method

    //--------------------------------------------------------------------------------------------------start check Answert method
    public void checkAnswer() {


//==============================================get answer from editText
        // String storeAnswerCheck = "no answer";


        String userAnswer = answerText.getText().toString();
        userAnswer=(userAnswer.replaceAll("\\s+",""));

        /*
        if(userAnswer.replaceAll("\\s+","").equalsIgnoreCase(userAnswer.replaceAll("\\s+",""))) {
            // this will also take care of spaces like tabs etc.
        }
        */

       // if (userAnswer.equalsIgnoreCase(answers[currentQuestion])) -->dont use this because it takes spaces as characters
         if (userAnswer.equalsIgnoreCase(answers[currentQuestion]))
            {




            if ((userAnswer != ""))// && (storeAnswerCheck != userAnswer)))
            {

                currentQuestion++;
                totalCorrect++;


                //============================================================this if statement checks if its the last index of the array
                if (currentQuestion == questions.length) {
                    currentQuestion = 0;
                    //------------------------------------------------------------------------------intent sending variables to result activity


                    Intent intent = new Intent(this, resultsPage.class);
                    intent.putExtra("vIntenttotalCorrect", "" + totalCorrect);
                    intent.putExtra("vIntenttotalIncorrect", "" + totalIncorrect);

                    startActivity(intent);
                    //-----------------------------------------------------------------------------end intent
                }


                // storeAnswerCheck = userAnswer;


                Button button = (Button) findViewById(R.id.correct_button);
                button.setText("Correct:" + totalCorrect);


            }


            //=============================================increment to the next question


            questionView.setText(questions[currentQuestion]);

            answerText.setText("");


        }
        else
        {
            if (userAnswer.isEmpty())
            {

                Toast toast = Toast.makeText(MainActivity.this, "answer question first ", Toast.LENGTH_SHORT);
                toast.show();


            }
            else
            {


                totalIncorrect++;
                //  storeAnswerCheck = userAnswer;

                Button button = (Button) findViewById(R.id.incorrect__button);
                button.setText("Incorrect:" + totalIncorrect);


                //=============================================increment to the next question

                currentQuestion++;


                //============================================================this if statement checks if its the last index of the array
                if (currentQuestion == questions.length) {
                    currentQuestion = 0;
                    //------------------------------------------------------------------------------intent sending variables to result activity
                    Intent intent = new Intent(this, resultsPage.class);
                    intent.putExtra("vIntenttotalCorrect", "" + totalCorrect);
                    intent.putExtra("vIntenttotalIncorrect", "" + totalIncorrect);

                    startActivity(intent);
                    //-----------------------------------------------------------------------------end intent
                }


                questionView.setText(questions[currentQuestion]);

                answerText.setText("");

            }
        }
        Picasso.with(MainActivity.this).load(Uri.parse(images[currentQuestion])).into(ivImage);

    }


//--------------------------------------------------------------------------------------------------end check Answert method

}





/*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        }, 2000);
        */


