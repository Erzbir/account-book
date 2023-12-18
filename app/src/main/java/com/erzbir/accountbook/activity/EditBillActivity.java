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
import com.erzbir.accountbook.view.DetailActivity;
import com.erzbir.accountbook.view.MainActivity;

public class EditBillActivity extends AppCompatActivity {
    private Bill editedBill;
    private Spinner sp_type;
    private EditText et_name;
    private EditText et_money;
    private EditText et_detail;
    private Button bt_confirm;
    private Button bt_del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initOnClickCallback();
    }

    private void initView() {
        setContentView(R.layout.activity_edit);
        et_name = findViewById(R.id.et_name);
        et_money = findViewById(R.id.et_money);
        et_detail = findViewById(R.id.et_detail);
        sp_type = findViewById(R.id.sp_type);
        bt_confirm = findViewById(R.id.bt_confirm);
        bt_del = findViewById(R.id.bt_del);
        initFromExtra();
    }

    private void initFromExtra() {
        editedBill = getIntent().getSerializableExtra("bill", Bill.class);
        et_name.setText(editedBill.getName());
        et_money.setText(String.valueOf(editedBill.getMoney()));
        et_detail.setText(editedBill.getDetail());
        sp_type.setSelection(editedBill.isPlus() ? 0 : 1);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getRepeatCount() == 0) {
            Intent intent = new Intent(EditBillActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, keyEvent);
    }

    private void initOnClickCallback() {
        setDeleteOnClick();
        setConfirmOnClick();
    }

    private void setDeleteOnClick() {
        bt_del.setOnClickListener(v -> {
            BillManageComponent billManagerComponent = AndroidApplication.INSTANCE.APP.getBillManagerComponent();
            billManagerComponent.remove(editedBill);
            Intent intent = new Intent(EditBillActivity.this, DetailActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void setConfirmOnClick() {
        bt_confirm.setOnClickListener(v -> {
            int position = sp_type.getSelectedItemPosition();
            BillManageComponent billManagerComponent = AndroidApplication.INSTANCE.APP.getBillManagerComponent();
            editedBill.setName(et_name.getText().toString());
            editedBill.setMoney(Float.parseFloat(et_money.getText().toString()));
            editedBill.setTime(System.currentTimeMillis());
            editedBill.setPlus(position == 0);
            editedBill.setDetail(et_detail.getText().toString());
            billManagerComponent.update(editedBill);
            Intent intent = new Intent(EditBillActivity.this, DetailActivity.class);
            startActivity(intent);
            finish();
        });
    }

}
