class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int [][] dp = new int[n][n];
        
        int maxLen=0;
        int startIdx=0;

        for(int count=1; count<=n ; count++){
            int i=0;
            int j= count-1;

            while(j<n){
                if(i==j) dp[i][j]=1;
                else if(s.charAt(i)==s.charAt(j)){

                    if(i+1==j || dp[i+1][j-1]!=0){
                        dp[i][j]=2+ dp[i+1][j-1];
                    }
                }

                if(dp[i][j] >  maxLen){
                    startIdx= i;
                    maxLen=dp[i][j];
                }
                i++;
                j++;
            }
            
        }
        

        return s.substring(startIdx, startIdx+maxLen);
    }
}