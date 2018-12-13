package com.company.Offer.Algorithom;/*
 * @description
 * 快速排序算法中Partition函数的思想，在一些场景中可以引用到其他一些查找中，且具有很好效率时间复杂度
 * @author : wenhao
 * @create : 2018/12/14 上午12:00
 */

import java.util.Arrays;

public class $39Partition {
    /*
    * @description:
    * 查找数组中出现次数超过一半的数字
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public int moreThanHalfNum(int[] num){
        int len = num.length;

        int middle = len >>2;
        int end = len-1;
        int start =0;
        int patition = getPartition(num,start,end);
        while (patition!= middle){
            if(patition>middle){
                end = patition-1;
                patition = getPartition(num,start,end);
            }else {
                start = patition+1;
                patition = getPartition(num,start,end);
            }
        }
        return num[patition];
    }

    private int getPartition(int[] num, int start, int end) {
        int base = start;
        int index = start+1;
        for (int i = index;i<=end;i++){
            if(num[i]<num[base]){
                swap(num,i,index++);
            }
        }
        swap(num,base,index-1);
        return index-1;
    }

    private void swap(int[] num, int i, int i1) {
        int temp = num[i];
        num[i] = num[i1];
        num[i1] = temp;
    }
    /*
    * @description:
    * 根据partition函数去的数组中最小的k个数
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public int[] getLeastNNumbers(int[] nums,int k){
        int len = nums.length;
        int start = 0;
        int end = len-1;
        int partition = getPartition(nums,start,end);
        while(partition != k-1){
            if(partition<k-1){
                start = partition+1;
                partition = getPartition(nums,start,end);
            }else{
                end = partition-1;
                partition = getPartition(nums,start,end);
            }
        }
        int[] res = Arrays.copyOfRange(nums,0,k-1);
        return res;
    }

}
