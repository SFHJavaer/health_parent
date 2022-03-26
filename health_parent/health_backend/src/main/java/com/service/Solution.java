package com.service;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @return int整型
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,3,1};
        System.out.println(solution.reorder(arr,3));
    }
    public int reorder (int[] prices,int pricesLen) {
        // write code here
        int flag = 0;
        if(pricesLen%2==0){
            flag=-1 ;}
        if(prices[pricesLen/2]==prices[pricesLen/2-1]){
            for(int i=pricesLen/2+1;i<pricesLen;i++){
                if(prices[pricesLen/2]==prices[i])
                    flag --;
            }}
        return pricesLen / 2 + (flag) ;
    }
}