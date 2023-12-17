package com.erzbir.accountbook.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.R;
import com.erzbir.accountbook.component.LoginComponent;
import com.erzbir.accountbook.component.RegisterComponent;
import com.erzbir.accountbook.dao.AppDatabase;
import com.erzbir.accountbook.entity.User;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class AccessActivity extends AppCompatActivity {
    private final static String REM_PASSWORD_KEY = "REM_PASSWORD";
    private final static String USERNAME_KEY = "USERNAME";
    private final static String PASSWORD_KEY = "PASSWORD";
    private EditText et_usernameE;
    private EditText et_password;
    private Button bt_register;
    private Button bt_login;
    private CheckBox cb_remember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initOnClickCallback();
        AndroidApplication.INSTANCE.DB = Room.databaseBuilder(this,
                AppDatabase.class, "test").allowMainThreadQueries().build();
    }

    private void initOnClickCallback() {
        setLoginOnClick();
        setRegisterOnClick();
    }

    private void initView() {
        setContentView(R.layout.activity_access);
        bt_register = findViewById(R.id.register);
        bt_login = findViewById(R.id.login);
        et_usernameE = findViewById(R.id.username);
        et_password = findViewById(R.id.password);
        cb_remember = findViewById(R.id.s_remember);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AccessActivity.this);
        boolean rem = preferences.getBoolean(REM_PASSWORD_KEY, false);
        if (rem) {
            cb_remember.setChecked(true);
            String username = preferences.getString(USERNAME_KEY, "");
            String password = preferences.getString(PASSWORD_KEY, "");
            et_usernameE.setText(username);
            et_password.setText(password);
        }
    }


    private void setRegisterOnClick() {
        bt_register.setOnClickListener(view -> {
            RegisterComponent registerComponent = AndroidApplication.INSTANCE.APP.getRegisterComponent();
            User user = new User.Builder().username("admin").password("123456").build();
            registerComponent.register(user);
        });
    }

    private void setLoginOnClick() {
        bt_login.setOnClickListener(view -> {
            LoginComponent loginComponent = AndroidApplication.INSTANCE.APP.getLoginComponent();
            User user = new User.Builder().username(et_usernameE.getText().toString()).password(et_password.getText().toString()).build();
            if (loginComponent.login(user)) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(AccessActivity.this);
                SharedPreferences.Editor editor = preferences.edit();
                if (cb_remember.isChecked()) {
                    editor.putBoolean(REM_PASSWORD_KEY, true);
                    editor.putString(USERNAME_KEY, user.getUsername());
                    editor.putString(PASSWORD_KEY, user.getPassword());
                } else {
                    editor.clear();
                }
                editor.apply();
                Toast.makeText(AccessActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AccessActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(AccessActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
