package com.company.NIO.Socket;/*
 * @description
 * 测试三次握手的过程-服务端
 * @author : wenhao
 * @create : 2018/12/20 下午9:07
 */

import java.io.IOException;
import java.net.ServerSocket;

public class ServerTest8 {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("server阻塞开始="+System.currentTimeMillis());
            serverSocket.accept();
            System.out.println("server 阻塞结束="+System.currentTimeMillis());
            Thread.sleep(8000);
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
