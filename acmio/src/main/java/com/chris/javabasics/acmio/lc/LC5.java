package com.chris.javabasics.acmio.lc;

public class LC5 {
    public String longestPalindrome(String s) {
        String res = "";

        int n = s.length();
        for(int i = 0; i < n; ++i) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String palindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
