package datastructure;

import java.util.ArrayList;


class Solution {
   
    ArrayList<Integer> temp = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }
    
    public void dfs(int cur, int n, int k) {
        if(k > n - cur + 1 + temp.size()) return;
        if(temp.size() == k){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);
    }
    

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println("123".compareTo("13"));
    }
}