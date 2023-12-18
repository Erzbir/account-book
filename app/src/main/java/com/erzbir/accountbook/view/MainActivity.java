package com.erzbir.accountbook.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.R;
import com.erzbir.accountbook.activity.AddBillActivity;
import com.erzbir.accountbook.component.BillManageComponent;
import com.erzbir.accountbook.entity.IBill;
import com.erzbir.accountbook.event.BillAddEvent;
import com.erzbir.accountbook.event.BillEvent;
import com.erzbir.accountbook.event.BillIncomeEvent;
import com.erzbir.accountbook.event.BillPayEvent;
import com.erzbir.event.GlobalEventChannel;
import com.erzbir.event.Listener;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv_total;
    private TextView tv_totalPay;
    private TextView tv_totalIncome;
    private Button bt_addBill;
    private Button bt_detail;
    private Button bt_setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initOnClickCallback();
        GlobalEventChannel.INSTANCE.subscribe(BillEvent.class, event -> {
            String string = tv_total.getText().toString();
            float old = Float.parseFloat(string);
            IBill source = event.getSource();
            source.getMoney();
            Class<? extends BillEvent> aClass = event.getClass();
            if (BillAddEvent.class.isAssignableFrom(aClass)) {
                float newTotal = source.getMoney() + old;
                tv_total.setText(String.valueOf(newTotal));
            }
            if (BillPayEvent.class.isAssignableFrom(aClass)) {
                tv_totalPay.setText(String.valueOf(Float.parseFloat(tv_totalPay.getText().toString()) + source.getMoney()));
            }
            if (BillIncomeEvent.class.isAssignableFrom(aClass)) {
                tv_totalIncome.setText(String.valueOf(Float.parseFloat(tv_totalIncome.getText().toString()) + source.getMoney()));
            }
            return Listener.ListenerStatus.LISTENING;
        });
    }

    private void initView() {
        tv_total = findViewById(R.id.tv_total);
        tv_totalPay = findViewById(R.id.tv_totalPay);
        tv_totalIncome = findViewById(R.id.tv_totalIncome);
        bt_addBill = findViewById(R.id.bt_addBill);
        bt_detail = findViewById(R.id.bt_detail);
        bt_setting = findViewById(R.id.bt_setting);
        BillManageComponent billManagerComponent = AndroidApplication.INSTANCE.APP.getBillManagerComponent();
        List<IBill> bills = billManagerComponent.getBills();
        float total = 0, totalPay = 0, totalIncome = 0;
        for (IBill bill : bills) {
            Boolean plus = bill.isPlus();
            if (plus) {
                totalIncome += bill.getMoney();
            } else {
                totalPay += bill.getMoney();
            }
            total += bill.getMoney();
        }
        tv_total.setText(String.valueOf(total));
        tv_totalPay.setText(String.valueOf(totalPay));
        tv_totalIncome.setText(String.valueOf(totalIncome));
    }

    private void initOnClickCallback() {
        setDetailOnClick();
        setAddBillOnClick();
        setSettingOnClick();
    }

    private void setAddBillOnClick() {
        bt_addBill.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddBillActivity.class);
            startActivity(intent);
        });
    }

    private void setSettingOnClick() {
        bt_setting.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void setDetailOnClick() {
        bt_detail.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
