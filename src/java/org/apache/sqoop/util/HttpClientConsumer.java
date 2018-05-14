package org.apache.sqoop.util;


import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

/**
 * Created by myy on 2016/11/29.
 */
public class HttpClientConsumer {
    public static void main(String[] args) throws Exception{
        int nodes = getNodes("http://192.168.31.126:9200/_cat/health", "UTF-8");
        System.out.println("nodes = " + nodes);
    }

    public static int getNodes(String url,String charset) {
    /* 1 生成 HttpClinet 对象并设置参数 */
        HttpClient httpClient = new HttpClient();
        // 设置 Http 连接超时为5秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(60000);
        /* 2 生成 GetMethod 对象并设置参数 */
        url = "http://" + url + "/_cat/health";
        GetMethod getMethod = new GetMethod(url);
        // 设置 get 请求超时为 5 秒
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        // 设置请求重试处理，用的是默认的重试处理：请求三次
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,	new DefaultHttpMethodRetryHandler());
        String response = "";
        /* 3 执行 HTTP GET 请求 */
        try {
            int statusCode = httpClient.executeMethod(getMethod);
      /* 4 判断访问的状态码 */
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("请求出错: "+ getMethod.getStatusLine());
            }
      /* 5 处理 HTTP 响应内容 */
            // HTTP响应头部信息，这里简单打印
            Header[] headers = getMethod.getResponseHeaders();
//            for (Header h : headers)
//                System.out.println(h.getName() + "------------ " + h.getValue());
            // 读取 HTTP 响应内容，这里简单打印网页内容
            byte[] responseBody = getMethod.getResponseBody();// 读取为字节数组
            response = new String(responseBody, charset);
//            System.out.println("----------response:" + response);
            String[] split = response.split(" ");
//            System.out.println("split[3] = " + split[3]);
            return Integer.parseInt(split[4]);
            // 读取为 InputStream，在网页内容数据量大时候推荐使用
            // InputStream response = getMethod.getResponseBodyAsStream();
        } catch (HttpException e) {
            // 发生致命的异常，可能是协议不对或者返回的内容有问题
            System.err.println("请检查输入的URL!");
            e.printStackTrace();
        } catch (IOException e) {
            // 发生网络异常
            System.err.println("发生网络异常!");
            e.printStackTrace();
        } finally {
      /* 6 .释放连接 */
            getMethod.releaseConnection();
        }
        return -1;
    }
}
