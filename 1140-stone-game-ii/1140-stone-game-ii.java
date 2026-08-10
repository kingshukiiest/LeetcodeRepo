class Solution {
    int [] suffix;
    int [][] dp;
    public int solve(int idx, int m, int []piles){
        int n=piles.length;
        if(idx>=n) return 0;
        if(dp[idx][m]!=-1) return dp[idx][m];
        int maxPile=0;
        for(int i=idx; i<n && i<idx+2*m; i++){
            int newM=Math.max(m,i-idx+1);
            int bob_pile= solve(i+1,newM,piles);
            int alice_pile=suffix[idx]-bob_pile;
            maxPile=Math.max(maxPile,alice_pile);
        }
        return dp[idx][m]=maxPile;
    }
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        dp= new int[n][n+1];
        for(int []a :dp){
            Arrays.fill(a,-1);
        }
        suffix=new int [n];
        suffix[n-1]=piles[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i]=suffix[i+1]+piles[i];
        }
        return solve(0,1,piles);
    }
}