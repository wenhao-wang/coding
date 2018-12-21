package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/21 下午11:01
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TrafficClassClientTest {
    public static void main(String[] args){
        try {
            Socket socket = new Socket();
            socket.setTrafficClass(0x10);
            socket.connect(new InetSocketAddress("localhost",8808));
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是发送的数据".getBytes());
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
