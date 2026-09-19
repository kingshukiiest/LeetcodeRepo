class Solution {
    public int maxProduct(int n) {
        
        int max=0;
        int smax=0;

        while(n!=0){
            int ld=n%10;
            if(max< ld){
                smax=max;
                max=ld;
            }
            else if(smax< ld){
                smax=ld;
            }
            n= n/10;
        }
        return max*smax;
    }
}