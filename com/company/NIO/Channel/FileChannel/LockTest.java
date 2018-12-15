package com.company.NIO.Channel.FileChannel;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/15 下午4:20
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile file1 = new RandomAccessFile("/Users/wenhao/NIO/b.text", "rw");
        FileChannel fileChannel = file1.getChannel();

        System.out.println("A begin");
        FileLock fileLock = fileChannel.tryLock(0, 5, true);
        System.out.println("A get a Lock:" + fileLock);
        Thread.sleep(Integer.MAX_VALUE);

    }
}
