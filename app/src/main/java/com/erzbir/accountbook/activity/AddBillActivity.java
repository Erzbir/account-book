package com.erzbir.accountbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.R;
import com.erzbir.accountbook.component.BillManageComponent;
import com.erzbir.accountbook.entity.Bill;
import com.erzbir.accountbook.util.TimeUtil;
import com.erzbir.accountbook.view.MainActivity;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class AddBillActivity extends AppCompatActivity {
    private Spinner sp_type;
    private EditText et_name;
    private EditText et_money;
    private EditText et_detail;
    private EditText et_time;
    private Button bt_confirm;
    private Button bt_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initOnClickCallback();
    }

    private void initView() {
        setContentView(R.layout.activity_add);
        et_name = findViewById(R.id.et_name);
        et_money = findViewById(R.id.et_money);
        et_detail = findViewById(R.id.et_detail);
        et_time = findViewById(R.id.et_time);
        sp_type = findViewById(R.id.sp_type);
        bt_confirm = findViewById(R.id.bt_confirm);
        bt_cancel = findViewById(R.id.bt_cancel);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getRepeatCount() == 0) {
            Intent intent = new Intent(AddBillActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, keyEvent);
    }

    private void initOnClickCallback() {
        setCancelOnClick();
        setConfirmOnClick();
    }

    private void setCancelOnClick() {
        bt_cancel.setOnClickListener(v -> {
            Intent intent = new Intent(AddBillActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            finish();
        });
    }

    private void setConfirmOnClick() {
        bt_confirm.setOnClickListener(v -> {
            int position = sp_type.getSelectedItemPosition();
            BillManageComponent billManagerComponent = AndroidApplication.INSTANCE.APP.getBillManagerComponent();
            Bill build = new Bill.Builder()
                    .name(et_name.getText().toString())
                    .money(Float.parseFloat(et_money.getText().toString()))
                    .detail(et_detail.getText().toString())
                    .plus(position == 0)
                    .time(TimeUtil.getTimestamp(et_time.getText().toString()))
                    .build();
            billManagerComponent.add(build);
            Intent intent = new Intent(AddBillActivity.this, AddBillActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
