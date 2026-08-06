class Solution {
    public int longestStrChain(String[] word) {
        int n=word.length;
        int maxLength=0;
        int []dp= new int[n];
        Arrays.sort( word,(a,b)->a.length()-b.length() );

        for(int i=0; i<n ; i++){
            int max=0;
            String s1=word[i];
            for(int j=0; j<i ; j++){
                if(j==i) continue;
                
                String s2=word[j]; // should be one length smaller
        
                if(s2.length()==s1.length()-1){
                    int a=0; // for s2
                    int b=0;// for s1
                    while(b<s1.length() && a<s2.length()){
                        if(s1.charAt(b)==s2.charAt(a)){
                            a++;
                            b++;
                        }
                        else{
                            b++;
                        }
                    }
                    if(a==s2.length()){
                        max=Math.max(max,dp[j]);
                    }
                }
            }
            dp[i]=max+1;
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}