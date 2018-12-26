package com.company.NIO.Socket;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/22 上午11:52
 */

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class BroadcastTest {
    public static void main(String[] args){
        try {
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            while(enumeration.hasMoreElements()){
                NetworkInterface networkInterface = enumeration.nextElement();
                System.out.println(networkInterface.getName() + "  "+ networkInterface.getDisplayName());
                List<InterfaceAddress> list = networkInterface.getInterfaceAddresses();
                for(int i=0;i<list.size();i++){
                    InterfaceAddress a = list.get(i);
                    InetAddress ip = a.getBroadcast();
                    if(ip != null){
                        System.out.println("  " + a.getBroadcast().getHostAddress() );
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
