package basic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


public class UdpSend {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);                        //创建键盘录入对象
        DatagramSocket socket = new DatagramSocket();                //创建Socket相当于创建码头

        while (true) {
            String line = sc.nextLine();                            //获取键盘录入的字符串
            if ("quit".equals(line)) {
                break;
            }
            DatagramPacket packet =                                 //创建Packet相当于集装箱
                    new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
            socket.send(packet);                                    //发货,将数据发出去
        }
        socket.close();

    }
}
