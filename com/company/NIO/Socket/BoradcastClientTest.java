package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/22 下午12:01
 */

import java.io.IOException;
import java.net.*;

public class BoradcastClientTest {
    public static void main(String[] args){
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);
            socket.connect(InetAddress.getByName("10.6.255.255"),7777);

            String string = "_____12345";
            byte[] byteArray = string.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(byteArray,byteArray.length);

            socket.send(datagramPacket);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
