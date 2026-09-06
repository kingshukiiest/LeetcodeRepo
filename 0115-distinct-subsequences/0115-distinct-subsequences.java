class Solution {
    int [][]dp;
    public int solve(String s, String t, int i, int j){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        //skip
        int skip=solve(s,t,i-1,j);
        //pick
        int pick=0;
        if(s.charAt(i)==t.charAt(j)){
            pick=solve(s,t,i-1,j-1);
        }

        return dp[i][j]=skip+pick;
    }
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();

        dp= new int[m+1][n+1];
        for(int i=0; i<m+1;i++){
            dp[i][0]=1;
        }
        for(int j=1; j<n+1;j++){
            dp[0][j]=0;
        }
        for(int i=1; i<=m ; i++){
            for(int j=1; j<=n ; j++){
                dp[i][j]=dp[i-1][j];

                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]+=dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
        
    }
}