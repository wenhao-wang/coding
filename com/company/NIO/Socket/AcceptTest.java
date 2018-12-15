package com.company.NIO.Socket;/*
 * @description
 * 验证accept具有阻塞性，当没有客户端连接服务端时，呈阻塞状态
 * @author : wenhao
 * @create : 2018/12/15 下午11:20
 */

import java.io.IOException;
import java.net.ServerSocket;

public class AcceptTest {
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("server阻塞开始=" + System.currentTimeMillis());
            serverSocket.accept();
            System.out.println("server 阻塞结束"+System.currentTimeMillis());
            serverSocket.close();
        }catch (IOException e){

        }


    }
}
