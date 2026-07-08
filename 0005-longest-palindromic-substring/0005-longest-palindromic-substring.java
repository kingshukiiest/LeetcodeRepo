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
        System.out.print(maxLen+" ");
        int x=0; int y=0;
        boolean flag=false;
        for( int i=0; i<n ;i++){
            for( int j=0; j<n ; j++){
                if(dp[i][j]==maxLen){
                    x=i;
                    y=j;
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }

        return s.substring(x,y+1);
    }
}