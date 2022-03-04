package com.lixiang.utils;

import java.util.Random;
import java.util.Stack;

    /**
     * @author guoqiang3@lixiang.com
     * @version 1.0
     * @date 2022/3/1 9:15
     */
    public class CodeUtils {

        private static final char[] BASE_ARRAY = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        private static final String BASE_CODE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String CODE_34 = "123456789abcdefghijklmnpqrstuvwxyz";
        public static final String CODE_58 = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";


        // 其他进制转为10进制，按权展开
        public static long nTo10(String number, int n) {
            char[] ch = number.toCharArray();
            int len = ch.length;
            long result = 0;
            if (n == 10) {
                return Long.parseLong(number);
            }

            long base = 1;
            //1*2^0 就是当前二进制字符串的倒序数字*进制数的n方  n为数字倒序的位数 从零开始
            //比如二进制的10111001 转换成十进制就是倒序相乘 1*2^0 + 0*2^1+ 0*2^2+ 1*2^3+ 1*2^4+ 1*2^5 + 0*2^6+ 1*2^7=185
            for (int i = len - 1; i >= 0; i--) {
                int index = BASE_CODE.indexOf(ch[i]);
                result += index * base;
                base *= n;
            }

            return result;
        }

        //10进制转为其他进制，除留取余，逆序排列
        public static String _10toN(long number, int n) {
            long rest = number;
            Stack<Character> stack = new Stack<Character>();
            StringBuilder result = new StringBuilder(0);
            while (rest != 0) {
                stack.add(BASE_ARRAY[new Long((rest % n)).intValue()]);
                rest = rest / n;
            }
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            return result.length() == 0 ? "0" : result.toString();

        }


        //洗牌算法
        public static void shuffle(int[] array) {
            Random random = new Random();
            int length = array.length;
            for (int i = length; i > 0; i--) {
                // 把随机位置交换到当前位置，既然是随机，就应该保证位置可能不变的情况，因此 random.nextInt 取 i
                swap(array, i - 1, random.nextInt(i));
            }
        }

        private static void swap(int[] array, int i, int j) {
            if (i != j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }




}
