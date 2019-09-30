package com.mrjuoss.idn.day1.implicit.intent.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                break;
            case R.id.btn_email:
                break;
            case R.id.btn_call_phone:
                break;
            case R.id.btn_browser:
                break;
            case R.id.btn_camera:
                break;
            case R.id.btn_video:
                break;
            case R.id.btn_sms:
                break;
            case R.id.btn_audio_recorder:
                break;
            case R.id.btn_wifi:
                break;
        }
    }
}
