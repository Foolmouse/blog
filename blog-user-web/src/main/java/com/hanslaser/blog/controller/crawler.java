package com.hanslaser.blog.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class crawler {
    static Pattern r;
    static HttpGet httpGet;
    static HttpClient httpClient;
    static String url = "https://m.10010.com/NumApp/NumberCenter/qryNum?" +
            "callback=jsonp_obksaa9a40m&provinceCode=51&cityCode=540&monthFeeLimit=0&groupKey=73044235&searchCategory=3&net=01&amounts=200" +
            "&codeTypeCode=&searchValue=&qryType=02&goodsNet=4&_=1594543071022";

    static {
        String pattern = "\\d{11,12}?";
        r = Pattern.compile(pattern);
        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet(url);
    }

    public static void main(String[] args) throws IOException {
        HashSet<Object> list = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            Matcher m = r.matcher(result);
            while (m.find()) {
                list.add(m.group());
            }
        }

        for (Object o : list) {
            System.out.println(o.toString());
        }

    }
}
