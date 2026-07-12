class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        int [] dp = new int[n];
        for(int j=0;j<n ; j++){
            int max=0;

            for(int k=0; k<j ; k++){ // k==j2
                boolean flag= true;
                for(int i=0; i<m ; i++){
                    if(Math.abs(grid[i][j]- grid[i][k]) > limit){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    max=Math.max(max, dp[k]);
                }
            }

            dp[j]= max+1;
            ans=Math.max(dp[j],ans);
        }
        return ans;
    }
}