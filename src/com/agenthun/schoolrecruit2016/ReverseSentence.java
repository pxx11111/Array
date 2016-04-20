package com.agenthun.schoolrecruit2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/4/2.
 * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。写函数public String trans(String s, int n)
 * 首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
 * 比如"Hello World"变形后就变成了"wORLD hELLO"。
 * 输入描述:
 * 给定一个字符串s以及它的长度n(1≤n≤500)
 * 输出描述:
 * 返回变形后的字符串。题目保证给定的字符串均由大小写字母和空格构成。
 * 输入例子:
 * "This is a sample",16
 * 输出例子:"SAMPLE A IS tHIS"
 * 注意空格
 * input:" h i"，4
 * output:"I H "
 * "h i ",4
 * " I H"
 */
public class ReverseSentence {
    public char toUpDown(char x) {
        if (x == ' ') return x;
        else if (x < 'a') return (char) (x + 'a' - 'A');
        else return (char) (x + 'A' - 'a');
    }

    public String trans(String s, int n) {
        // write code here
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            if (x == ' ') chars[i] = x;
            else if (x < 'a') chars[i] = (char) (x + 'a' - 'A');
            else chars[i] = (char) (x + 'A' - 'a');
        }
        String ss = new String(chars);

        String[] words = ss.split(" ");

        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        String res = new String();
        for (String x :
                words) {
            res += (x.equals("") ? " " : x) + " ";
        }

        return res;
    }

    private static String reverseSentence(String str) {
        if (str == null || str.length() == 0) return "";

        String[] words = str.split(" ");
        if (words.length == 0) return str;

        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (i = 0; i < words.length - 1; i++) {
            stringBuffer.append(words[i] + " ");
        }
        stringBuffer.append(words[i]);
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //while (true) {
//        String s = bufferedReader.readLine();
        int n = 4;
        String s = "h i ";
        //System.out.println("ReverseSentence(s) = " + reverseSentence(s));
        System.out.println("=" + new ReverseSentence().trans(s, n));
//        }
    }
}
