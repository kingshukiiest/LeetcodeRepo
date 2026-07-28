class Solution {
    int [][] dp;
    public int helper(List<Integer> list, int i, int n){
        if(n==0){
            return 0;
        }
        if(i==list.size()){
            return Integer.MAX_VALUE;
        }

        if(dp[i][n]!=-1) return dp[i][n];

        int skip=helper(list, i+1, n);

        if(list.get(i) > n ) return dp[i][n]=skip;
        int pick=  helper(list, i, n-list.get(i));

        if(pick!=Integer.MAX_VALUE){
            pick=1+pick;
        }

        return dp[i][n]=Math.min(skip, pick);
    }
    public int numSquares(int n) {
        List<Integer> list= new ArrayList<>();
        for( int i=1; i*i<=n; i++){
            list.add(i*i);
        }
        dp= new int [list.size()][n+1];
        for( int [] r : dp){
            Arrays.fill(r, -1);
        }

        return helper(list,0, n);
    }
}