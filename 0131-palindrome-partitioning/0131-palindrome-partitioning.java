class Solution {
    Boolean [][] dp;
    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void solve(String s, int i,List<List<String>> list,List<String> l){
        int n=s.length();
        if(i==n){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int end=i;end<n; end++){
            String curr=s.substring(i,end+1);
            boolean flag=false;
            if(dp[i][end]!=null) {
                flag=dp[i][end];
            }
            else{
                flag=isPalindrome(curr);
                dp[i][end]=flag;
            }
            if(flag){
                l.add(curr);
                solve(s,end+1,list,l);
                l.remove(l.size()-1);
            }
           
        }
    }
    public List<List<String>> partition(String s) {
        int n=s.length();
        dp= new Boolean [n][n];
        List<List<String>> list= new ArrayList<>();
        solve(s,0,list,new ArrayList<>());

        return list;
    }
}