package com.company.NIO.NetworkInterface;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/15 下午9:42
 */

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import sun.nio.ch.Net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class BaseInfoTest {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();

            while (networkInterface.hasMoreElements()) {
                NetworkInterface eachNetworkInterface = networkInterface.nextElement();
                System.out
                        .println("getName()获得网络设备名称：" + eachNetworkInterface.getName());
                System.out.println("getDisplayName获得设备显示名称=" + eachNetworkInterface.getDisplayName());

                System.out.println("getIndex获得网络接口的索引=" + eachNetworkInterface.getIndex());

                System.out.println("isUp是否已经开启并运行=" + eachNetworkInterface.isUp());

                System.out.println("isLoopback是否为回调接口=" + eachNetworkInterface.isLoopback());


                System.out.println("MTU获得最大传输单元=" + eachNetworkInterface.getMTU());

                System.out.println("isVirtual是否虚拟接口=" + eachNetworkInterface.isVirtual());

                System.out.println("getParent获得父接口：" + eachNetworkInterface.getParent());
                System.out.println();
                System.out.println("getSubInterface获得子接口信息：");
                Enumeration<NetworkInterface> networkInterfaceSub = eachNetworkInterface.getSubInterfaces();
                while (networkInterfaceSub.hasMoreElements()) {
                    NetworkInterface eachSubInterface = networkInterfaceSub.nextElement();
                    System.out
                            .println("getName()获得网络设备名称：" + eachSubInterface.getName());
                    System.out.println("getDisplayName获得设备显示名称=" + eachSubInterface.getDisplayName());
                    System.out.println("isVirtual是否虚拟接口=" + eachSubInterface.isVirtual());
                    System.out.println("getParent获得父接口的hashCode=" + eachSubInterface.getParent().hashCode());
                }
                System.out.println();
                System.out.println("getHardwareAdress获得网卡的物理地址");
                byte[] byteArray = eachNetworkInterface.getHardwareAddress();
                if(byteArray != null && byteArray.length!= 0){
                    for(byte b:byteArray){
                        System.out.print(b+" ");
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
                Enumeration<InetAddress> enumInetAdress = eachNetworkInterface.getInetAddresses();
                while (enumInetAdress.hasMoreElements()){
                    InetAddress inetAdress = enumInetAdress.nextElement();
                    System.out.println("getCanonicalHostName获取此IP地址的完全限定域名="
                            +inetAdress.getCanonicalHostName());
                    System.out.println("getHostName获取此ip的主机名="+
                    inetAdress.getHostName());
                    System.out.println("getHostAdress返回IP地址字符串="+inetAdress.getHostAddress());

                    System.out.println("getAddress返回此InetAdress对象的原始IP地址=");
                    byte[] addressByte = inetAdress.getAddress();
                    for(byte b:addressByte){
                        System.out.print(b+" ");
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println("supportsMulticast 是否支持多地址广播="+
                eachNetworkInterface.supportsMulticast());

                System.out.println("---------------------");


            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
