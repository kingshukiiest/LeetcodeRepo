class Solution {
    public int countCollisions(String s) {
        int n=s.length();
        int i=0;
        int j= n-1;
        while(i<n && s.charAt(i)=='L') i++;
        while(j>=0 && s.charAt(j)=='R') j--;
        if(i>=j) return 0;

        int count=0;
        while(i<=j){
            if(s.charAt(i)=='R' || s.charAt(i)=='L'){
                count++;
            }
            i++;
        }
        return count;
    }
}