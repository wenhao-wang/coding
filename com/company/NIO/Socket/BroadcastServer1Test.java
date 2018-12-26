package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/22 上午11:58
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class BroadcastServer1Test {
    public static void main(String[] args){
        try {
//            DatagramSocket socket = new DatagramSocket(7777);
            DatagramSocket socket = new DatagramSocket(new InetSocketAddress("10.6.255.255",7777));
            byte[] byteArray = new byte[10];
            DatagramPacket datagramPacket = new DatagramPacket(byteArray,byteArray.length);

            socket.receive(datagramPacket);
            socket.close();

            byteArray = datagramPacket.getData();
            System.out.println(new String(byteArray,0,byteArray.length));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
