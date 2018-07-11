package com.pierre2803.downloader.service;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Component
public class DownloaderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DownloaderService.class);

    @Value("${project.name}")
    String projectName;

    //@Value("${download.servers}")
    ArrayList<String> servers = new ArrayList<String>();

    public void init(){
        servers.add("http://releases.ubuntu.com/14.04.3/ubuntu-14.04.3-desktop-amd64.iso");
        servers.add("http://apache.mirror.globo.tech//httpd/httpd-2.4.33.tar.bz2");
        servers.add("ftp://speedtest.tele2.net/50MB.zip");

        //https://test.rebex.net/
        // Username/password = demo/password
        servers.add("sftp://test.rebex.net/readme.txt");
    }

    public int start (){
        init();

        System.out.println(projectName);
        System.out.println("START DOWNLOAD " + servers);
        for(int i=0; i<servers.size(); i++)
            System.out.println("servers: " + servers.get(i));

        DownloaderFactory factory = new DownloaderFactory();

        ProtocolDownloader dl = factory.getProtocolDownloader(servers.get(3));
        dl.download();

        return 0;
    }

}
