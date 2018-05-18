package com.bluesgao.octopus.download;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultDownloader extends AbstractDownloader {
    private String url;
    private String content;
    private static final Logger LOG = LoggerFactory.getLogger(DefaultDownloader.class);

    public DefaultDownloader(String url) {
        this.url = url;
    }

    @Override
    public String download(String url) {
        System.out.println("download url:" + url);
        try {
            this.httpDownload(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thread:" + Thread.currentThread().getName() + "; url " + url + "; content " + this.content.toString();
    }

    @Override
    public Object call() throws Exception {
        return this.download(url);
    }

    private void httpDownload(String url) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;

        try {
            httpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(url);
            response = httpClient.execute(get);
        } finally {
            this.content = (response != null ? response.toString() : null);
            httpClient = null;
            response = null;
        }
    }
}
