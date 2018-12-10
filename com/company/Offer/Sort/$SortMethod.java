package com.company.Offer.Sort;/*
 * @description
 * @author : wenhao
 * @create : 2018/12/10 下午10:26
 */

import java.util.Arrays;

public class $SortMethod {
    /*
    * @description:
    * 冒泡排序
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public void bubbleSort(int[] nums){
        if(nums == null || nums.length<=0){
            return;
        }
        int len = nums.length;

        for(int i=0;i<len-1;i++){
            for(int j=0; j<len-1-i;j++){
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int  temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /*
    * @description:
    * 归并排序；分治思想
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public int[] mergeSort(int[] nums){
        int len = nums.length;
        if(len < 2){
            return nums;
        }
        int middle = len/2;
        int[] prenums = Arrays.copyOfRange(nums,0,middle);
        int[] nextnums = Arrays.copyOfRange(nums,middle,len);
        return merge(mergeSort(prenums),mergeSort(nextnums));
    }
    private int[] merge(int[] nums1,int[] nums2){
        int[] num = new int[nums1.length+nums2.length];
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i =0,j=0,k=0;
        while(i<len1 && j<len2){
            if(nums1[i]<nums2[j]){
                num[k++]=nums1[i++];
            }else{
                num[k++] = nums2[j++];
            }
        }
        while (i<len1){
            num[k++]=nums1[i++];
        }
        while (j<len2){
            num[k++] = nums2[j++];
        }
        return num;
    }
    /*
    * @description:
    * 快速排序
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public void quickSort(int[] nums ,int left,int right){
        if(left<right){
            int partition = getPartition(nums,left,right);
            quickSort(nums,left,partition-1);
            quickSort(nums,partition+1,right);
        }
    }
    /*
    * @description:
    * 快速排序-通过基准值进行一次排序
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    private int getPartition(int[] nums, int left, int right) {
        int base = left;// 设置基准索引值
        int index= left +1;
        for(int i=index;i<right;i++){
            if(nums[i]<base){
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,base,index-1);

        return index-1;
    }
}
