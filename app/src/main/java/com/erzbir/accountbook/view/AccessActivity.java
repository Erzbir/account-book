package com.erzbir.accountbook.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.R;
import com.erzbir.accountbook.component.LoginComponent;
import com.erzbir.accountbook.component.RegisterComponent;
import com.erzbir.accountbook.dao.AppDatabase;
import com.erzbir.accountbook.util.SavedUser;
import com.erzbir.accountbook.entity.User;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class AccessActivity extends AppCompatActivity {

    private EditText et_usernameE;
    private EditText et_password;
    private Button bt_register;
    private Button bt_login;
    private CheckBox cb_remember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplication.INSTANCE.DB = AppDatabase.getInstance(AccessActivity.this);
        initView();
        initOnClickCallback();
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
        SharedPreferences preferences = getSharedPreferences("user", 0);
        boolean rem = preferences.getBoolean(SavedUser.REM_PASSWORD_KEY, false);
        if (rem) {
            cb_remember.setChecked(true);
            String username = preferences.getString(SavedUser.USERNAME_KEY, "");
            String password = AndroidApplication.INSTANCE.APP.getUserManageComponent().getUser(username).getPassword();
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
                SharedPreferences preferences = getSharedPreferences("user", 0);
                SharedPreferences.Editor editor = preferences.edit();
                if (cb_remember.isChecked()) {
                    editor.putBoolean(SavedUser.REM_PASSWORD_KEY, true);
                    editor.putString(SavedUser.USERNAME_KEY, user.getUsername());
                } else {
                    editor.clear();
                }
                editor.apply();
                SavedUser.setUser(user);
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
