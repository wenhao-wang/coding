package com.company.NIO.Socket;/*
 * @description
 * 测试getHostName()和getHostString()的区别
 * @author : wenhao
 * @create : 2018/12/20 下午7:27
 */

import java.net.InetSocketAddress;

public class Test20 {
    public static void main(String[] args){
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.43.134",8080);
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("192.168.43.134",8080);


        System.out.println("getHostString(): "+inetSocketAddress1.getHostString());
        System.out.println("getHostName(): "+inetSocketAddress.getHostName());
    }

}
