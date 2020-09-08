package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class leetcode {
    public static void main(String[] args) {
        leetcode l1 = new leetcode();
        String sds = "cxczc";
        System.out.println((double) 5/2);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("bb");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> map = new  HashMap<>();
        int[] dp = new int[s.length()];
        int max = 1;
        for(int i = 0; i < s.length(); i++){
            dp[i] = 1;
        }
        int i = 0;
        map.put(s.charAt(0), 0);
        for(int j = 1; j < s.length(); j++){
            char key = s.charAt(j);
            Integer index = map.get(key);
            if(index != null){
                if (index + 1 > i) i = index + 1;
                map.remove(key);
            }
            map.put(key, j);
            dp[j] = j - i + 1;
            System.out.println(dp[j]);
            if(dp[j] > max) max = dp[j];
        }
        return max;
    }

    int contains(char key, int start, int end, String s){
        for(int i = start; i <= end; i++){
            if(key == s.charAt(i)) return i + 1;
        }
        return start;
    }

}

