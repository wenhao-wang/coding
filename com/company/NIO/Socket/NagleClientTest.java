package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/21 下午8:24
 */

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class NagleClientTest {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost",8888);
            socket.setTcpNoDelay(false);

            InputStream inputStream = socket.getInputStream();
            long begintime = System.currentTimeMillis();

            byte[] byteArray = new byte[1];
            int readLength = inputStream.read(byteArray);
            while (readLength != -1){
                String newString = new String(byteArray,0,readLength);
                System.out.println(newString);
                readLength = inputStream.read(byteArray);
            }
            long endtime= System.currentTimeMillis();
            System.out.println("time:"+(endtime-begintime));

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
