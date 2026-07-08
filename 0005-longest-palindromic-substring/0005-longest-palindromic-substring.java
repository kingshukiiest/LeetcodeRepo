class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int [][] dp = new int[n][n];
        int count=n;
        int maxLen=0;

        while(count >0 ){
            int i=0;
            int j= n-count;

            while(j<n){
                if(i==j) dp[i][j]=1;
                else if(s.charAt(i)==s.charAt(j)){

                    if(i+1==j || dp[i+1][j-1]!=0){
                        dp[i][j]=2+ dp[i+1][j-1];
                    }
                }

                maxLen=Math.max(maxLen, dp[i][j]);
                i++;
                j++;
            }
            
            count--;
        }

        count=n;
    
        while(count >0 ){
            int i=0;
            int j= n-count;

            while(j<n){
                if(dp[i][j]==maxLen){
                    return s.substring(i, j+1);
                }
                i++;
                j++;
            }
            
            count--;
        }

        return "";
    }
}