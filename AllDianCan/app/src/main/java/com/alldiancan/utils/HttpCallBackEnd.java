package com.alldiancan.utils;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Locale;

import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public  class HttpCallBackEnd<T> implements HttpRestCallRepository<T> {

    private String callUrl;
    private HashMap<String,String> headers;
    private HashMap<String,Object> params;
    private RequestBody requestbody;

    private OkHttpClient okHttpClient =new OkHttpClient();

    public HttpCallBackEnd() {

        if(okHttpClient==null) {
            okHttpClient =new OkHttpClient();
        }
    }

    @Override
    public T deleteRequest(String url, HashMap headers, HashMap params) throws Exception {

        return request(url,"DELETE",headers,params,null);
    }

    @Override
    public T getRequest(String url, HashMap headers, HashMap params) throws Exception {

        return request(url,"GET",headers,params,null);
    }

    @Override
    public T PostRequest(String url, HashMap headers, HashMap params, RequestBody requestBody) throws Exception {

        return request(url,"POST",headers,params,requestBody);
    }

    @Override
    public T putReqquest(String url, HashMap headers, HashMap params, RequestBody requestBody) throws Exception {

        return request(url,"PUT",headers,params,requestBody);
    }

    @Override
    public T request(String url, String method, HashMap headers, HashMap params, RequestBody requestBody) throws Exception {
        this.callUrl =url;
        this.headers =headers;
        this.params =params;
        this.requestbody =requestBody;
        OkHttpClient.Builder builder = okHttpClient.newBuilder();
        Request request = new Request.Builder()
                .url(url)
                .headers(Headers.of(headers))
                .addHeader("accept-language", Locale.getDefault().getLanguage() + '-' + Locale.getDefault().getCountry())
                .addHeader("content-type","application/json")
                .method(method, requestBody)
                .build();
        builder.cache(new Cache(new File("httpcache.json"), 50));
        Response response;
        ResponseBody responseBody;
        try {
            response = builder.build().newCall(request).execute();
            if(response.isSuccessful()) {
                responseBody= response.body();
               String retJsonstr= responseBody.string();
               return (T)JsonConverter.converToPOJOFromPlainTxt(retJsonstr, Type.class);
            }
        }catch (IOException e) {
            Log.i("ERR",e.getMessage());
        }
        return  null;
    }
}