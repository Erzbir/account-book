package com.erzbir.accountbook.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.erzbir.accountbook.AndroidApplication;
import com.erzbir.accountbook.R;
import com.erzbir.accountbook.adapter.BillDetailAdapter;
import com.erzbir.accountbook.component.BillManageComponent;
import com.erzbir.accountbook.entity.Bill;

import java.util.List;
import java.util.stream.Collectors;

public class DetailActivity extends AppCompatActivity {
    private List<Bill> bills;
    private RecyclerView rv_bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        BillManageComponent billManagerComponent = AndroidApplication.INSTANCE.APP.getBillManagerComponent();
        bills = billManagerComponent.stream().map(bill -> (Bill) bill).collect(Collectors.toList());
        BillDetailAdapter adapter = new BillDetailAdapter(DetailActivity.this, bills);
        StaggeredGridLayoutManager sm = new StaggeredGridLayoutManager(StaggeredGridLayoutManager.VERTICAL, 1);
        rv_bills.setLayoutManager(sm);
        rv_bills.setAdapter(adapter);
    }

    private void initView() {
        setContentView(R.layout.activity_detail);
        rv_bills = findViewById(R.id.rv_bills);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK && keyEvent.getRepeatCount() == 0) {
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, keyEvent);
    }
}
