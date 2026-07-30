class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int count=0;
        int x=1;
        while(n!=0){
            int dig= Math.min(8,n);
            count+=(dig*x);
            x++;
            n= n-dig;
        }
        return count;
    }
}