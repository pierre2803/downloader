package com.pierre2803.downloader.service;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class HttpDownloader extends ProtocolDownloader {

    public HttpDownloader(String url){
        super(url);
    }

    @Override
    void download() {

        System.out.println("Downloading " + this.url);
        File dstFile = null;

        // check the directory for existence.
        String dstFolder = "/Users/pierre/dev/downloader/" + getFilename();

        dstFile = new File(dstFolder);
        //if (!dstFile.exists()) {
        //  dstFile.mkdirs();
        //}
        try {
            URL url = new URL(this.url);
            FileUtils.copyURLToFile(url, dstFile);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
