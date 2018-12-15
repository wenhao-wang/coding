package com.company.NIO.Channel.FileChannel;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/15 下午2:23
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReadTest1_2 {
    private static FileInputStream fisRef;
    private static FileChannel fileChannel;
    public static void main(String[] args) throws IOException, InterruptedException {

        fisRef = new FileInputStream(new File("/Users/wenhao/a.text"));
        fileChannel= fisRef.getChannel();
//        TestBackValue();
//        System.out.println("-----------------");
//        TestReadPOsition(fileChannel);
        System.out.println("Synchronize 测试");
        SynchronizeReadTest();
        Thread.sleep(3000);
        fileChannel.close();
        fisRef.close();
    }

    private static void SynchronizeReadTest() {
        for(int i=0;i<1;i++){
            Thread th1 = new Thread(){
                @Override
                public void run() {
                    ByteBuffer buffer = ByteBuffer.allocate(5);
                    try {
                        int readlength = fileChannel.read(buffer);
                        while(readlength != -1){
                            byte[] bytes = buffer.array();
                            System.out.println(new String(bytes,0,readlength));
                            buffer.clear();
                            readlength = fileChannel.read(buffer);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread th2 = new Thread(){
                @Override
                public void run() {
                    ByteBuffer buffer = ByteBuffer.allocate(5);
                    try {
                        int readlength = fileChannel.read(buffer);
                        while(readlength != -1){
                            byte[] bytes = buffer.array();
                            System.out.println(new String(bytes,0,readlength));
                            buffer.clear();
                            readlength = fileChannel.read(buffer);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            th1.start();
            th2.start();
        }

    }

    private static void TestReadPOsition(FileChannel fileChannel) throws IOException{
        fileChannel.position(2);

        ByteBuffer buffer = ByteBuffer.allocate(5);
        fileChannel.read(buffer);

        byte[] getBytearray = buffer.array();
        for(byte b:getBytearray){
            System.out.print(b + "\t");
        }
    }

    private static void TestBackValue() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(5);

        int readLength = fileChannel.read(buffer);
        System.out.println("1rt"+readLength);

        readLength = fileChannel.read(buffer);
        System.out.println("2end:"+readLength);

        buffer.clear();
        readLength = fileChannel.read(buffer);
        System.out.println("after clear read:"+ readLength);
        buffer.clear();
    }
}
