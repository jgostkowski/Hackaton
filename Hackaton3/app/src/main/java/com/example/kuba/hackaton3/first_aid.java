package com.example.kuba.hackaton3;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class first_aid extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    private Button sendSms;
    private Button gpsButton;
    private Button sms;
    String message = "Wypadek";
    String phoneNo = "663174940";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);
        sendSms = (Button) findViewById(R.id.sendSms);
        sms = (Button)findViewById(R.id.sends);
        //gpsButton = (Button) findViewById(R.id.GPS);



        sendSms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSmsMessage();

            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSems();
            }
        });
//        gpsButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                checkLocation(getApplicationContext());
//            }
//
//
//        });
    }

    private void sendSems() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

//    private void checkLocation(Context context) {
//
//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
//                PackageManager.PERMISSION_GRANTED &&
//                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
//                        PackageManager.PERMISSION_GRANTED) {
//
//            LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
//            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            //  locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, locationListener, null);
//            //  Location location = locationManager.getLastKnownLocation("gps");
//            double x = location.getLatitude();
//            double y = location.getLongitude();
//            Log.e("loc", String.valueOf(location.getLatitude()));
//        } else {
//            Toast.makeText(this, "5454545454", Toast.LENGTH_LONG).show();
//        }
//
//
//    }

    public void sendSmsMessage() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }
//    private final class MyLocationListener implements LocationListener {
//        Location location;
//        double x, y;
//
//        @Override
//        public void onLocationChanged(Location location) {
//            double x2=location.getLatitude();
//            Log.d("location", String.valueOf(x2));
//            x = x2;
//        }
//
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//            Log.d("on status changed", "disable");
//        }
//
//        @Override
//        public void onProviderEnabled(String provider) {
//            Log.d("on", "enable");
//        }
//
//        @Override
//        public void onProviderDisabled(String provider) {
//            Log.d("Latitude", "status");
//        }
//
//    }

}
