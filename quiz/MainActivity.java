package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textQuestion, textAnswer;
    private Button btnQues,btnAns;

    private String[] questions = {
            "What does CPU stand for?",
            "What is the full form of URL",
            "What device is used to move the cursor on a computer?",
            "What is the capital of India?"
    };

    private String[] answers = {
            "Central Processing Unit.",
            "Uniform Resource Locator.",
            "A mouse.",
            "India"
    };

    private int curredtIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textQuestion = findViewById(R.id.Question);
        textAnswer = findViewById(R.id.Answer);
        btnQues = findViewById(R.id.question_button);
        btnAns = findViewById(R.id.AnswerButton);

        btnQues.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               textQuestion.setText(questions[curredtIndex]);
               textAnswer.setText("");
            }
        });

        btnAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAnswer.setText(answers[curredtIndex]);

                curredtIndex++;
                if(curredtIndex>=questions.length){
                    curredtIndex = 0;
                }
            }
        });

    }
}