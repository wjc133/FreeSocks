package com.elite.freesocks.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.elite.freesocks.R;
import com.elite.freesocks.adapter.AccountAdapter;
import com.elite.freesocks.domain.Account;
import com.elite.freesocks.service.NetworkInfoGetter;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener {
    private RecyclerView recyclerView;
    private NetworkInfoGetter networkInfoGetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        networkInfoGetter = new NetworkInfoGetter();
        networkInfoGetter.getIShadowSocks(this, this);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(String response) {
        try {
            List<Account> accounts = networkInfoGetter.getAccounts(response);
            AccountAdapter adapter = new AccountAdapter(this, accounts);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
