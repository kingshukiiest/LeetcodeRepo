class Solution {
    public int strStr(String h, String n) {
        int m=h.length();
        int t=n.length();
        
        for(int i=0; i<=m-t; i++){
            
            if(h.charAt(i)==n.charAt(0)){
                int j=0;
                int start=i;
                while(j<t && h.charAt(start)==n.charAt(j)){
                    start++;
                    j++;
                }
                if(j==t) return i;
            }
        }
    
        return -1;
    }
}