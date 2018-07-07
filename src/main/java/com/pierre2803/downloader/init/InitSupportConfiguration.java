package com.pierre2803.downloader.init;

import com.pierre2803.downloader.service.DownloaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class InitSupportConfiguration {

    @Autowired
    DownloaderService downloaderService;

    @Bean
    public DownloaderService DownloaderService() {
        return new DownloaderService();
    }

    @Bean
    public int startServices() {
        return downloaderService.start();
    }

}
