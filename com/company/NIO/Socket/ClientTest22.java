package com.company.NIO.Socket;/*
 * @description
 * ReceiveBufferSize()重设缓冲区大小
 * @author : wenhao
 * @create : 2018/12/20 下午8:53
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class ClientTest22 {
    public static void main(String[] args){
        Socket socket = new Socket();
        try {
            System.out.println("begin "+ socket.getReceiveBufferSize());
            socket.connect(new InetSocketAddress("localhost",8088));
            System.out.println("end "+ socket.getReceiveBufferSize());

            OutputStream outputStream  = socket.getOutputStream();
            for(int i=0;i<100;i++){
                outputStream.write("1234567890098765432112345678900987654321123456789009876543211234567890098765432112345678900987654321123456789009876543211234567890098765432112345678900987654321123456789009876543211234567890098765432112345678900987654321123456789009876543211234567890098765432112345678900987654321".getBytes());
            }
            outputStream.write("end!".getBytes());

            outputStream.close();
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
