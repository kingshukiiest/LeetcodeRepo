class Solution {
    Boolean [][]dp;

    public boolean helper(String s, String p, int i, int j){
        int m=s.length();
        int n=p.length();

        if(dp[i][j]!=null) return dp[i][j];

        if(i==m && j==n) return dp[i][j]=true;
        if(i==m){
            while(j<n){
                if(p.charAt(j)!='*'){
                    return dp[i][j]=false;
                }
                j++;
            }
            return dp[i][j]=true;
        }
        if(j==n) return dp[i][j]=false;


        if(s.substring(i).equals(p.substring(j))) return dp[i][j]=true;

        if(( s.charAt(i)==p.charAt(j)) 
            || p.charAt(j)=='?'  ){
                    return dp[i][j]=helper(s,p,i+1, j+1);
        }
        else if(s.charAt(i)!=p.charAt(j) && p.charAt(j)!='?' && p.charAt(j)!='*') {
           
            return dp[i][j]=false;
        }
        else if(p.charAt(j)=='*'){
            while(j<n && p.charAt(j)=='*') j++;

            while(i<=m){
                boolean flag=helper(s,p,i,j);
                if(flag==true) return dp[i][j]=true;
                i++;
            }
        
        }
        return false;

    }
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        dp=new Boolean[m+1][n+1];
        return helper(s, p,0, 0);
    }
}