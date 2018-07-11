package com.pierre2803.downloader.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "servers")
public class ServerListConfig {

    private List<String> list;

    @Value("${servers.timeout}")
    private int timeout;

    ServerListConfig() {
        this.list = new ArrayList<>();
    }

    public List<String> getList() {
        return this.list;
    }

    public int getTimeout() {
        return this.timeout;
    }

}