package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss  = new ServerSocket(9977);
            //创建一个serversocket其端口与发送端的端口是一样的
            Socket s = ss.accept();
            //侦听并接受到此套接字的连接，返回一个socket对象
            InputStream is = s.getInputStream();
            //获取到输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            byte[] buf = new byte[1024];
            //接收收到的数据
            int line = 0;
            while((line=is.read(buf))!=-1){
                System.out.println("socket server: " + new String(buf,0,line));
                //将接收到的数据在控制台输出
            }

            // 使用客户端的 Socket 对象的输出流给客户端返回数据
            OutputStream out = s.getOutputStream();
            out.write("收到\n".getBytes());

            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
