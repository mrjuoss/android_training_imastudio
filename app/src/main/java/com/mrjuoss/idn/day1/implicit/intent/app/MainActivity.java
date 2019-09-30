package com.mrjuoss.idn.day1.implicit.intent.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mrjuoss.idn.day1.implicit.intent.app.activity.AudioRecorderActivity;
import com.mrjuoss.idn.day1.implicit.intent.app.activity.BrowserActivity;
import com.mrjuoss.idn.day1.implicit.intent.app.activity.CallPhoneActivity;
import com.mrjuoss.idn.day1.implicit.intent.app.activity.CameraActivity;
import com.mrjuoss.idn.day1.implicit.intent.app.activity.EmailActivity;
import com.mrjuoss.idn.day1.implicit.intent.app.activity.SmsActivity;
import com.mrjuoss.idn.day1.implicit.intent.app.activity.TtsActivity;
import com.mrjuoss.idn.day1.implicit.intent.app.activity.VideoActivity;
import com.mrjuoss.idn.day1.implicit.intent.app.activity.WifiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_tts)
    Button btnTts;
    @BindView(R.id.btn_email)
    Button btnEmail;
    @BindView(R.id.btn_call_phone)
    Button btnCallPhone;
    @BindView(R.id.btn_browser)
    Button btnBrowser;
    @BindView(R.id.btn_camera)
    Button btnCamera;
    @BindView(R.id.btn_video)
    Button btnVideo;
    @BindView(R.id.btn_sms)
    Button btnSms;
    @BindView(R.id.btn_audio_recorder)
    Button btnAudioRecorder;
    @BindView(R.id.btn_wifi)
    Button btnWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_tts, R.id.btn_email, R.id.btn_call_phone, R.id.btn_browser, R.id.btn_camera, R.id.btn_video, R.id.btn_sms, R.id.btn_audio_recorder, R.id.btn_wifi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_tts:
                startActivity(new Intent(this, TtsActivity.class));

                break;
            case R.id.btn_email:
                startActivity(new Intent(this, EmailActivity.class));

                break;
            case R.id.btn_call_phone:
                startActivity(new Intent(this, CallPhoneActivity.class));

                break;
            case R.id.btn_browser:
                startActivity(new Intent(this, BrowserActivity.class));

                break;
            case R.id.btn_camera:
                startActivity(new Intent(this, CameraActivity.class));

                break;
            case R.id.btn_video:
                startActivity(new Intent(this, VideoActivity.class));

                break;
            case R.id.btn_sms:
                startActivity(new Intent(this, SmsActivity.class));

                break;
            case R.id.btn_audio_recorder:
                startActivity(new Intent(this, AudioRecorderActivity.class));

                break;
            case R.id.btn_wifi:
                startActivity(new Intent(this, WifiActivity.class));

                break;
        }
    }
}
