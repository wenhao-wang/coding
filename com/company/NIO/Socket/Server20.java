package com.company.NIO.Socket;/*
 * @description
 * 测试本操作系统可连接的backlog的极限值
 * 测试为128
 * @author : wenhao
 * @create : 2018/12/20 下午7:07
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Server20 {
    public static void main(String[] args) throws IOException,InterruptedException{
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8088),Integer.MAX_VALUE);
        Thread.sleep(20000);
        serverSocket.close();
    }
}
