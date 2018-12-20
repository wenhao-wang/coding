package com.company.NIO.Socket;/*
 * @description
 * 测试三次握手的过程-客户端
 * @author : wenhao
 * @create : 2018/12/20 下午9:07
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTest8 {
    public static void main(String[] args){
        System.out.println("client连接准备="+System.currentTimeMillis());
        try {
            Socket socket = new Socket();
            socket.bind(new InetSocketAddress("localhost",8080));
            socket.connect(new InetSocketAddress("localhost",8088));
            System.out.println("client连接结束="+System.currentTimeMillis());
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("123".getBytes());
            outputStream.write("123333".getBytes());
            outputStream.write("12333333333".getBytes());
            Thread.sleep(5000);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
