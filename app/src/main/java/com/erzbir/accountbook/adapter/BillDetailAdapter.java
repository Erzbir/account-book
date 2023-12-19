package com.erzbir.accountbook.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.erzbir.accountbook.R;
import com.erzbir.accountbook.activity.EditBillActivity;
import com.erzbir.accountbook.entity.Bill;
import com.erzbir.accountbook.util.TimeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class BillDetailAdapter extends RecyclerView.Adapter<BillDetailAdapter.ViewHolder> {
    private Context context;
    private List<Bill> bills;

    public BillDetailAdapter(Context context, List<Bill> bills) {
        this.context = context;
        this.bills = bills;
    }

    @NonNull
    @NotNull
    @Override
    public BillDetailAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recy_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BillDetailAdapter.ViewHolder viewHolder, int i) {
        final Bill bill = bills.get(i);
        viewHolder.item_name.setText(bill.getName());
        viewHolder.item_detail.setText(bill.getDetail());
        viewHolder.item_type.setText(bill.isPlus() ? "收入" : "支出");
        viewHolder.item_money.setText(String.valueOf(bill.getMoney()));
        viewHolder.item_time.setText(TimeUtil.getFormatTime(bill.getTime()));
        View editBtn = viewHolder.itemView.findViewById(R.id.bt_billEdit);
        editBtn.setOnClickListener(v -> {
            Intent intent = new Intent(context, EditBillActivity.class);
            intent.putExtra("bill", bill);
            context.startActivity(intent);
            ((Activity) context).finish();
        });
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_name;
        TextView item_money;
        TextView item_type;
        TextView item_detail;
        TextView item_time;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_money = itemView.findViewById(R.id.item_money);
            item_type = itemView.findViewById(R.id.item_type);
            item_detail = itemView.findViewById(R.id.item_detail);
            item_time = itemView.findViewById(R.id.item_time);
        }
    }
}
