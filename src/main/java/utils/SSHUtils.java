package utils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SSHUtils {
    private Connection conn;
    private String ipAddr;
    private Charset charset = StandardCharsets.UTF_8;
    private String userName;
    private String password;

    public SSHUtils(String ipAddr, String userName, String password) {
        this.ipAddr = ipAddr;
        this.userName = userName;
        this.password = password;
        if (charset != null) {
            this.charset = charset;
        }
    }

    /**
     * 登录远程Linux主机
     *
     * @return 是否登录成功
     */
    private boolean login() {
        conn = new Connection(ipAddr);
        try {
            conn.connect();
            return conn.authenticateWithPassword(userName, password);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 执行Shell脚本或命令
     *
     * @param cmds 命令行序列: 如 ls;pwd
     * @return 脚本输出结果
     */
    public String exec(String cmds) throws IOException {
        InputStream in = null;
        StringBuilder result = new StringBuilder();
        try {
            if (this.login()) {
                Session session = conn.openSession();
                session.execCommand(cmds);
                in = session.getStdout();
                result = this.processStdout(in, this.charset);
                conn.close();
            }
        } finally {
            if (null != in) {
                in.close();
            }
        }
        return result.toString();
    }

    /**
     * 解析流获取字符串信息
     *
     * @param in      输入流对象
     * @param charset 字符集
     * @return 脚本输出结果
     */
    public StringBuilder processStdout(InputStream in, Charset charset) {
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        try {
            int length;
            while ((length = in.read(buf)) != -1) {
                sb.append(new String(buf, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    /**
     * 下载到本地硬盘
     *
     * @param remoteFile 远程文件绝对路径 如：/home/users/error.txt
     * @param localPath  下载本地目录 如：C://Downloads//
     */
    public void getFile(String remoteFile, String localPath) {
        try {
            if (this.login()) {
                SCPClient scpClient = conn.createSCPClient();
                scpClient.get(remoteFile, localPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    /**
     * 上传到远程服务器
     *
     * @param localFile  本地文件绝对路径 如：C://Downloads//error.txt
     * @param remotePath 远程服务器目录 如：/home/
     */
    public void putFile(String localFile, String remotePath) {
        try {
            if (this.login()) {
                SCPClient scpClient = conn.createSCPClient();
                scpClient.put(localFile, remotePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}


