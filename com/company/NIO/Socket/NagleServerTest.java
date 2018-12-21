package com.company.NIO.Socket;/*
 * @description
 * TCP_NODELAY参数分析，默认false，有延时
 * @author : wenhao
 * @create : 2018/12/21 下午8:19
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NagleServerTest {
        public static void main(String[] args){
            try {
                ServerSocket serverSocket = new ServerSocket(8888);
                Socket socket = serverSocket.accept();
                System.out.println("A:"+ socket.getTcpNoDelay());
                socket.setTcpNoDelay(false);
                System.out.println("B:" +socket.getTcpNoDelay());

                OutputStream outputStream = socket.getOutputStream();
                for(int i=0;i< 100000 ; i++){
                    outputStream.write("1".getBytes());
                }
                System.out.println("close start time:"+System.currentTimeMillis()
                );
                socket.close();
                System.out.println("close end time: "+System.currentTimeMillis());
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
