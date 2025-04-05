package com.example.myfirstapp;

///MODULES REQUIRED FOR THIS APP
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //This is the extra message variable we will use in the sendMessage function below
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    //DO NOT EDIT THIS CODE HERE. THIS OPENS THE APP
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /////////////////////////////////////////////////


    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //GRAB THE TEST FROM THE TEXT BOX. NOTE THE TEXT BOX NAME
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        //CONVERT THE TEST TO A STRING
        String message = editText.getText().toString();
        //PUT MESSAGE INTO EXTRA_MESSAGE
        intent.putExtra(EXTRA_MESSAGE, message);
        //STARTACTIVITY???
        startActivity(intent);
    }
}