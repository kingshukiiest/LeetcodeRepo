class Solution {
    boolean [][]dp;
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
        }
        if((sum&1)==1) return  false;

        int half=sum/2;

        dp=new boolean[n+1][half+1];
        for(int i=0; i<=n; i++){
            dp[i][0]=true;
        }

        for(int i=n-1; i>=0; i--){
            for(sum=1; sum<=half; sum++){
                dp[i][sum]=dp[i+1][sum]; //skip

                //pick
                if(sum>=nums[i]){
                    dp[i][sum]= dp[i][sum] ||
                                dp[i+1][sum-nums[i]];
                }

            }
        }

        // return solve(nums, 0, half);
        return dp[0][half];
    }
}