package com.example.gps;

import java.lang.Math;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private LocationManager locationManager;
    private LocationListener locationListener;
    public double latitude = 0;
    public double longitude = 0;
    public double latitude_origin = -99;
    public double longitude_origin = -99;
    public double gps_speed = 0;
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
    public double startTime = -99;
    //Create a handler to update the numbers
    public Handler handler = new Handler();
    public Runnable runnable;
    public static final int LOOP_INTERVAL_MS = 100; // 100 ms = 10 Hz

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize Sensor Manager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //Initialize Accelerometer
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Initialize GPS
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                gps_speed = location.getSpeed()*2.23694; //convert from m/s to mph
            }
        };
        //Start the GPS
        startGPS();
        //Get the start time
        startTime = System.currentTimeMillis() / 1000.0;
        //Kick off the runnable function to run at a set loop interval
        runnable = new Runnable() {
            @Override
            public void run() {
                //Get time elapsed from start time
                time = System.currentTimeMillis() / 1000.0 - startTime;
                //If LATLON origin has been set, start computing
                if (LATLONSET) {
                    Compute();
                }
                //No matter what update the numbers you've got.
                DisplayNumbers();
                //Then execute the run() function again after the loop interval
                handler.postDelayed(this,LOOP_INTERVAL_MS);
            }
        };
        //Don't forget to actually start the loop
        handler.post(runnable);
    }

    //Make sure you kill the runnable on destroy
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the loop when the activity is destroyed
        handler.removeCallbacks(runnable);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Resume the Accelerometer
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        //Resume GPS
        startGPS();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Pause the accelerometer
        sensorManager.unregisterListener(this);
        //Pause the GPS
        locationManager.removeUpdates(locationListener);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
       //Nothing for the accelerometer. This is here because of archaic code
    }

    public void startGPS() {
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, locationListener);
        }
    }

    public void Compute() {
        //First convert Latitude and longitude to X and Y
        double NM2MI = 1.15078F;
        double X_new = (latitude - latitude_origin)*60*NM2MI; //#%%//North direction - Xf , miles
        double Y_new = (longitude - longitude_origin)*60*NM2MI*Math.cos(latitude_origin*Math.PI/180.0); //#%%//East direction - Yf, miles
        //Then compute velocity in the X and Y directions
        double dx = (X_new-x_prev);
        double dy = (Y_new-y_prev);
        double dt = (time - time_prev)/3600.0; //convert to hours
        double D_add = Math.sqrt(dx*dx+dy*dy);
        double VX_new = dx / dt;
        double VY_new = dy / dt;
        //Compute the total velocity
        double v_new = Math.sqrt(VX_new*VX_new + VY_new*VY_new);
        //Throw out velocities that are ridiculous
        if (v_new > 200) {
            //My car won't even do 200 mph
            return;
        }
        //Also just return if you haven't moved enough
        if (D_add < 0.01) {
            return;
        }
        //Otherwise reset the values
        X = X_new;
        Y = Y_new;
        VX = VX_new;
        VY = VY_new;
        //But make sure to compute heading
        //Filter the signal
        double s = 0.5;
        V = s*v_new + (1-s)*v_prev;
        //Compute total distance traveled
        D += D_add;
        //Then reset prev values
        x_prev = X;
        y_prev = Y;
        time_prev = time;
        v_prev = V;
    }

    public void DisplayNumbers() {
        //Time BOX
        TextView textViewTime = findViewById(R.id.textViewTime);
        String messageTime = String.format("%.2f",time);
        textViewTime.setText(messageTime);
        ///Latitude BOX
        TextView textViewLAT = findViewById(R.id.textViewLatitude);
        String messageLAT = String.format("%.5f",latitude);
        textViewLAT.setText(messageLAT);
        //Longitude BOX
        TextView textViewLON = findViewById(R.id.textViewLongitude);
        String messageLON = String.format("%.5f",longitude);
        textViewLON.setText(messageLON);
        //Current X position
        TextView textViewX = findViewById(R.id.textViewX);
        String messageX = String.format("%.2f",X);
        textViewX.setText(messageX);
	    //Current Y position
        TextView textViewY = findViewById(R.id.textViewY);
        String messageY = String.format("%.2f",Y);
        textViewY.setText(messageY);
	    //Current velocity X
        TextView textViewVX = findViewById(R.id.textViewVX);
        String messageVX = String.format("%.2f",VX);
        textViewVX.setText(messageVX);
	    //Current velocity Y
        TextView textViewVY = findViewById(R.id.textViewVY);
        String messageVY = String.format("%.2f",VY);
        textViewVY.setText(messageVY);
	    //Current velocity
        TextView textViewV = findViewById(R.id.textViewV);
        String messageV = String.format("%.2f",V);
        textViewV.setText(messageV);
        //Velocity Directly from GPS
        TextView textViewGPSV = findViewById(R.id.textViewGPSV);
        String messageGPSV = String.format("%.2f",gps_speed);
        textViewGPSV.setText(messageGPSV);
	    //Current Distance
        TextView textViewD = findViewById(R.id.textViewD);
        String messageD = String.format("%.2f",D);
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
        String messageLATO = String.format("%.5f",latitude_origin);
        textViewLATO.setText(messageLATO);
        //Longitude BOX
        TextView textViewLONO = findViewById(R.id.textViewLongitudeOrigin);
        String messageLONO = String.format("%.5f",longitude_origin);
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
        startTime = System.currentTimeMillis()/1000.0;
    }
}
