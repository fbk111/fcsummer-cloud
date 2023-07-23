package com.facility;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.ftp.FtpMode;
import org.junit.platform.commons.util.StringUtils;

import java.io.File;
import java.io.IOException;

public class FtpUtils {
    /**
     * 下载ftp服务器上的文件到本地
     * @param remoteFile
     * @param localFile
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param ftpMode
     * @return 成功则返回字符串:success
     */
    public static String download(String remoteFile, String localFile, String ip, Integer port, String username, String password, FtpMode ftpMode) {
        if(StringUtils.isBlank(localFile)) {
            return "本地保存路径及名称不能为空";
        }
        File lFile = FileUtil.file(localFile);
        Ftp ftp = null;
        try {
            //匿名登录（无需帐号密码的FTP服务器）
            ftp = new Ftp(ip,port == null ? 21 : port,username,password);
            if(ftpMode != null) {
                ftp.setMode(ftpMode);
            }
            ftp.download(remoteFile, lFile);
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            //关闭连接
            try {
                if(ftp != null)  ftp.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(lFile.exists() && lFile.length() > 0) {
            return "success";
        } else {
            lFile.delete();
            return "download failure,"+ remoteFile +" maybe not exists !!";
        }
    }

    /**
     * 此方法不指定上传后保存的名称， 则按本地文件的名称保存
     * @param remoteDir
     * @param localFile
     * @param ip
     * @param port
     * @param username
     * @param password
     * @return 成功则返回字符串:success
     */
    public static String upload(String remoteDir, String localFile, String ip, Integer port, String username, String password, FtpMode ftpMode) {
        return upload(remoteDir, null, localFile, ip, port, username, password, ftpMode);
    }

    /**
     *
     * @param remoteDir 上传的ftp目录
     * @param remoteFileName  保存到ftp服务器上的名称
     * @param localFile 本地文件全名称
     * @param ip
     * @param port
     * @param username
     * @param password
     * @return 成功则返回字符串:success
     */
    public static String upload(String remoteDir, String remoteFileName, String localFile, String ip, Integer port, String username, String password, FtpMode ftpMode) {
        if(StringUtils.isBlank(localFile)) {
            return "本地文件名称不能为空";
        }
        File lFile = FileUtil.file(localFile);
        if(!lFile.exists()) {
            return "本地文件不存在";
        }
        Ftp ftp = null;
        try {
            //匿名登录（无需帐号密码的FTP服务器）
            ftp = new Ftp(ip,port == null ? 21 : port,username,password);
            if(ftpMode != null) {
                ftp.setMode(ftpMode);
            }
            if(StringUtils.isBlank(remoteFileName)) {
                ftp.upload(remoteDir, lFile);
            } else {
                ftp.upload(remoteDir, remoteFileName, lFile);
            }
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            //关闭连接
            try {
                if(ftp != null)  ftp.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "success";
    }

    public static void main(String[] args) {
        //上传文件到ftp
        String result = FtpUtils.upload("/","a.java", "d:/a.java", "43.140.251.223", 21, "fbkftp1", "kun20021127", null);
        System.out.println(result);

        //下载远程文件
//        String result2 = FtpUtils.download("opt/upload/fff.zip", "D:/bbb.zip", "192.168.68.55", 21, "ftpuser", "ftpuser!@#123", null);
//        System.out.println(result2);

    }
}
