package com.company.Offer.String;/*
 * @description
 * 替换字符串中的空格
 * 实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如：输入"We are happy",则输出"We20%are20%happy"
 * @author : wenhao
 * @create : 2018/12/8 下午10:06
 * attention:如果从前往后合并数组需要重复移动多次数字，则考虑从后往前进行复制，可减少移动次数
 */

public class $5ReplaceSpace {
    public static void replaceSpace(char[] str,int length){
        if(str == null || length <0){
            return;
        }
        int stroflength = 0;
        int numofblank = 0;
        int i=0;
        while(str[i] != '\0'){
            if(str[i++] == ' '){
                numofblank++;
            }
            stroflength++;
        }
        int newoflength = stroflength + 2*numofblank;
        if(newoflength > length){
            return;
        }

        int indexoforigin = stroflength;
        int indexofnew = newoflength;
        while(indexoforigin>=0 && indexofnew>indexoforigin){
            if(str[indexoforigin] == ' '){
                str[indexofnew--]='0';
                str[indexofnew--]='2';
                str[indexofnew--]='%';
                indexoforigin--;
            }else{
                str[indexofnew--]=str[indexoforigin--];
            }
        }
        System.out.println(String.valueOf(str));
    }
    public static void main(String[] args){
        String strs = "We are happy.";
        char[] chs = new char[20];
        char[] chars = strs.toCharArray();
        int i=0;
        for(char ch:chars){
            chs[i++]=ch;
        }
        replaceSpace(chs,chs.length);
    }
}
