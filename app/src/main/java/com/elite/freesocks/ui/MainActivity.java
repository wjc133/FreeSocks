package com.elite.freesocks.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.elite.freesocks.R;
import com.elite.freesocks.adapter.AccountAdapter;
import com.elite.freesocks.domain.Account;
import com.elite.freesocks.service.NetworkInfoGetter;
import com.google.common.collect.Lists;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        NetworkInfoGetter networkInfoGetter = new NetworkInfoGetter();
        networkInfoGetter.getIShadowSocks(this, this);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(String response) {
        try {
            String s = new String(response.getBytes("ISO-8859-1"), "utf-8");
            System.out.println(s);
            Document doc = Jsoup.parse(s);
            Element mainBody = doc.getElementById("free");
            Elements list = mainBody.select("div > div > div.col-lg-4");
            List<Account> accounts = Lists.newArrayList();
            for (Element element : list) {
                Account account = new Account();
                Elements contents = element.select("h4");
                account.setUrl(contents.get(0).text());
                account.setPort(Integer.parseInt(contents.get(1).text().split(":")[1]));
                account.setPassword(contents.get(2).text());
                account.setEncryption(contents.get(3).text());
                account.setStatus(contents.get(4).text());
                accounts.add(account);
            }
            AccountAdapter adapter = new AccountAdapter(this, accounts);
            this.listView.setAdapter(adapter);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
