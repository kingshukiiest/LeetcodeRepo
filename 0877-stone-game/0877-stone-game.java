class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] nums) {
        int n= nums.length;
        dp= new Integer[n][n];
        return helper2(0,n-1, nums)>=0;
    }
    public int helper2(int i, int j , int []nums){
        if(i==j) return nums[i];
        if(dp[i][j]!=null) {
            return dp[i][j];
        } 

        int choice1= nums[i]- helper2(i+1, j , nums);
        int choice2= nums[j]- helper2(i, j-1, nums);

        return dp[i][j]=Math.max(choice1, choice2);
    }
}