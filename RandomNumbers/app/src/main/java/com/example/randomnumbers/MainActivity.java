package com.example.randomnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    boolean RUN = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void GenerateNumbers(View view) {
        RUN = true;
        ///X BOX
        TextView textViewX = findViewById(R.id.textViewX);
        float x = rand.nextFloat();
        String message = String.valueOf(x);
        textViewX.setText(message);
        //Y BOX
        TextView textViewY = findViewById(R.id.textViewY);
        float y = rand.nextFloat();
        String messagey = String.valueOf(y);
        textViewY.setText(messagey);
        //Z BOX
        TextView textViewZ = findViewById(R.id.textViewZ);
        float z = rand.nextFloat();
        String messagez = String.valueOf(z);
        textViewZ.setText(messagez);
    }
    public void Stop(View view) {
        RUN = false;
        TextView textViewX = findViewById(R.id.textViewX);
        String message = "";
        textViewX.setText(message);
        //Y BOX
        TextView textViewY = findViewById(R.id.textViewY);
        String messagey = "";
        textViewY.setText(messagey);
        //Z BOX
        TextView textViewZ = findViewById(R.id.textViewZ);
        String messagez = "";
        textViewZ.setText(messagez);
    }
}