package com.pierre2803.downloader.service;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class FtpDownloader extends ProtocolDownloader {

    FTPClient ftpClient = new FTPClient();

    public FtpDownloader(String url){
        super(url);
    }

    String server = "speedtest.tele2.net";
    int port = 21;
    String user = "";
    String pass = "";

    @Override
    void download() {

        connect();

        System.out.println("Downloading " + this.url);
        File dstFile = null;

        // check the directory for existence.
        String dstFolder = "/Users/pierre/devs/downloader/" + getFilename();

        dstFile = new File(dstFolder);
        //if (!dstFile.exists()) {
        //  dstFile.mkdirs();
        //}

        downloadFile(getFilename(), dstFolder);


        disconnect();
    }

    public void connect() {
        System.out.println("Connecting to " + server);
        ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        try {
            ftpClient.connect(server);
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new Exception("Exception in connecting to FTP Server");
            }
            ftpClient.login("anonymous", "");
            //ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void downloadFile(String remoteFilePath, String localFilePath) {
        try (FileOutputStream fos = new FileOutputStream(localFilePath)) {
            this.ftpClient.retrieveFile(remoteFilePath, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        System.out.println("Disconnecting from " + server);
        if (this.ftpClient.isConnected()) {
            try {
                this.ftpClient.logout();
                this.ftpClient.disconnect();
            } catch (IOException f) {
                // do nothing as file is already downloaded from FTP server
            }
        }
    }

}
