package com.alldiancan.utils;

import android.os.AsyncTask;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by laliu on 12/7/2017.
 */
public class HttpCallBackEnd extends AsyncTask<Object,Object,Object> {
    private final String domain ="http://rest-service.guides.spring.io/";
    private List<Object> retCollections;
    @Override
    protected Object doInBackground(Object... params) {
        RestTemplate restTemplate =new RestTemplate();
        retCollections = new ArrayList<Object>();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        for(Object objType :params) {
            String tmpurl =domain.concat(objType.getClass().getSimpleName());

            Object retObj= restTemplate.getForObject(tmpurl, objType.getClass());

            retCollections.add(retObj);
        }
        return retCollections;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }
}
