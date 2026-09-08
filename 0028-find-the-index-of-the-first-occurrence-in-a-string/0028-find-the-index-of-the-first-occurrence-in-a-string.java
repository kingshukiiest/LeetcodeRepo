class Solution {
    public int strStr(String h, String n) {
        int m=h.length();
        int t=n.length();
        
        int i=0;
        int j=0;
        while(i<=m-t){
            while(i<=m-t && h.charAt(i)!=n.charAt(0)){
                i++;
            }

            if(i<=m-t){
                int start=i;
                while(i<m && j<t){
                    if(h.charAt(i)==n.charAt(j)){
                        i++;
                        j++;
                    }
                    else break;
                }
                if(j==t) return start;
                i=start+1;
                j=0;
            }
        }
    
        return -1;
    }
}