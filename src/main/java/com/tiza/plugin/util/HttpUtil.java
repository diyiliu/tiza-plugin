package com.tiza.plugin.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Description: HttpUtil
 * Author: DIYILIU
 * Update: 2018-12-21 09:38
 */
public class HttpUtil {

    /**
     * GET 请求
     *
     * @param url
     * @param param
     * @return
     * @throws Exception
     */
    public static String getForString(String url, Map param) throws Exception {
        URIBuilder builder = new URIBuilder(url);

        List args = new ArrayList();
        for (Iterator iterator = param.keySet().iterator(); iterator.hasNext();){
            String key = (String) iterator.next();
            String value = String.valueOf(param.get(key));

            args.add(new BasicNameValuePair(key, value));
        }
        builder.addParameters(args);

        HttpGet httpGet = new HttpGet(builder.build());
        RequestConfig config = RequestConfig.custom()
                // 连接时间
                .setConnectTimeout(3 * 1000)
                // 请求超时
                .setConnectionRequestTimeout(10 * 1000)
                // 数据传输时间
                .setSocketTimeout(3 * 1000).build();

        HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();

        return EntityUtils.toString(entity, "UTF-8");
    }

}
