class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length(); //j
        int n=p.length(); //i
        // i for p , moving down
        // j for s , moving right 
        // in my table

        boolean [][]dp= new boolean [n+1][m+1];
        dp[0][0]=true;
        // pattern is empty, s is not empty, so false;
        for(int j=1; j<=m; j++){
            dp[0][j]=false; // 0 means pattern is empty, length 0
        }
        // string is empty, pattern has some thing
        for(int i=1; i<=n; i++){
            if(p.charAt(i-1)=='*'){
                dp[i][0]=dp[i-1][0];
            }
            else dp[i][0]=false; // it is already false;
        }

        for(int i=1; i<=n ; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(j-1)==p.charAt(i-1) || p.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(i-1)=='*'){
                    dp[i][j]=dp[i-1][j]| dp[i][j-1];
                }
                else dp[i][j]=false;
            }
        }
        return dp[n][m];
    }
}