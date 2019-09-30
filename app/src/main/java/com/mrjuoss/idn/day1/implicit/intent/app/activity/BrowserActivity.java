package com.mrjuoss.idn.day1.implicit.intent.app.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mrjuoss.idn.day1.implicit.intent.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BrowserActivity extends AppCompatActivity {

    @BindView(R.id.edt_url)
    EditText edtUrl;
    @BindView(R.id.btn_open_browser)
    Button btnOpenBrowser;
    @BindView(R.id.wv_url)
    WebView wvUrl;
    @BindView(R.id.btn_open_web)
    Button btnOpenWeb;

    String alamatUrl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_open_browser, R.id.btn_open_web})
    public void onViewClicked(View view) {
        alamatUrl = edtUrl.getText().toString();

        switch (view.getId()) {
            case R.id.btn_open_browser:
                if (TextUtils.isEmpty(alamatUrl)) {
                    edtUrl.setError(getText(R.string.url_wajib_diisi));
                } else {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+alamatUrl)));
                }
                break;
            case R.id.btn_open_web:
                wvUrl.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return super.shouldOverrideUrlLoading(view, url);
                    }
                });

                wvUrl.getSettings().setJavaScriptEnabled(true);
                Log.d("Alamat URL Web: ", alamatUrl);
                wvUrl.loadUrl("https://"+ alamatUrl);
                break;
        }
    }
}
