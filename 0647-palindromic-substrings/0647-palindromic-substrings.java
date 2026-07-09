class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int [][] dp = new int[n][n];
        
        int ans=0;

        for(int count=1; count<=n ; count++){
            int i=0;
            int j= count-1;

            while(j<n){
                if(i==j) {
                    dp[i][j]=1;
                    ans++;
                }
                else if(s.charAt(i)==s.charAt(j)){

                    if(i+1==j || dp[i+1][j-1]!=0){
                        dp[i][j]=2+ dp[i+1][j-1];
                        ans++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}