package com.elite.freesocks.service;

import android.support.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.elite.freesocks.application.FreeSocksApplication;
import com.elite.freesocks.domain.Account;
import com.elite.freesocks.utils.StringUtils;
import com.google.common.collect.Lists;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by wjc133.
 * Date: 2016/2/24
 * Time: 0:26
 * Description:获取网络上的信息
 */
public class NetworkInfoGetter {
    private static final String URL = "http://www.ishadowsocks.com";

    public List<Account> getAccounts(Response.Listener<String> listener, Response.ErrorListener errorListener) {
        List<Account> accounts = Lists.newArrayList();
//        accounts.addAll(getIShadowSocks(listener, errorListener));
        return accounts;
    }

    public void getIShadowSocks(Response.Listener<String> listener, Response.ErrorListener errorListener) {
        StringRequest request = new StringRequest(Request.Method.GET, URL, listener, errorListener);
        FreeSocksApplication.getRequestQueue().add(request);
    }

    @NonNull
    public List<Account> getAccounts(String response) throws UnsupportedEncodingException {
        String s = new String(response.getBytes("ISO-8859-1"), "utf-8");
        System.out.println(s);
        Document doc = Jsoup.parse(s);
        Element mainBody = doc.getElementById("free");
        Elements list = mainBody.select("div > div > div.col-lg-4");
        List<Account> accounts = Lists.newArrayList();
        for (Element element : list) {
            Account account = new Account();
            Elements contents = element.select("h4");
            account.setUrl(StringUtils.getContent(contents.get(0).text()));
            account.setPort(Integer.parseInt(StringUtils.getContent(contents.get(1).text())));
            account.setPassword(StringUtils.getContent(contents.get(2).text()));
            account.setEncryption(StringUtils.getContent(contents.get(3).text()));
            account.setStatus(StringUtils.getContent(contents.get(4).text()));
            accounts.add(account);
        }
        return accounts;
    }
}
