class Solution {
    int []dp;
    // public int solve(int []stones, int i, int []preSum){
    //     int n=stones.length;
    //     if(i==n) return 0;

    //     if(dp[i]!=Integer.MAX_VALUE){
    //         return dp[i];
    //     }

    //     int t=i+1;
    //     int bestDiff=Integer.MIN_VALUE;
    //     while(t<n){
    //         int scoreDiff=preSum[t]-solve(stones, t, preSum);
    //         bestDiff=Math.max(bestDiff, scoreDiff);
    //         t++;
    //     }
    //     return dp[i]=bestDiff;

    // }
    public int stoneGameVIII(int[] stones) {
    
        int n=stones.length;
        int []preSum= new int [n];
        dp= new int [n];
        // Arrays.fill(dp,Integer.MAX_VALUE);

        preSum[0]=stones[0];
        for(int i=1; i<n; i++){
            preSum[i]=preSum[i-1]+stones[i];
        }

        // return solve(stones, 0, preSum);

        dp[n-1]=preSum[n-1];
        for(int i=n-2;i>=0; i--){
            dp[i]=Math.max(dp[i+1], preSum[i]-dp[i+1]);
        }
        return dp[1];
    }
}