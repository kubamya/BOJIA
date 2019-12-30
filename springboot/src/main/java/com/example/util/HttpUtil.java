package com.example.util;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.*;

public class HttpUtil {

    /**
     *
     * @param url 请求地址
     * @param map 请求参数
     * @param headers 请求头
     * @param encoding 请求编码（固定传UTF-8）
     * @return
     * @throws Exception
     */
    public static String get(String url, Map<String, String> map, Map<String, Object> headers, String encoding)
            throws Exception {
        /* 创建HttpClient 对象 */

        /* 创建返回数据 */
        String result = null;
        try (CloseableHttpClient closeableHttpClient = HttpClients.createDefault()) {

            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000)
                    .setConnectionRequestTimeout(3000).setSocketTimeout(3000).build();

            /* 装填请求参数 */
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            if (map != null) {
                /* 遍历请求参数封装 */
                for (Map.Entry<String, String> enrty : map.entrySet()) {
                    nameValuePairList.add(new BasicNameValuePair(enrty.getKey(), enrty.getValue()));
                }
            }
            /* 转换为键值对 */
            String parameterValue = EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairList, "UTF-8"));
            String address = url;
            if (!"".equals(parameterValue)) {
                address += "?" + parameterValue;
            }
            /* 创建Get请求对象 */
            HttpGet httpGet = new HttpGet(address);
            httpGet.setConfig(requestConfig);
            // setHeader,添加头文件
            if(headers != null){
                Set<String> keys = headers.keySet();
                for (String key : keys) {
                    httpGet.setHeader(key, headers.get(key).toString());
                }
            }

            /* 执行Get请求操作 */
            try (CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet)) {
                /* 获取请求响应数据 */
                HttpEntity httpEntity = closeableHttpResponse.getEntity();
                if (httpEntity != null) {
                    /* 获取的值转换为键值对 */
                    result = EntityUtils.toString(httpEntity, encoding);
                }
                /* 关闭 输入流、释放资源 */
                EntityUtils.consume(httpEntity);
            }
        }
        return result;
    }

    /**
     * POST 请求
     *
     * @param url      请求地址
     * @param map      请求参数
     * @param encoding 请求编码
     * @return
     */
    public static String post(String url, Map<String, String> map, Map<String, Object> headers, String body, String encoding) throws Exception {
        /* 创建HttpClient 对象 */

        /* 创建返回数据 */
        String result = null;
        try (CloseableHttpClient closeableHttpClient = HttpClients.createDefault()) {

            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000)
                    .setConnectionRequestTimeout(1000).setSocketTimeout(1000).build();

            /* 装填请求参数 */
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            if (map != null) {
                /* 遍历请求参数封装 */
                for (Map.Entry<String, String> enrty : map.entrySet()) {
                    nameValuePairList.add(new BasicNameValuePair(enrty.getKey(), enrty.getValue()));
                }
            }
            /* 转换为键值对 */
            String parameterValue = EntityUtils.toString(new UrlEncodedFormEntity(nameValuePairList, "UTF-8"));
            String address = url;
            if (!"".equals(parameterValue)) {
                address += "?" + parameterValue;
            }
            /* 创建Get请求对象 */
            HttpPost httpPost = new HttpPost(address);
            httpPost.setConfig(requestConfig);
            if(StringUtils.isNotBlank(body)) {
                httpPost.setEntity(new StringEntity(body, "UTF-8"));
            }
            // setHeader,添加头文件
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                httpPost.setHeader(key, headers.get(key).toString());
            }
            /* 执行Post请求操作 */
            try (CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpPost)) {
                /* 获取请求响应数据 */
                HttpEntity httpEntity = closeableHttpResponse.getEntity();
                if (httpEntity != null) {
                    /* 获取的值转换为键值对 */
                    result = EntityUtils.toString(httpEntity, encoding);
                }
                /* 关闭 输入流、释放资源 */
                EntityUtils.consume(httpEntity);
            }
        }
        return result;
    }
}
