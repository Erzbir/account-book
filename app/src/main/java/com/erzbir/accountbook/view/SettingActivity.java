package com.erzbir.accountbook.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.R;
import com.erzbir.accountbook.activity.AccessChangeActivity;
import com.erzbir.accountbook.backup.GithubBackupStrategy;
import com.erzbir.accountbook.component.BackupComponent;
import com.erzbir.accountbook.entity.IBill;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2023/12/18
 */
public class SettingActivity extends AppCompatActivity {

    private Button bt_about;
    private Button bt_changeAccess;
    private Button bt_backup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initOnClickCallback();
    }

    private void initView() {
        setContentView(R.layout.activity_setting);
        bt_about = findViewById(R.id.bt_about);
        bt_changeAccess = findViewById(R.id.bt_changeAccess);
        bt_backup = findViewById(R.id.bt_backup);
    }

    private void initOnClickCallback() {
        setAboutOnClick();
        setChangeOnClick();
        setBackupOnClick();
    }

    private void setChangeOnClick() {
        bt_changeAccess.setOnClickListener(v -> {
            Intent intent = new Intent(SettingActivity.this, AccessChangeActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void setAboutOnClick() {
        bt_about.setOnClickListener(v -> {
            Intent intent = new Intent(SettingActivity.this, AboutActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void setBackupOnClick() {
        bt_backup.setOnClickListener(v -> {
            BackupComponent backupComponent = AndroidApplication.INSTANCE.APP.getBackupComponent();
            backupComponent.addBackupStrategy(new GithubBackupStrategy());
            List<IBill> bills = AndroidApplication.INSTANCE.APP.getBillManagerComponent().getBills();
            backupComponent.backup(bills);
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
