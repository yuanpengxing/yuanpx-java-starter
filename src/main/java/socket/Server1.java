package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) {
        try {
            ServerSocket server=new ServerSocket(8888);
            //调用服务器套接字对象中的方法accept()获取客户端套接字对象
            Socket socket=server.accept();
            //通过客户端套接字对象，socket获取字节输入流,读取的是客户端发送来的数据
            InputStream in=socket.getInputStream();
            byte[] data=new byte[1024];
            int len=in.read(data);

            System.out.println(new String(data,0,len));

            //服务器向客户端回数据，字节输出流，通过客户端套接字对象获取字节输出流
            OutputStream out=socket.getOutputStream();
            out.write(("hello tcp}").getBytes());

//            socket.close();
//            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
