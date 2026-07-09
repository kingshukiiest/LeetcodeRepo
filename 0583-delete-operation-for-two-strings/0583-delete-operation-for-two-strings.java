class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        // tabulation m1+1, m2+1 walah
        int m1=s1.length();
        int m2=s2.length();
        int[][] dp= new int[m1+1][m2+1];
        for(int i=0; i<m1+1; i++){
            for(int j=0; j<m2+1; j++){
                if(i==0 || j==0) dp[i][j]=0;
                else{
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    else{
                        dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }
        }
        return dp[m1][m2];
    }

    public int minDistance(String s1, String s2) {
        int len=longestCommonSubsequence(s1,s2);
        return (s1.length()-len) + (s2.length()-len);
    }
}