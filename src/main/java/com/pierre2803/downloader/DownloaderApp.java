package com.pierre2803.downloader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
public class DownloaderApp {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application");
		SpringApplication.run(DownloaderApp.class, args);
	}

}
