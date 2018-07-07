package com.pierre2803.downloader.service;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.net.URL;

public class DownloaderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DownloaderService.class);

    @Value("${parser.wanderlust.baseUrl}")
    private String baseUrl;

    @Value("${parser.wanderlust.icsfilename}")
    private String icsfilename;

    String httpFile = "http://releases.ubuntu.com/14.04.3/ubuntu-14.04.3-desktop-amd64.iso";
    String httpFile2 = "http://apache.mirror.globo.tech//httpd/httpd-2.4.33.tar.bz2";

    public int start (){
        System.out.println("START DOWNLOAD");


        File dstFile = null;

        // check the directory for existence.
        String dstFolder = "/Users/pierre/dev/downloader/test.iso";

// Creates the destination folder if doesn't not exists
        dstFile = new File(dstFolder);
        //if (!dstFile.exists()) {
          //  dstFile.mkdirs();
        //}
        try {
            URL url = new URL(httpFile);
            FileUtils.copyURLToFile(url, dstFile);
        } catch (Exception e) {
            System.err.println(e);
        }


        return 0;
    }

}
