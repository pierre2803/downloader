package com.pierre2803.downloader.service;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class DownloaderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DownloaderService.class);

    String httpFile = "http://releases.ubuntu.com/14.04.3/ubuntu-14.04.3-desktop-amd64.iso";
    String httpFile2 = "http://apache.mirror.globo.tech//httpd/httpd-2.4.33.tar.bz2";

    @Value("${project.name}")
    String projectName;

    @Value("${server}")
    String server;

    @Value("${download.servers}")
    List<String> servers = new ArrayList<String>();

    public int start (){
        System.out.println(projectName);
        System.out.println("START DOWNLOAD "+server+" " + servers);
        for(int i=0; i<servers.size(); i++)
            System.out.println("servers: " + servers.get(i));


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
