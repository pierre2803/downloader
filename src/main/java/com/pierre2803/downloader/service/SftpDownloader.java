package com.pierre2803.downloader.service;

import com.jcraft.jsch.*;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class SftpDownloader extends ProtocolDownloader {

    public SftpDownloader(String url){
        super(url);
    }

    String server = "test.rebex.net";
    int port = 22;
    String user = "demo";
    String pass = "password";

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

        System.out.println("Connecting to " + server);
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(user, server, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(pass);
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            System.out.println("getFilename " + getFilename());
            System.out.println("dstFolder " + dstFolder);
            sftpChannel.get(getFilename(), dstFolder);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }


    }


}
