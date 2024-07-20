package com.example.randomquestions;

///For Android Version 11.0+
import androidx.appcompat.app.AppCompatActivity;
//For Android Version 9.0
//import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.CallAudioState;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    List<String> Questions = new ArrayList<String>();
    int NumberOfQuestions = 0;
    int index = 0;
	//Create Question Classes
	Politics_and_Religion PR = new Politics_and_Religion();
	Family_Friendly FF = new Family_Friendly();
	Casually_Dating CD = new Casually_Dating();
	Seriously_Dating SD = new Seriously_Dating();
	XRated XR = new XRated();
	Marriage M = new Marriage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**Called Everytime a question changes**/
    public void SetQuestionCounter(View view) {
        TextView textViewNumbers = findViewById(R.id.textViewNUMBERS);
        String messageNumbers = "Question " + String.valueOf(index) + " out of " + String.valueOf(NumberOfQuestions);
        textViewNumbers.setText(messageNumbers);
    }

    /** Called when the user taps the Send button */
    public void GenerateQuestions(View view) {
        TextView textViewX = findViewById(R.id.textViewX);
		String message = "You need to hit the reset button first";
		if (NumberOfQuestions > 0) {
			message = Questions.get(index);
			index += 1;
			if (index > NumberOfQuestions - 1) {
				index = 0;
			}
		}
        textViewX.setText(message);
        SetQuestionCounter(view);
    }

    /** Called When user hits the reset button **/
    public void Reset(View view) {
		//Reset number of questions
		NumberOfQuestions = 0;
		Questions.clear();
		//Check status of switches
		Switch swFF = (Switch) findViewById(R.id.switchFF);
		boolean isCheckedFF = swFF.isChecked();
		if (isCheckedFF) {
			// The toggle is enabled
			FF.AddQuestions(Questions);
		}
		Switch swPR = (Switch) findViewById(R.id.switchPR);
		boolean isCheckedPR = swPR.isChecked();
		if (isCheckedPR) {
			// The toggle is enabled
			PR.AddQuestions(Questions);
		}
		Switch swCD = (Switch) findViewById(R.id.switchCD);
		boolean isCheckedCD = swCD.isChecked();
		if (isCheckedCD) {
			// The toggle is enabled
			CD.AddQuestions(Questions);
		}
		Switch swSD = (Switch) findViewById(R.id.switchSD);
		boolean isCheckedSD = swSD.isChecked();
		if (isCheckedSD) {
			// The toggle is enabled
			SD.AddQuestions(Questions);
		}
		Switch swXR = (Switch) findViewById(R.id.switchXR);
		boolean isCheckedXR = swXR.isChecked();
		if (isCheckedXR) {
			// The toggle is enabled
			XR.AddQuestions(Questions);
		}
		Switch swM = (Switch) findViewById(R.id.switchM);
		boolean isCheckedM = swM.isChecked();
		if (isCheckedM) {
			//Questions to ask before you get married
			M.AddQuestions(Questions);
		}
		//////////////UPDATE NUMBER OF QUESTIONS//////////////
		index = 0;
		NumberOfQuestions = Questions.size();
		SetQuestionCounter(view);
		//////////////UPDATE TEXT///////////////////////////
		TextView textViewX = findViewById(R.id.textViewX);
		String message = "Default";
		if (NumberOfQuestions == 0) {
			message = "You need to switch one of the toggles below!!!";
		} else {
			message = "Resetting Questions!!!";
			Collections.shuffle(Questions);
		}
        textViewX.setText(message);
    }
}
