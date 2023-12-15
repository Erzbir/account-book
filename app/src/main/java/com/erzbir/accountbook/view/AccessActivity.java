package com.erzbir.accountbook.view;

import android.os.Bundle;
import android.widget.Button;
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
    protected EditText usernameEdit;
    protected EditText passwordEdit;
    protected Button registerBtn;
    protected Button loginBtn;

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
        registerBtn = findViewById(R.id.register);
        loginBtn = findViewById(R.id.login);
        usernameEdit = findViewById(R.id.username);
        passwordEdit = findViewById(R.id.password);
    }

    private void setRegisterOnClick() {
        registerBtn.setOnClickListener(view -> {
            RegisterComponent registerComponent = AndroidApplication.INSTANCE.APP.getRegisterComponent();
            User user = new User();
            user.setUsername("admin");
            user.setPassword("123456");
            registerComponent.register(user);
        });
    }

    private void setLoginOnClick() {
        loginBtn.setOnClickListener(view -> {
            LoginComponent loginComponent = AndroidApplication.INSTANCE.APP.getLoginComponent();
            User user = new User();
            user.setUsername("admin");
            user.setPassword("123456");
            if (loginComponent.login(user)) {
                Toast.makeText(AccessActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(AccessActivity.this, "登录失败", Toast.LENGTH_SHORT).show();

            }
        });

//        System.out.println("登录成功");
    }
}
