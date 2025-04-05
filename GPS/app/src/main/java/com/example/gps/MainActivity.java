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
    public float latitude_origin = 0;
    public float longitude_origin = 0;
    public float time = 0;

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
        time = 0;
        DisplayNumbers();
    }

    public void DisplayNumbers() {
        //Time BOX
        TextView textViewTime = findViewById(R.id.textViewTime);
        String messageTime = String.valueOf(time);
        textViewTime.setText(messageTime);
        ///Latitude BOX
        TextView textViewLAT = findViewById(R.id.textViewLatitude);
        String messageLAT = String.valueOf(latitude);
        textViewLAT.setText(messageLAT);
        //Longitude BOX
        TextView textViewLON = findViewById(R.id.textViewLongitude);
        String messageLON = String.valueOf(longitude);
        textViewLON.setText(messageLON);
    }

    //Called when user hits the set origin button
    public void SetOrigin(View view) {
        latitude_origin = latitude;
        longitude_origin = longitude;
        ///Latitude BOX
        TextView textViewLATO = findViewById(R.id.textViewLatitudeOrigin);
        String messageLATO = String.valueOf(latitude_origin);
        textViewLATO.setText(messageLATO);
        //Longitude BOX
        TextView textViewLONO = findViewById(R.id.textViewLongitudeOrigin);
        String messageLONO = String.valueOf(longitude_origin);
        textViewLONO.setText(messageLONO);
    }
}
