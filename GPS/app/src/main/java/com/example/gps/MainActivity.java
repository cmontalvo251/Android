package com.example.gps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    public float latitude = 0;
    public float longitude = 0;

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
        latitude = event.values[0];
        longitude = event.values[1];
        DisplayNumbers();
    }

    public void DisplayNumbers() {
        ///X BOX
        TextView textViewX = findViewById(R.id.textViewLatitude);
        //x = rand.nextFloat();
        String message = String.valueOf(latitude);
        textViewX.setText(message);
        //Y BOX
        TextView textViewY = findViewById(R.id.textViewLongitude);
        //y = rand.nextFloat();
        String messagey = String.valueOf(longitude);
        textViewY.setText(messagey);
    }

    //Called when user hits the set origin button
    public void SetOrigin(View view) {
        DisplayNumbers();
    }
}
