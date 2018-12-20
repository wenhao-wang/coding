package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/20 下午8:14
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Test21_1 {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("accept begin");
            Socket socket = serverSocket.accept();
            System.out.println("accept end");
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
