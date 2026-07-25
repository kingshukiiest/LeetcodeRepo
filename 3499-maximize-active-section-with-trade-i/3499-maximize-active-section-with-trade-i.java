class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        int count1=0;
        for(char ch : s.toCharArray()){
            if(ch=='1') count1++;
        }
        
        if(n<=2) return count1;
        
        int prev=-1;
        int curr=-1;
        int bestGain=0;
        int i=0;
        int j=0;

        while(i<s.length() && j<s.length()){
            while(i<s.length() && s.charAt(i)!='0'){
                i++;
                j++;
            }
            if(i==s.length()) break;
            
            while(j<s.length() && s.charAt(j)=='0'){
                j++;
            }
            curr=(j-i);

            if(prev!=-1){
                bestGain= Math.max(bestGain, prev+curr);
                prev=curr;
            }
            else{
                prev=curr;
            }

            i=j;
        }
        return bestGain + count1;
        
    }
}