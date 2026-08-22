class Solution {
    int [][]dp;
    // public int helper(String s , String t, int i, int j){
    //     if(j==t.length()) return 1;

    //     if(i==s.length()) return 0;

    //     if(dp[i][j]!=-1) return dp[i][j];
    //     // if the char are equal you can pick only
    //     // or you can skip, irrespective of the charater

    //     int skip=helper(s,t,i+1, j);

    //     int pick=0;
    //     if(s.charAt(i)==t.charAt(j)){
    //         pick=helper(s,t,i+1,j+1);
    //     }
    //     return dp[i][j]=pick+skip;
    // }
    public int numDistinct(String s, String t) {
        int m =s.length();
        int n =t.length();
        dp= new int[m+1][n+1];
        // dp= new int[m][n];

        // for(int [] a : dp){
        //     Arrays.fill(a,-1);
        // }
        // return helper(s, t, 0,0);

        dp[0][0]=1;
        for(int i=1; i<=m; i++){
            dp[i][0]=1;
        }
        
        for(int i=1; i<=m ; i++){
            for(int j=1; j<=n; j++){
                // skip
                dp[i][j]=dp[i-1][j];

                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]+=dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}