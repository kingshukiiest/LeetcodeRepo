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

        dp= new int[m][n];
        for(int [] a : dp){
            Arrays.fill(a,-1);
        }

        return solve(s,t,m-1,n-1);
    }
}