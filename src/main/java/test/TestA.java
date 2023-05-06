package test;

import utils.SSHUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestA {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(new Date());

        String conf = "d:\\Nodes.txt";
        String save = "d:\\";
        int s = 2;
        int c = 5;

        TestA testa = new TestA();
        testa.start(conf, time, s, c);
        testa.end(conf, save, time);
    }

    public void start(String conf, String time, int s, int c) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(conf));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("ip") && line.contains("username") && line.contains("password") && line.contains("savedir") && line.contains("cmdpath")) {
                    String[] split = line.replaceAll(" ", "").split(",");
                    String ip = split[0].substring(3);
                    String username = split[1].substring(9);
                    String password = split[2].substring(9);
                    String savedir = split[3].substring(8);
                    String cmdpath = split[4].substring(8);
                    SSHUtils sshUtils = new SSHUtils(ip, username, password);
                    String cmds = cmdpath + " -F " + savedir + ip + "_" + time + ".nmon -s " + s + " -c " + c;
                    sshUtils.exec(cmds);
                } else {
                    throw new RuntimeException("ip=192.168.31.35, username=root, password=root, savedir=/root/perf/, cmdpath=/root/nmon");
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void end(String conf, String localdir, String time) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(conf));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("ip") && line.contains("username") && line.contains("password") && line.contains("savedir") && line.contains("cmdpath")) {
                    String[] split = line.replaceAll(" ", "").split(",");
                    String ip = split[0].substring(3);
                    String username = split[1].substring(9);
                    String password = split[2].substring(9);
                    String savedir = split[3].substring(8);
                    SSHUtils sshUtils = new SSHUtils(ip, username, password);
                    sshUtils.getFile(savedir + ip + "_" + time + ".nmon", localdir);
                } else {
                    throw new RuntimeException("ip=192.168.31.35, username=root, password=root, savedir=/root/perf/, cmdpath=/root/nmon");
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
