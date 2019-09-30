package com.mrjuoss.idn.day1.implicit.intent.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTts;
    Button btnEmail;
    Button btnCallPhone;
    Button btnBrowser;
    Button btnCamera;
    Button btnVideo;
    Button btnSms;
    Button btnAudioRecorder;
    Button btnWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();

    }

    private void initComponent() {
        btnTts = findViewById(R.id.btn_tts);
        btnEmail = findViewById(R.id.btn_email);
        btnCallPhone = findViewById(R.id.btn_call_phone);
        btnBrowser = findViewById(R.id.btn_browser);
        btnCamera = findViewById(R.id.btn_camera);
        btnVideo = findViewById(R.id.btn_video);
        btnSms = findViewById(R.id.btn_sms);
        btnAudioRecorder = findViewById(R.id.btn_audio_recorder);
        btnWifi = findViewById(R.id.btn_wifi);

        btnTts.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnCallPhone.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
        btnCamera.setOnClickListener(this);
        btnVideo.setOnClickListener(this);
        btnSms.setOnClickListener(this);
        btnAudioRecorder.setOnClickListener(this);
        btnWifi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tts:
                Toast.makeText(this, "TTS Button Click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_email:
                Toast.makeText(this, "Email Button Click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_call_phone:
                Toast.makeText(this, "Call Phone Button Click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_browser:
                Toast.makeText(this, "Browser Button Click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_camera:
                Toast.makeText(this, "Camera Button Click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_video:
                Toast.makeText(this, "Video Button Click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sms:
                Toast.makeText(this, "SMS Button Click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_audio_recorder:
                Toast.makeText(this, "Audio Recorder Button Click", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wifi:
                Toast.makeText(this, "Wifi Button Click", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
