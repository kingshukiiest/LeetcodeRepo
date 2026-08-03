class Solution {
    Integer[] dp;
    public String stoneGameIII(int[] nums) {
        int n= nums.length;
        dp= new Integer[n];
        int res= helper(0, nums);
        if(res==0) return "Tie";
        return (res>0)? "Alice" : "Bob";
    }
   
    public int helper(int i, int []nums){
        int n= nums.length;
        if(i==n) return 0;
        
        if(dp[i]!=null){
            return dp[i];
        }
        
        int choice1= nums[i]- helper(i+1, nums);
        if(i==n-1) return dp[i]=choice1;

        int choice2= nums[i]+nums[i+1]- helper(i+2,nums);
        if(i+1 == n-1) return dp[i]=Math.max(choice1, choice2);

        int choice3= nums[i]+nums[i+1]+nums[i+2]- helper(i+3,nums);
        return dp[i]=Math.max(choice1, Math.max(choice2,choice3));
    }
}