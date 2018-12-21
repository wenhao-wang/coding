package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/21 下午10:42
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class KeepAliveServerTest {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server begin");
            Socket socket = serverSocket.accept();
            System.out.println("server end ");
            Thread.sleep(Integer.MAX_VALUE);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
