package com.company.Offer.Array;/*
 * @description
 * 数组中重复的数字
 * 在一个长度为n的数组里所有的数字都在0～n-1范围内。数组内某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次，请找出数组中任意一个重复的数字。
 * 例如：如果输入长度为7的数组{2,3,4,3,4,2,5},那么对应输出的重复数字就是2或者3，或者4
 * @author : wenhao
 * @create : 2018/12/8 下午8:53
 */

import java.util.HashMap;
import java.util.Map;

public class $2RepeatNumberofArray {
    private static boolean repeatFlag = false;
    public static int getAnyReNumber(int[] nums){

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
                repeatFlag = true;
                return num;
            }else{
                map.put(num,1);
            }
        }
        return 0;
    }
    /*
    * @description:
    * 空间复杂度：O(n)
     * 时间复杂度：O(1)
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public static int getAnyReNumByArray(int[] nums){
        int[] arrays = new int[nums.length];
        for(int num:nums){
            arrays[num]+=1;
        }
        for(int index=0;index<arrays.length;index++){
            if(arrays[index]>1){
                repeatFlag = true;
                return index;
            }
        }
        return 0;
    }
    /*
    * @description:
    * 空间复杂度：O(1)
    * 时间复杂度：O(n)
    * @author: ${USER}
    * @create: ${DATE} ${TIME}
    */
    public static int getAnyReNumBetter(int[] nums){
        for(int i=0;i<nums.length;i++){
            while(nums[i] != i){
                if(nums[nums[i]] != nums[i]){
                    swap(nums,i,nums[i]);
                }else{
                    repeatFlag = true;
                    return nums[i];
                }

            }
        }
        return 0;
    }
    private static void swap(int[] nums,int num1,int num2){
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }

    public static void main(String[] args){
        int[] test = {1,2,1,3,4,5,6,8,5,9};
        System.out.println("1.map:"+getAnyReNumber(test));
        System.out.println("2.array:"+getAnyReNumByArray(test));
        System.out.println("3.better:"+getAnyReNumBetter(test));
    }
}
