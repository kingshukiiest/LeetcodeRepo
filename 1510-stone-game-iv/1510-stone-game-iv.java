class Solution {
    Boolean [][] dp;
    public boolean solve(int turn, int n){
        if(n<1) return false;

        if(dp[turn][n]!=null) return dp[turn][n];
        if(turn==1){
            for(int i=1; i*i<=n; i++){

                if(!solve(turn^1,n- (i*i))) return dp[turn][n]=true;
            }
            return dp[turn][n]=false;
        }
        else{
            for(int i=1; i*i<=n; i++){
                
                if(!solve(turn^1, n- (i*i))) return dp[turn][n]=true;
            }
            return dp[turn][n]=false;
        }
    }
    public boolean winnerSquareGame(int n) {
        dp = new Boolean [2][n+1];
        return solve(1,n);
    }
}