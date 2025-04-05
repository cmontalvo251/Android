package com.example.alscramble;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Function to convert EditText to float
    public float GetFloat(int id) {
        EditText text = (EditText) findViewById(id);
        String message = text.getText().toString();
        return Float.parseFloat(message);
    }

    public void PutFloat(int id,float val) {
        TextView textView = findViewById(id);
        String message = String.valueOf(val);
        textView.setText(message);
    }

    ///Called when user Taps the Compute Button
    public void ComputeTime(View view) {
        ///////////Get Inputs from editText Boxes
        float StartTimeHour = GetFloat(R.id.editTextStartHour);
        float StartTimeMinutes = GetFloat(R.id.editTextStartMinutes);
        float CurrentTimeHour = GetFloat(R.id.editTextCurrentHour);
        float CurrentTimeMinutes = GetFloat(R.id.editTextCurrentMinute);
        float MilesCompleted = GetFloat(R.id.editTextMilesTraveled);
        float MilesinScramble = GetFloat(R.id.editTextScrambleMiles);
        float ScrambleHours = GetFloat(R.id.editTextScrambleHours);

        //Calculated Values
        float RequiredPace = 0;
        float CurrentPace = 0;
        float CurrentTime_Minutes = 0;
        float StartTime_Minutes = 0;
        float HowLongRacing_Minutes = 0;
        float HowLongRacing_Hours = 0;
        float HowFarShouldTraveled = 0;
        float MilesAheadorBehind = 0;
        float HowLongShouldGoneBy = 0;
        float HoursAheadorBehind = 0;
        float MinutesAheadorBehind = 0;

        //Make all Calculations
        RequiredPace = MilesinScramble/ScrambleHours;
        CurrentTime_Minutes = CurrentTimeHour*60 + CurrentTimeMinutes;
        StartTime_Minutes = StartTimeHour*60 + StartTimeMinutes;
        HowLongRacing_Minutes = CurrentTime_Minutes - StartTime_Minutes;
        HowLongRacing_Hours = (float) (HowLongRacing_Minutes / 60.0);
        CurrentPace = MilesCompleted / HowLongRacing_Hours;
        HowFarShouldTraveled = HowLongRacing_Hours * RequiredPace;
        MilesAheadorBehind = MilesCompleted - HowFarShouldTraveled;
        HowLongShouldGoneBy = MilesCompleted / RequiredPace;
        HoursAheadorBehind = HowLongShouldGoneBy - HowLongRacing_Hours;
        MinutesAheadorBehind = HoursAheadorBehind * 60;

        //Put Calculations in TextViews
        PutFloat(R.id.textViewMilesAhead,MilesAheadorBehind);
        PutFloat(R.id.textViewMinutesAhead,MinutesAheadorBehind);
        PutFloat(R.id.textViewRequiredPace,RequiredPace);
        PutFloat(R.id.textViewCurrentPace,CurrentPace);
        PutFloat(R.id.textViewHoursAhead,HoursAheadorBehind);
    }

}