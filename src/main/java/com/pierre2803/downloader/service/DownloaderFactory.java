package com.pierre2803.downloader.service;

public class DownloaderFactory {

    public ProtocolDownloader getProtocolDownloader(String url){
        if(url == null){
            return null;
        }
        if(getProtocolName(url).equalsIgnoreCase("http")){
            return new HttpDownloader(url);
        } else if(getProtocolName(url).equalsIgnoreCase("ftp")){
            return new FtpDownloader(url);
        } else if(getProtocolName(url).equalsIgnoreCase("sftp")){
            return new SftpDownloader(url);
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
