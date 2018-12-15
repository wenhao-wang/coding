package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/15 下午11:25
 */

import java.io.IOException;
import java.net.Socket;

public class ClientSocketTest {
    public static void main(String[] args){
        try{
            System.out.println("client 连接准备="+System.currentTimeMillis());
            Socket socket = new Socket("localhost",8088);
            System.out.println("Client 连接结束="+System.currentTimeMillis());
            socket.close();

        }catch (IOException e){

        }
    }
}
