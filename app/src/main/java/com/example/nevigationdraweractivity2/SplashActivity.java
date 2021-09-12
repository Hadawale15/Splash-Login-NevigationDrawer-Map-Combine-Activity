package com.example.nevigationdraweractivity2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread=new Thread(){

            @Override
            public void run() {
                try {
                    music= MediaPlayer.create(SplashActivity.this,R.raw.slashsound);
                    music.start();
                    sleep(3000);
                }catch (Exception e){
                    e.getStackTrace();
                }
                finally {
                    Intent intent=new Intent(SplashActivity.this,Login.class);
                    startActivity(intent);
                }
            }

        };
        thread.start();


    }

    @Override
    protected void onPause() {
        music.release();
        super.onPause();
    }
}