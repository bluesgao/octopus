package com.bluesgao.octopus.download;

import java.util.concurrent.Callable;

public abstract class AbstractDownloader implements Downloader, Callable {
    public String download(String url) {
        return null;
    }
    public Object call() throws Exception {
        return null;
    }
}
