package com.company.NIO.Channel.FileChannel;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/15 下午1:54
 */


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWriteTest1_1 {
    public static void main(String[] args) {
        try {
            FileOutputStream fosref = new FileOutputStream(new File("/Users/wenhao/a.text"));
            FileChannel fileChannel = fosref.getChannel();

//            test1(fileChannel);

            test1_2(fileChannel);

            fileChannel.close();
            fosref.close();
        } catch (IOException e) {
            System.out.println(111111);
            e.printStackTrace();
        }

    }
    public static void test1(FileChannel fileChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
        System.out.println("A filechannel.position()=" + fileChannel.position());
        System.out.println("write() 1返回值: " + fileChannel.write(buffer));
        System.out.println("B Channel.position()= " + fileChannel.position());


        fileChannel.position(2);

        buffer.rewind();
        System.out.println("write() 2 返回值：" + fileChannel.write(buffer));
        System.out.println("C FileChannel position()= " + fileChannel.position());

    }
    public static void test1_2(FileChannel fileChannel) throws IOException {
        ByteBuffer buffer1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("12345".getBytes());
        fileChannel.write(buffer1);
        buffer2.position(1);
        buffer2.limit(3);
        fileChannel.position(2);
        fileChannel.write(buffer2);

    }
}
