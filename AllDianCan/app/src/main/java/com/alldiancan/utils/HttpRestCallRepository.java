package com.alldiancan.utils;

import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by laliu on 1/11/2018.
 */
public interface HttpRestCallRepository<T> {

        T getRequest(String url,HashMap<String,String> headers, HashMap<String,Object> params) throws Exception;

        T PostRequest(String url,HashMap<String,String> headers,HashMap<String,Object> params, RequestBody requestBody) throws Exception;

        T putReqquest(String url,HashMap<String,String> headers,HashMap<String,Object> params,RequestBody requestBody) throws Exception;

        T deleteRequest(String url,HashMap<String,String> headers, HashMap<String,Object> params) throws Exception;

        T request(String url,String method,HashMap<String,String> headers,HashMap<String,Object> params,RequestBody requestBody) throws Exception;
}
