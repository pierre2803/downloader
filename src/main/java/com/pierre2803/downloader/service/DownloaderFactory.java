package com.pierre2803.downloader.service;

public class DownloaderFactory {

    public ProtocolDownloader getProtocolDownloader(String url){
        if(url == null){
            return null;
        }
        if(getProtocolName(url).equalsIgnoreCase("http")){
            return new HttpDownloader(url);

        }

        return null;
    }

    public String getProtocolName(String url){
        if(url == null){
            return null;
        }
        return url.substring(0,url.indexOf(":"));
    }
}
