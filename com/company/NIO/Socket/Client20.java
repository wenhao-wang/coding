package com.company.NIO.Socket;/*
 * @description
 * 测试本操作系统可连接的backlog的极限值
 * 测试为128
 * @author : wenhao
 * @create : 2018/12/20 下午7:10
 */

import java.io.IOException;
import java.net.Socket;

public class Client20 {
    public static void main(String[] args) throws IOException,InterruptedException{
        for(int i=0;i<5000;i++){
            Socket socket = new Socket("localhost",8088);
            System.out.println("Client request and link :"+(i+1));
        }
    }
}
