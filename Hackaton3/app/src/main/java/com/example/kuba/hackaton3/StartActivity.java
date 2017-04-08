package com.example.kuba.hackaton3;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button firstAid;
    private ImageView imageView;
    private TextView textView;
    private static final String FORMAT = "%02d";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        textView=(TextView) findViewById(R.id.textView);
        firstAid=(Button)findViewById(R.id.FirstAidBtn);

        imageView = (ImageView) findViewById(R.id.image);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Drawable d = imageView.getDrawable();
                    if(d instanceof Animatable){
                        ((Animatable)d).start();
                        new CountDownTimer(30000,15){
                            public void onTick(long millisUntilFinished) {

                                textView.setText(""+String.format(FORMAT,
                                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                            }

                            public void onFinish() {
                                textView.setText("done!");
                            }
                        }.start();
                    }
                }
            });

        firstAid.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,first_aid.class));
    }
}
