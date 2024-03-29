package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener{

    private TextView xText, yText, zText, posText;
    private Sensor mySensor;
    private SensorManager SM;
    private SensorEventListener event;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        xText = findViewById(R.id.xText);
        yText = findViewById(R.id.yText);
        zText = findViewById(R.id.zText);
        posText = findViewById(R.id.posText);

    }


    @SuppressLint("SetTextI18n")


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {



        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);
        posText.setText("Position: " + );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.actions) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
