package com.pierre2803.downloader.service;

import com.pierre2803.downloader.init.ServerListConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Component
public class DownloaderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DownloaderService.class);

    @Value("${project.name}")
    String projectName;

    @Autowired
    ServerListConfig serverList;

    public int start (){
        LOGGER.info("Starting " + projectName);
        LOGGER.info("Timeout set to " + serverList.getTimeout());

        DownloaderFactory factory = new DownloaderFactory();
        serverList.getList().forEach(server -> {
            LOGGER.info("Adding " + server);
            //ProtocolDownloader dwnldr = factory.getProtocolDownloader(server);
            //dwnldr.download();
        });

        // Make a tread !!!

        return 0;
    }

}

/*
* adding a link via config
* if user and password are needed, add them to the end of the URL with # so it looks like url#user#password
* Timeout is used to stop a hanging download
* After timeout, an exception is caught and the partial data is deleted
* Add a new protocol by implementing the interface ProtocolDownloader
*
* */