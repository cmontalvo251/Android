package com.example.readaccel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    Random rand = new Random();
    boolean RUN = false;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    public float x = 0;
    public float y = 0;
    public float z = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        if (RUN) {
            DisplayNumbers();
        }
    }

    public void DisplayNumbers() {
        ///X BOX
        TextView textViewX = findViewById(R.id.textViewX);
        //x = rand.nextFloat();
        String message = String.valueOf(x);
        textViewX.setText(message);
        //Y BOX
        TextView textViewY = findViewById(R.id.textViewY);
        //y = rand.nextFloat();
        String messagey = String.valueOf(y);
        textViewY.setText(messagey);
        //Z BOX
        TextView textViewZ = findViewById(R.id.textViewZ);
        //z = rand.nextFloat();
        String messagez = String.valueOf(z);
        textViewZ.setText(messagez);
    }

    /** Called when the user taps the Send button */
    public void GenerateNumbers(View view) {
        RUN = true;
        DisplayNumbers();
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