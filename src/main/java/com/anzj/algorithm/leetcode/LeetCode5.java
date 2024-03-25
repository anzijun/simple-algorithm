package com.anzj.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author anzj
 * @Date 2024/3/25
 */
public class LeetCode5 {

    public String longestPalindrome(String s) {
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        return "";
    }


}
