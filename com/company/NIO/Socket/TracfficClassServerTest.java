package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/21 下午11:00
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TracfficClassServerTest {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8808);
            Socket socket = serverSocket.accept();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
