package com.example.randomquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    List<String> Questions = new ArrayList<String>();
    float NumberOfQuestions = 0;
    int index = 0;
    boolean RUN = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Questions.add("What's your sign?");
        Questions.add("What is your favorite color?");
        Questions.add("What's your favorite food?");
        Questions.add("How do you handle surprises?");
        Questions.add("Desribe your childhood trauma");
        Questions.add("What do you wish for our relationship?");
        Questions.add("Have you ever cheated on a past partner?");
        Questions.add("What are ten things you would bring to a desert island?");
        Questions.add("What is your favorite movie?");
        Questions.add("What do you admire most about me?");
        Questions.add("What do I do that irritates you the most?");
        Questions.add("What do I do that turns you on the most?");
        Questions.add("Chocolate or Flowers");
        Questions.add("What are your love languages?");
        Questions.add("Neflix and Chill or Night out?");
        Questions.add("What's a new hobby you'd like to try?");
        Questions.add("If you could change on thing about your looks what would it be?");
        Questions.add("What's an emabrassing fashion moment?");
        Questions.add("Would you rather give up music or TV for a month?");
        Questions.add("Tell me about your first crush");
        Questions.add("When did you parents talk to you about sex?");
        Questions.add("If you had one day left to live what would you do?");
        Questions.add("What's your deepest fear?");
        Questions.add("Do you go to therapy?");
        Questions.add("Do you go to church?");

        NumberOfQuestions = Questions.size();
        Collections.shuffle(Questions);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void GenerateQuestions(View view) {
        RUN = true;
        ///X BOX
        TextView textViewX = findViewById(R.id.textViewX);
        String message = Questions.get(index);
        index+=1;
        if (index > NumberOfQuestions-1) {
            index = 0;
        }
        textViewX.setText(message);
    }
    public void Reset(View view) {
        RUN = false;
        TextView textViewX = findViewById(R.id.textViewX);
        String message = "Resetting Questions!!!";
        textViewX.setText(message);
        Collections.shuffle(Questions);
    }
}
