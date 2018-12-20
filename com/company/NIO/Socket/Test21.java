package com.company.NIO.Socket;/*
 * @description
 * 端口复用测试-不允许复用
 * @author : wenhao
 * @create : 2018/12/20 下午8:08
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test21 {
    public static void main(String[] args ) throws InterruptedException {
        Thread server = new Thread(){
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket();
                    serverSocket.setReuseAddress(true);
                    serverSocket.bind(new InetSocketAddress("localhost",8888));
                    Socket socket = serverSocket.accept();
                    Thread.sleep(1000);

                    socket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        server.start();

        Thread.sleep(500);

        Thread client = new Thread(){
            @Override
            public void run() {
                try {
                    Socket socket = new Socket("localhost",8888);
                    Thread.sleep(3000);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        client.start();
    }
}
