package com.company.Offer.Array;/*
 * @description
 * 在二维数组中查找数字
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序，输入一个此类型数组和一个整数，
 * 判断数组中是否含有该整数
 * @author : wenhao
 * @create : 2018/12/8 下午9:42
 */

public class $3FindEleFromMatrix {
    public static boolean find(int[][] matrix,int num,int cols,int rows){
        boolean find = false;

        if(matrix != null && cols > 0 && rows >0){
            int row =0;
            int col = cols -1;
            while(row<rows && col >=0){
                if(matrix[row][col] == num){
                    find = true;
                    break;
                }else if(matrix[row][col] > num){
                    --col;
                }else{
                    ++row;
                }
            }
        }
        return find;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(matrix,0,4,4));
    }
}
