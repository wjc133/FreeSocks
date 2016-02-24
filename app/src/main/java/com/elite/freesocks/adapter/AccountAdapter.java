package com.elite.freesocks.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.elite.freesocks.R;
import com.elite.freesocks.domain.Account;

import java.util.List;

/**
 * Created by wjc133.
 * Date: 2016/2/24
 * Time: 0:59
 * Description:账户适配器
 */
public class AccountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnLongClickListener {
    private Context context;
    private LayoutInflater inflater;
    private List<Account> data;

    @Override
    public boolean onLongClick(View v) {
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        Account account = (Account) v.getTag();
        cmb.setPrimaryClip(ClipData.newPlainText("password", account.getPassword()));
        Toast.makeText(context, "已复制", Toast.LENGTH_SHORT).show();
        return true;
    }

    public AccountAdapter(Context context, List<Account> accounts) {
        this.data = accounts;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        view.setOnLongClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).itemView.setTag(data.get(position));
            ((ViewHolder) holder).urlView.setText(data.get(position).getUrl());
            ((ViewHolder) holder).portView.setText(String.format("%d", data.get(position).getPort()));
            ((ViewHolder) holder).passwordView.setText(data.get(position).getPassword());
            ((ViewHolder) holder).encryptionView.setText(data.get(position).getEncryption());
            ((ViewHolder) holder).statusView.setText(data.get(position).getStatus());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView urlView;
        TextView portView;
        TextView passwordView;
        TextView encryptionView;
        TextView statusView;

        public ViewHolder(View view) {
            super(view);
            this.itemView = view;
            urlView = (TextView) view.findViewById(R.id.url);
            portView = (TextView) view.findViewById(R.id.port);
            passwordView = (TextView) view.findViewById(R.id.password);
            encryptionView = (TextView) view.findViewById(R.id.encryption);
            statusView = (TextView) view.findViewById(R.id.status);
        }
    }
}
