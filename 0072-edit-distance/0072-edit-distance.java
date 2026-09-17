class Solution {
    int [][] dp;
    // public int helper(String word1, String word2, int i , int j){
    //     if(i<0 && j<0){
    //         return 0;
    //     }
    //     if(j<0){
    //         return i+1;
    //     }
    //     if(i<0){
    //         return j+1;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
        
    //     if(word1.charAt(i)==word2.charAt(j)){
    //         return dp[i][j]=helper(word1, word2, i-1, j-1);
    //     }
        
    //     int insert=1+helper(word1,word2,i, j-1);
    //     int delete=1+helper(word1, word2, i-1, j);
    //     int replace=1+helper(word1, word2, i-1, j-1);

    //     return dp[i][j]=Math.min(insert,Math.min(delete, replace));

    // }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        dp= new int [m+1][n+1];

        // i for word1, j for word2
        // m for word1, n for word2
        for(int j=0; j<=n; j++){
            dp[0][j]=j;
        }
        for(int i=0; i<=m ; i++){
            dp[i][0]=i;
        }

        for(int i=1;i<=m ; i++){
            for(int j=1;j<=n; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int replace=dp[i-1][j-1];

                    int delete=dp[i-1][j];
                    int insert= dp[i][j-1];

                    dp[i][j]=1+ Math.min(insert,Math.min(delete, replace));
                }
            }
        }
        for(int i=0;i<=m ; i++){
            for(int j=0;j<=n; j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }

        return dp[m][n];
        // return helper(word1, word2, m-1, n-1);
    }
}