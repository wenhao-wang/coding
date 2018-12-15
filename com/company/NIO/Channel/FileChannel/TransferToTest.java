package com.company.NIO.Channel.FileChannel;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/15 下午3:33
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class TransferToTest {
    public static void main(String[] srgs) throws IOException{
        RandomAccessFile filea = new RandomAccessFile("/Users/wenhao/NIO/a.text", "rw");

        RandomAccessFile fileb = new RandomAccessFile("/Users/wenhao/NIO/b.text","rw");

        FileChannel fileChannel1 = filea.getChannel();
        FileChannel fileChannel2 = fileb.getChannel();

        fileChannel2.position(4);
//        fileChannel1.transferTo(2,4,fileChannel2);
fileChannel1.transferFrom(fileChannel2,3,4);

        fileChannel1.close();
        fileChannel2.close();
        filea.close();
        fileb.close();

    }
}
