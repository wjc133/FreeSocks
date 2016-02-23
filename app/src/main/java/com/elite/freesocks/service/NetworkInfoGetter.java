package com.elite.freesocks.service;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.elite.freesocks.application.FreeSocksApplication;
import com.elite.freesocks.domain.Account;
import com.google.common.collect.Lists;

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
}
