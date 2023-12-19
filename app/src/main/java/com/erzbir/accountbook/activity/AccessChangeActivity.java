package com.erzbir.accountbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.R;
import com.erzbir.accountbook.entity.User;
import com.erzbir.accountbook.util.SavedUser;
import com.erzbir.accountbook.view.SettingActivity;

/**
 * @author Erzbir
 * @Data: 2023/12/18
 */
public class AccessChangeActivity extends AppCompatActivity {
    private Button bt_confirm;
    private Button bt_cancel;
    private TextView tv_password_old;
    private EditText tv_password;
    private EditText tv_password_sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initOnClickCallback();
    }


    private void initView() {
        setContentView(R.layout.activity_change_access);
        bt_confirm = findViewById(R.id.bt_confirm);
        bt_cancel = findViewById(R.id.bt_cancel);
        tv_password_old = findViewById(R.id.et_password_old);
        tv_password = findViewById(R.id.et_password);
        tv_password_sure = findViewById(R.id.et_password_sure);
    }

    private void initOnClickCallback() {
        setConfirmOnClick();
        setCancelOnClick();
    }

    private void setConfirmOnClick() {
        bt_confirm.setOnClickListener(v -> {
            User user = SavedUser.getUser();
            String oldPassword = tv_password_old.getText().toString();
            if (!oldPassword.equals(user.getPassword())) {
                Toast.makeText(AccessChangeActivity.this, "旧密码错误", Toast.LENGTH_SHORT).show();
                return;
            }
            String password = tv_password.getText().toString();
            String passwordSure = tv_password_sure.getText().toString();
            if (!passwordSure.equals(password)) {
                Toast.makeText(AccessChangeActivity.this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                return;
            }
            user.setPassword(password);
            SavedUser.setUser(user);
            AndroidApplication.INSTANCE.APP.getUserManageComponent().update(user);
            Intent intent = new Intent(AccessChangeActivity.this, SettingActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void setCancelOnClick() {
        bt_cancel.setOnClickListener(v -> {
            Intent intent = new Intent(AccessChangeActivity.this, SettingActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
