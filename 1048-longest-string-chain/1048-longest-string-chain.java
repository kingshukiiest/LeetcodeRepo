class Solution {
    public boolean isPredecessor(String curr, String prev){

        if(prev.length()+1==curr.length()){
            int i=0; // curr
            int j=0; // prev
            while(i<curr.length() && j<prev.length()){
                if(curr.charAt(i)==prev.charAt(j)){
                    j++;
                    i++;
                }
                else{
                    i++;
                }
            }
            return(j==prev.length());
        }
        return false;
    }
    public int longestStrChain(String[] word) {
        int n=word.length;
        int maxLength=0;
        int []dp= new int[n];
        Arrays.sort( word,(a,b)->a.length()-b.length() );

        for(int i=0; i<n ; i++){
            int max=0;
            String curr=word[i];
            for(int j=0; j<i ; j++){
                if(j==i) continue;
                
                String prev=word[j]; // should be one length smaller

                if(isPredecessor(curr,prev)){
                    max=Math.max(max,dp[j]);
                }
            }
            dp[i]=max+1;
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}