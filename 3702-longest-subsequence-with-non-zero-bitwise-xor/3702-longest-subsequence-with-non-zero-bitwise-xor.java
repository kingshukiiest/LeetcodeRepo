class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int xor=0;
        int zero=0;
        for(int elem : nums){
            xor= xor^elem;
            if(elem==0) zero++;
        }
        if(xor!=0){
            return n;
        }
        else{
            if(zero==n) return 0;
            return n-1;
        }
    }
}