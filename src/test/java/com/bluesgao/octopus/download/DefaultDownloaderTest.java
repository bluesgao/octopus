package com.bluesgao.octopus.download;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DefaultDownloaderTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        List<String> handledUrls = new ArrayList<String>();
        List<String> urls = new ArrayList<String>();
        urls.add("http://www.baidu.com");
        urls.add("http://www.jd.com");
        urls.add("http://www.google.com");

        for (String url : urls) {
            DefaultDownloader downloader = new DefaultDownloader(url);

            Future<String> future = threadPool.submit(downloader);
            try {
                System.out.println("future->" + future.get(3000, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                handledUrls.add(url);
            }
        }

        if (handledUrls.size() == urls.size()){
            System.out.println("threadPool.shutdown");
            threadPool.shutdown();
        }
    }
}