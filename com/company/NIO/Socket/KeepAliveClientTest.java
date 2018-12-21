package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/21 下午10:44
 */

import java.io.IOException;
import java.net.Socket;

public class KeepAliveClientTest {
    public static void main(String[] args){
        try {
            System.out.println("Client begin ");
            Socket socket = new Socket("localhost",8888);
            System.out.println("a  = "+socket.getKeepAlive());
            socket.setKeepAlive(true);
            System.out.println("b= "+socket.getKeepAlive());
            System.out.println("end Client");

            Thread.sleep(Integer.MAX_VALUE);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
