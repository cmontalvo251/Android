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
import android.widget.Button;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private LocationManager locationManager;
    private LocationListener locationListener;
    public double latitude = 0;
    public double longitude = 0;

    public double elevation = 0;
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
    public double vx_prev = 0;
    public double vy_prev = 0;
    public double V = 0;
    public double VX_display = 0;
    public double VY_display = 0;
    public double V_display = 0;
    public double bearing_prev = 0;
    public double CalcBearing = 0;
    public double bearing = 0;
    public double D = 0;
    public boolean LATLONSET = false;
    //public double decayRate = 0;
    public double startTime = -99;
    public double lastTime = 0;
    public double decayTime = 1; //only decay the velocity once a second
    public double nextTime = decayTime;
    //Create a handler to update the numbers
    public Handler handler = new Handler();
    public Runnable runnable;
    public static final int LOOP_INTERVAL_MS = 100; // 100 ms = 10 Hz //How fast we compute
    //Variables for writing to a file
    public boolean FILEOPEN = false;
    public FileOutputStream fos;
    private Button startButton;
    public double LogRate = 1.0; //log every LogRate seconds
    public double nextLog = 0;

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
                elevation = location.getAltitude()*3.28;
                gps_speed = location.getSpeed() * 2.23694; //convert from m/s to mph
                bearing = location.getBearing();
                //Grab the time the location changed
                lastTime = time;
                //Also reset nextTime
                nextTime = decayTime;
            }
        };
        //Start the GPS
        startGPS();
        //Get the start time
        startTime = System.currentTimeMillis() / 1000.0;
        //Kick off the runnable function to run at a set loop interval

        //Create the Start Button function which resets all variables and handles file management
        startButton = findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Start(MainActivity.this);
                } catch (IOException e) {
                    PrintMessage("Catch: Start");
                    throw new RuntimeException(e);
                }
            }
        });

        //Compute decay rate of velocity (not used anymore)
        //double decayTime = 10; //seconds to decay
        //double Nps = 1000/LOOP_INTERVAL_MS; //Number of times per second the loop runs
        //double N = decayTime * Nps; //Number of times the loop needs to run before we get to 2%
        //decayRate = Math.pow(0.02,1.0/N);

        runnable = new Runnable() {
            @Override
            public void run() {
                //Get time elapsed from start time
                time = System.currentTimeMillis() / 1000.0 - startTime;
                //If LATLON origin has been set, start computing
                if (LATLONSET) {
                    Compute();
                    try {
                        //We also want to output to a file
                        if (time > nextLog) {
                            String line = time + "," + latitude + "," + longitude + "," + latitude_origin + "," + longitude_origin + "," + X + "," + Y + "," + D + "," + VX_display + "," + VY_display + "," + V_display + "," + gps_speed + "," + CalcBearing + "," + bearing + "," + elevation;
                            fos.write((line + "\n").getBytes());
                            nextLog += LogRate;
                        }
                    } catch (IOException e) {
                        PrintMessage("Catch: Logging to a File");
                        throw new RuntimeException(e);
                    }
                }
                //No matter what display the numbers you've got.
                DisplayNumbers();
                //And run the velocity decay rate
                DecayVelocity();
                //Then execute the run() function again after the loop interval
                handler.postDelayed(this, LOOP_INTERVAL_MS);
            }
        };
        //Don't forget to actually start the loop
        handler.post(runnable);
    }

    //Make sure you kill the runnable on destroy
    @Override
    protected void onDestroy() {
        // Stop the loop when the activity is destroyed
        handler.removeCallbacks(runnable);
        //And close the file is a file is open
        if (FILEOPEN) {
            try {
                fos.close();
            } catch (IOException e) {
                PrintMessage("Catch: onDestroy");
                throw new RuntimeException(e);
            }
        }
        super.onDestroy();
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
        //This is here for the accelerometer which we're not using rn/
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

    public void PrintMessage(String message) {
        TextView textViewMessage = findViewById(R.id.textViewMESSAGE);
        textViewMessage.setText(message);
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

    public void DecayVelocity() {
        //This routine will decay the velocity when you're standing still and GPS hasn't changed
        //First compute the maximum velocity that the system could be
        double dt = time - lastTime; //Current time - the last time we updated GPS
        //But make sure we don't get a divide by zero
        //Also only do this at a prescribed interval
        if (dt > nextTime) {
            //Increment nexttime so this only runs on the correct interval
            nextTime += decayTime;
            //convert dt to hours
            dt /= 3600;
            double VMAX = 0.01 / dt; //the maximum mph you could be going without GPS changing (0.01 miles per dt hours)
            if (V_display > VMAX) {
                double ratio = VMAX / V_display;
                V_display *= ratio;
                VX_display *= ratio;
                VY_display *= ratio;
            }
        }
    }

    public void Compute() {
        //First convert Latitude and longitude to X and Y
        double NM2MI = 1.15078F;
        double X_new = (latitude - latitude_origin) * 60 * NM2MI; //#%%//North direction - Xf , miles
        double Y_new = (longitude - longitude_origin) * 60 * NM2MI * Math.cos(latitude_origin * Math.PI / 180.0); //#%%//East direction - Yf, miles
        //Then compute velocity in the X and Y directions
        double dx = (X_new - x_prev);
        double dy = (Y_new - y_prev);
        double dt = (time - time_prev) / 3600.0; //convert to hours
        double VX_new = dx / dt;
        double VY_new = dy / dt;
        //Compute the total velocity
        double v_new = Math.sqrt(VX_new * VX_new + VY_new * VY_new);
        //Throw out velocities that are ridiculous
        if (v_new > 200) {
            //My car won't even do 200 mph
            return;
        }
        //Also just return if you haven't moved enough
        double D_add = Math.sqrt(dx * dx + dy * dy);
        if (D_add < 0.01) {
            return;
        }
        //Otherwise compute everything we need to compute
        //First set x_new and y_new to the appropriate x,y vals
        X = X_new;
        Y = Y_new;
        //Filter the VX and VY velocities
        double s = 0.9;
        VX = s * VX_new + (1 - s) * vx_prev;
        VY = s * VY_new + (1 - s) * vy_prev;
        //Recompute velocity with new filtered vals
        V = Math.sqrt(VX * VX + VY * VY);
        //Reset the display values
        V_display = V;
        VX_display = VX;
        VY_display = VY;
        //Compute Heading (If you want to filter heading you need to filter cos(bearing) and sin(bearing)
        //and then recompute bearing by doing atan2(sin(bearing),cos(bearing))
        //But I don't want to deal with that b/c I think this is fine
        //We're basically filtering anyway by only taking new data points when the GPS changes
        //and when the distance changes by 0.01
        CalcBearing = Math.atan2(dy, dx) * 180.0 / Math.PI; //Bearing in degrees
        //The atan2 function wraps at -180 but standard bearing needs to wrap at 360.
        //So if it's -180 we had 360 to it so it's 180 and if it's -1 it'll be 359.
        if (CalcBearing < 0) {
            CalcBearing += 360.0;
        }
        //Compute total distance traveled
        D += D_add;
        //Then reset prev values
        x_prev = X;
        y_prev = Y;
        time_prev = time;
        vx_prev = VX;
        vy_prev = VY;
        bearing_prev = CalcBearing;
    }

    public void DisplayNumbers() {
        //Time BOX
        TextView textViewTime = findViewById(R.id.textViewTime);
        String messageTime = String.format("%.2f", time);
        textViewTime.setText(messageTime);
        ///Latitude BOX
        TextView textViewLAT = findViewById(R.id.textViewLatitude);
        String messageLAT = String.format("%.5f", latitude);
        textViewLAT.setText(messageLAT);
        //Longitude BOX
        TextView textViewLON = findViewById(R.id.textViewLongitude);
        String messageLON = String.format("%.5f", longitude);
        textViewLON.setText(messageLON);
        //Current X position
        TextView textViewX = findViewById(R.id.textViewX);
        String messageX = String.format("%.2f", X);
        textViewX.setText(messageX);
        //Current Y position
        TextView textViewY = findViewById(R.id.textViewY);
        String messageY = String.format("%.2f", Y);
        textViewY.setText(messageY);
        //Current velocity X
        TextView textViewVX = findViewById(R.id.textViewVX);
        String messageVX = String.format("%.2f", VX_display);
        textViewVX.setText(messageVX);
        //Current velocity Y
        TextView textViewVY = findViewById(R.id.textViewVY);
        String messageVY = String.format("%.2f", VY_display);
        textViewVY.setText(messageVY);
        //Current velocity
        TextView textViewV = findViewById(R.id.textViewV);
        String messageV = String.format("%.2f", V_display);
        textViewV.setText(messageV);
        //Velocity Directly from GPS
        TextView textViewGPSV = findViewById(R.id.textViewGPSV);
        String messageGPSV = String.format("%.2f", gps_speed);
        textViewGPSV.setText(messageGPSV);
        //Current Distance
        TextView textViewD = findViewById(R.id.textViewD);
        String messageD = String.format("%.2f", D);
        textViewD.setText(messageD);
        //Calculated Bearing
        TextView textViewCalcB = findViewById(R.id.textViewCalcB);
        String messageCalcB = String.format("%.2f", CalcBearing);
        textViewCalcB.setText(messageCalcB);
        //Calculated Bearing from GPS
        TextView textViewB = findViewById(R.id.textViewB);
        String messageB = String.format("%.2f", bearing);
        textViewB.setText(messageB);
        //Elevation from GPS (ft)
        TextView textViewELE = findViewById(R.id.textViewELE);
        String messageELE = String.format("%.2f", elevation);
        textViewELE.setText(messageELE);
    }

    //Called when user hits the Start button
    public void Start(Context context) throws IOException {
        //First set the latitude and longitude
        latitude_origin = latitude;
        longitude_origin = longitude;
        //LATLONSET variable
        LATLONSET = true;
        ///Latitude BOX
        TextView textViewLATO = findViewById(R.id.textViewLatitudeOrigin);
        String messageLATO = String.format("%.5f", latitude_origin);
        textViewLATO.setText(messageLATO);
        //Longitude BOX
        TextView textViewLONO = findViewById(R.id.textViewLongitudeOrigin);
        String messageLONO = String.format("%.5f", longitude_origin);
        textViewLONO.setText(messageLONO);
        //Then Reset X,Y,VX,VY,V and D
        X = 0;
        x_prev = 0;
        vx_prev = 0;
        Y = 0;
        y_prev = 0;
        vy_prev = 0;
        VX = 0;
        VY = 0;
        V = 0;
        D = 0;
        CalcBearing = 0;
        nextLog = 0;
        startTime = System.currentTimeMillis() / 1000.0;
        //Now we handle the file management stuff
        //First we need to check and see if a file is open
        if (FILEOPEN) {
            fos.close();
        }
        //Now we know the file is close so
        // we need to loop through our directory until we find a file we need
        int num = 0;
        boolean filenotfound = true;
        File file;
        String fileName = "log-1.txt";
        while (filenotfound) {
            //Create a file name with the number in the filename
            fileName = "log" + num + ".txt";
            //file = new File(context.getFilesDir(), fileName);
            //file = new File(context.getExternalFilesDir(null),fileName);
            file = new File("/storage/emulated/0/Documents/",fileName);
            //check to see if the file exists
            if (!file.exists()) {
                //If it doesn't exist we create a new file
                file.createNewFile();
                //and set filenotfound to false so we break out of this loop
                filenotfound = false;
                // and we can create the file stream
                fos = new FileOutputStream(file);
                FILEOPEN = true;
            } else {
                //Otherwise we increment by 1 and try again
                num += 1;
            } // else file exists
        } //end while loop
        //Files log to /data/user/0/com.example.gps/files/log#.txt
        //In android studio it's
        // /data/data/com.example.gps/files/log#.txt
        //PrintMessage("Logging to: " + context.getFilesDir().getAbsolutePath() + "/" + fileName);
        //This one is /storage/emulated/0/Android/data/com.example.gps/files/log#.txt
        //PrintMessage("Logging to: " + context.getExternalFilesDir(null) + "/" + fileName);
        PrintMessage("Logging to: /storage/emulated/0/Documents/" + fileName);
    } // end start function

} // end main activity
