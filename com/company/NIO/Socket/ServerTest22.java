package com.company.NIO.Socket;/*
 * @description
 * ReceiveBufferSize设置接收缓冲区的大小
 * @author : wenhao
 * @create : 2018/12/20 下午8:46
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest22 {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("A server serversocket.getReceiveBufferSize()="+serverSocket.getReceiveBufferSize());

            serverSocket.setReceiveBufferSize(66);
            System.out.println("B server serversocket.getReceiveBufferSize()="+serverSocket.getReceiveBufferSize());

            serverSocket.bind(new InetSocketAddress("localhost",8088));
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] charArray = new char[1024];
            int readLength = inputStreamReader.read(charArray);
            while (readLength != -1){
                String str = new String(charArray,0,readLength);
                System.out.println(str);
                readLength = inputStreamReader.read(charArray);
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
