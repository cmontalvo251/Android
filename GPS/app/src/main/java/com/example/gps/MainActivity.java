package com.example.gps;

import java.lang.Math;

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
    public double latitude = 0;
    public double longitude = 0;
    public double latitude_origin = -99;
    public double longitude_origin = -99;
    public double time = 0;
    public double time_prev = 0;
    public double X = 0;
    public double x_prev = 0;
    public double Y = 0;
    public double y_prev = 0;
    public double VX = 0;
    public double VY = 0;
    public double V = 0;
    public double v_prev = 0;
    public double D = 0;
    public boolean LATLONSET = false;

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
        time+=1;
        if (LATLONSET) {
            Compute();
        }
        DisplayNumbers();
    }

    public void Compute() {
        //First convert Latitude and longitude to X and Y
        double NM2FT= 6076.115485560000F;
        double FT2M= 0.3048F;
        X = (latitude - latitude_origin)*60*NM2FT*FT2M; //#%%//North direction - Xf , meters
        Y = (longitude - longitude_origin)*60*NM2FT*FT2M*Math.cos(latitude_origin*Math.PI/180.0); //#%%//East direction - Yf, meters
        //Then compute velocity in the X and Y directions
        double dx = (X-x_prev)*3.28/5280.0; //convert to miles
        double dy = (Y-y_prev)*3.28/5280.0; //convert to miles
        double dt = (time - time_prev)/3600.0; //convert to hours
        VX = dx / dt;
        VY = dy / dt;
        //Compute the total velocity
        double v_new = Math.sqrt(VX*VX + VY*VY);
        //Filter the signal
        double s = 0.5;
        V = s*v_new + (1-s)*v_prev;
        //Compute total distance traveled
        D += Math.sqrt(dx*dx+dy*dy);
        //Then reset prev values
        x_prev = X;
        y_prev = Y;
        time_prev = time;
        v_prev = V;
    }

    public void DisplayNumbers() {
        //Time BOX
        TextView textViewTime = findViewById(R.id.textViewTime);
        String messageTime = String.valueOf(time);
        textViewTime.setText(messageTime);
        ///Latitude BOX
        TextView textViewLAT = findViewById(R.id.textViewLatitude);
        String messageLAT = String.format("%.4f",latitude);
        textViewLAT.setText(messageLAT);
        //Longitude BOX
        TextView textViewLON = findViewById(R.id.textViewLongitude);
        String messageLON = String.format("%.4f",longitude);
        textViewLON.setText(messageLON);
        //Current X position
        TextView textViewX = findViewById(R.id.textViewX);
        String messageX = String.format("%.4f",X);
        textViewX.setText(messageX);
	    //Current Y position
        TextView textViewY = findViewById(R.id.textViewY);
        String messageY = String.format("%.4f",Y);
        textViewY.setText(messageY);
	    //Current velocity X
        TextView textViewVX = findViewById(R.id.textViewVX);
        String messageVX = String.format("%.4f",VX);
        textViewVX.setText(messageVX);
	    //Current velocity Y
        TextView textViewVY = findViewById(R.id.textViewVY);
        String messageVY = String.format("%.4f",VY);
        textViewVY.setText(messageVY);
	    //Current velocity
        TextView textViewV = findViewById(R.id.textViewV);
        String messageV = String.format("%.4f",V);
        textViewV.setText(messageV);
	    //Current Distance
        TextView textViewD = findViewById(R.id.textViewD);
        String messageD = String.format("%.4f",D);
        textViewD.setText(messageD);
    }

    //Called when user hits the set origin button
    public void Reset(View view) {
        latitude_origin = latitude;
        longitude_origin = longitude;
        //LATLONSET variable
        LATLONSET = true;
        ///Latitude BOX
        TextView textViewLATO = findViewById(R.id.textViewLatitudeOrigin);
        String messageLATO = String.format("%.4f",latitude_origin);
        textViewLATO.setText(messageLATO);
        //Longitude BOX
        TextView textViewLONO = findViewById(R.id.textViewLongitudeOrigin);
        String messageLONO = String.format("%.4f",longitude_origin);
        textViewLONO.setText(messageLONO);
        //Reset X,Y,VX,VY,V and D
        X = 0;
        x_prev = 0;
        Y = 0;
        y_prev = 0;
        VX = 0;
        VY = 0;
        V = 0;
        v_prev = 0;
        D = 0;
    }
}
