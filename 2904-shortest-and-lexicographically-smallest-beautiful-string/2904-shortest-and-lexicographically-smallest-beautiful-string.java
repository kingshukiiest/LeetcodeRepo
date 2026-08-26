class Solution {
    public String lexoSmall(String a , String b){
        if(a=="") return b;
        return (a.compareTo(b) < 0)? a : b;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int i=0;
        int j=0;
        int n=s.length();
        int one=0;
        int bestLen=Integer.MAX_VALUE;
        String ans="";
        while(j<n){
            char ch =s.charAt(j);
            if(ch=='1') one++;

            while(one==k){
                int len=j-i+1;
                if(bestLen > len){
                    bestLen=len;
                    ans=s.substring(i,j+1);
                }
                else if(bestLen==len){
                    ans=lexoSmall(ans,s.substring(i,j+1));
                }

                char left=s.charAt(i);
                if(left=='1') one--;
                i++;
            }
            j++;
        }
        return ans;
    }
}