class Solution {
    Boolean [][]dp;
    public boolean solve(int[] nums, int i, int sum){
        // i am trying pick and skip to achieve the exact sum
        // if i achieve the exact sum, i will return true, or retunr false;
        int n=nums.length;
        if(sum==0) return true;

        if(i==n) return false;

        if(dp[i][sum]!=null) return dp[i][sum];
        

        boolean skip= solve(nums, i+1, sum);
        if(nums[i]>sum) return dp[i][sum]=skip;

        boolean pick= solve(nums, i+1, sum-nums[i]);

        return dp[i][sum]=(pick | skip);
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        
        
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
        }
        if((sum&1)==1) return  false;

        int half=sum/2;

        dp= new Boolean[n][half+1];
        return solve(nums, 0, half);
    }
}