package com.company.Offer;/*
 * @description
 * 单例
 * @author : wenhao
 * @create : 2018/12/8 下午8:49
 */

public class $1Singleton {
    private volatile static $1Singleton singleton = null;
    private $1Singleton() {
    }
    public static $1Singleton getSingleton(){
        if(singleton == null){
            synchronized ($1Singleton.class){
                if(singleton == null){
                    singleton = new $1Singleton();
                }
            }
        }

        return singleton;
    }
}
