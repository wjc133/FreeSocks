package com.elite.freesocks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.elite.freesocks.R;
import com.elite.freesocks.domain.Account;

import java.util.List;

/**
 * Created by wjc133.
 * Date: 2016/2/24
 * Time: 0:59
 * Description:
 */
public class AccountAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Account> data;

    public AccountAdapter(Context context, List<Account> accounts) {
        this.data = accounts;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.urlView.setText("server:" + data.get(position).getUrl());
        viewHolder.portView.setText("port:" + data.get(position).getPort());
        viewHolder.passwordView.setText("password:" + data.get(position).getPassword());
        viewHolder.encryptionView.setText("encryption:" + data.get(position).getEncryption());
        viewHolder.statusView.setText("status:" + data.get(position).getStatus());
        return convertView;
    }

    private class ViewHolder {
        TextView urlView;
        TextView portView;
        TextView passwordView;
        TextView encryptionView;
        TextView statusView;

        public ViewHolder(View view) {
            urlView = (TextView) view.findViewById(R.id.url);
            portView = (TextView) view.findViewById(R.id.port);
            passwordView = (TextView) view.findViewById(R.id.password);
            encryptionView = (TextView) view.findViewById(R.id.encryption);
            statusView = (TextView) view.findViewById(R.id.status);
        }
    }
}
