package com.company.Offer.Algorithom;/*
 * @description
 * 主要分析递归和循环的效率问题，在性能上的区别
 * @author : wenhao
 * @create : 2018/12/13 下午11:15
 */

public class $9fibonacci {
    /*
    * @description:
    * 通过递归实现斐波那契数列，代码简洁，效率相对较低
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public long fibonacci(int n){
        if(n<=0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    /*
    * @description:
    * 通过循环实现斐波那契数列，效率更好一些
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public  long fibonacciBetter(int n){
        int[] base = {0,1};
        if(n<=2){
            return base[n];
        }
        int fibone = 0;
        int fibtwo = 1;
        int fibn =0;
        for(int i=2;i<=n;i++){
            fibn = fibone + fibtwo;
            fibone = fibtwo;
            fibtwo = fibn;
        }

        return fibn;

    }
}
