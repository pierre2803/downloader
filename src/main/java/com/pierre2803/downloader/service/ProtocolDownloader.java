package com.pierre2803.downloader.service;

public abstract class ProtocolDownloader {

    String url;

    ProtocolDownloader(String url){
        this.url = url;
    }

    abstract void download();

    public String getFilename(){
        return this.url.substring(this.url.lastIndexOf("/"));
    }

    public String getProtocolName(){
        if(this.url == null){
            return null;
        }
        return url.substring(0,url.indexOf(":")-1);
    }

}
