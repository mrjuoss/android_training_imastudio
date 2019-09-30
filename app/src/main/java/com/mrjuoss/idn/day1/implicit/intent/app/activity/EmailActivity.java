package com.mrjuoss.idn.day1.implicit.intent.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mrjuoss.idn.day1.implicit.intent.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmailActivity extends AppCompatActivity {

    @BindView(R.id.edt_to)
    EditText edtTo;
    @BindView(R.id.edt_subject)
    EditText edtSubject;
    @BindView(R.id.edt_message)
    EditText edtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mm_send) {
            String to = edtTo.getText().toString();
            String subject = edtSubject.getText().toString();
            String message = edtMessage.getText().toString();

            if (TextUtils.isEmpty(to)) {
                edtTo.setError("Email tujuan tidak boleh kosong");
            } else if (TextUtils.isEmpty(subject)) {
                edtSubject.setError("Subject email tidak boleh kosong");
            } else if (TextUtils.isEmpty(message)) {
                edtMessage.setError("Message tidak boleh kosong");
            } else {
                Intent intentKirimEmail = new Intent(Intent.ACTION_SEND);
                intentKirimEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intentKirimEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
                intentKirimEmail.putExtra(Intent.EXTRA_TEXT, message);
                intentKirimEmail.setType("message/rfc822");
                startActivity(Intent.createChooser(intentKirimEmail, "Send via : "));
            }
        } else {
            edtTo.setText("");
            edtSubject.setText("");
            edtMessage.setText("");
        }

        return super.onOptionsItemSelected(item);
    }
}
