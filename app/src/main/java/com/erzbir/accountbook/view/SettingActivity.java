package com.erzbir.accountbook.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.erzbir.accountbook.R;

public class SettingActivity extends AppCompatActivity {

    private Button bt_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initOnClickCallback();
    }

    private void initView() {
        setContentView(R.layout.activity_setting);
        bt_about = findViewById(R.id.bt_about);
    }

    private void initOnClickCallback() {
        setAboutOnClick();
    }

    private void setAboutOnClick() {
        bt_about.setOnClickListener(v -> {
            Intent intent = new Intent(SettingActivity.this, AboutActivity.class);
            startActivity(intent);
            finish();
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getRepeatCount() == 0) {
            Intent intent = new Intent(SettingActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, keyEvent);
    }
}
