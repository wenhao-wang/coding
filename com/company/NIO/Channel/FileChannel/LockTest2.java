package com.company.NIO.Channel.FileChannel;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/15 下午4:24
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockTest2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile file2 = new RandomAccessFile("/Users/wenhao/NIO/b.text", "rw");
        FileChannel fileChannel = file2.getChannel();

        System.out.println("B begin");
        FileLock fileLock = fileChannel.tryLock(0, 5, true);
        System.out.println("B can not get a Lock:"+fileLock );
        file2.close();
        fileChannel.close();
    }
}
