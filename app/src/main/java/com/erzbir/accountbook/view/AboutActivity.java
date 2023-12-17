package com.erzbir.accountbook.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.erzbir.accountbook.R;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_about);
    }

}
