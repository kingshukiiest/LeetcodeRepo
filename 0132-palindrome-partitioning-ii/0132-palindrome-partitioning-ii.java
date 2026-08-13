class Solution {
    boolean [][]dp;
    int [] minDp;
    public int solve(String s, int i){
        int n=s.length();
        if(minDp[i]!=-1){
            return minDp[i];
        }
        if(dp[i][n-1]==true) return 0;

        int min=Integer.MAX_VALUE;
        for(int end=i; end < n ; end++){
            String curr=s.substring(i,end+1);
            if(dp[i][end]==true){
                min=Math.min(min, 1+ solve(s,end+1));
            }
        }
        return minDp[i]=min;
    }
    public int minCut(String s) {
        int n=s.length();
        minDp= new int[n];
        Arrays.fill(minDp,-1);

        dp= new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=i;j<n; j++){
                if(s.charAt(i)==s.charAt(j) &&
                    (j-i<=2 || dp[i+1][j-1]==true)){
                        dp[i][j]=true;
                    }
            }
        }
        return solve(s,0);
        
    }
}