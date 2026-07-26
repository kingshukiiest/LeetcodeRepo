class Solution {
    public int largestInteger(int n, int s) {
        if(s > 9*n) return -1;

        int ans=0;
        
        for( int i=1; i<=n; i++){
            // if(s>=9){
            //     ans = ans*10 +9;
            //     s-=9;
            // }
            // else{
            //     ans= ans*10+ s;
            //     s-=s;
            // }
            int digit= Math.min(s, 9);
            ans= ans*10 + digit;
            s= s- digit;
        }
        return ans;
    }
}