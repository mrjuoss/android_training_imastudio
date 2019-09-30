package com.mrjuoss.idn.day1.implicit.intent.app.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.mrjuoss.idn.day1.implicit.intent.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CallPhoneActivity extends AppCompatActivity {

    @BindView(R.id.edt_number_phone)
    EditText edtNumberPhone;
    @BindView(R.id.btn_call)
    Button btnCall;
    @BindView(R.id.btn_dial)
    Button btnDial;
    @BindView(R.id.btn_contact)
    Button btnContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_call, R.id.btn_dial, R.id.btn_contact})
    public void onViewClicked(View view) {
        String phone = edtNumberPhone.getText().toString();
        switch (view.getId()) {
            case R.id.btn_call:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(
                                new String[] {
                                        Manifest.permission.CALL_PHONE,
                                }, 100
                        );
                    }

                    return;
                }

                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone)));
                break;
            case R.id.btn_dial:
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone)));
                break;
            case R.id.btn_contact:
                Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                i.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(i, 1);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Cursor c = null;
            try {
                Uri lokasi = data.getData();
                c = getContentResolver().query(lokasi, new String[] {
                  ContactsContract  .CommonDataKinds.Phone.NUMBER
                }, null, null);

                if (c != null && c.moveToNext()) {
                    String phone = c.getString(0);
                    edtNumberPhone.setText(phone);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
