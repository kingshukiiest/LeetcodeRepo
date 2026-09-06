class Solution {
    public int countRotations(String s, int k) {
        int n=s.length();
        int [] preMatch= new int [n];
        preMatch[0]=0;
        
        for(int i=1; i<n; i++){
            preMatch[i]=(s.charAt(i)==s.charAt(i-1)) ? 
                preMatch[i-1]+1 : preMatch[i-1];
        }

        int count=0;
        for(int i=-1; i<n-1; i++){
            int temp=preMatch[n-1];
            if(i==-1){
                if(temp==k){
                    count++;
                }
                continue;
            }
            if(s.charAt(i)==s.charAt(i+1)) temp--;
            if(s.charAt(n-1)==s.charAt(0)) temp++;

            if(temp==k) count++;
            
        }
        return count;
    }
}