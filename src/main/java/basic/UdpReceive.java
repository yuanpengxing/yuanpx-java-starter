package basic;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceive {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);        //创建Socket相当于创建码头
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);//创建Packet相当于创建集装箱

        while (true) {
            socket.receive(packet);                                    //接货,接收数据

            byte[] arr = packet.getData();                            //获取数据
            int len = packet.getLength();                            //获取有效的字节个数
            String ip = packet.getAddress().getHostAddress();        //获取ip地址
            int port = packet.getPort();                            //获取端口号
            System.out.println(ip + ":" + port + ":" + new String(arr, 0, len));
        }
    }

}
