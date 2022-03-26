package com.service;

import java.util.*;


public class Inc {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param prices int整型一维数组 购物车中的商品价格列表
         * @return int整型
         */
        public int reorder (int[] prices) {
                // write code here
                int i = 0;
                ArrayList<Integer> array = new ArrayList();
                for(i = 1;i<prices.length-1;i++){
                        if(prices[i-1] > prices[i]&& prices[i]<prices[i+1]){
                                return prices[i];

                        }
                }
                return prices[i];
        }
}