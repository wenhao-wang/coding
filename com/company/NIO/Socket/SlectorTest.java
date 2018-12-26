package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/26 下午9:21
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class SlectorTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress("localhost",8888));

        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        System.out.println("SelectionKey = "+selectionKey);

        System.out.println("selector:"+selector);
        System.out.println("hasRegister="+serverSocketChannel.isRegistered());

        serverSocket.close();
        serverSocketChannel.close();
    }
}
