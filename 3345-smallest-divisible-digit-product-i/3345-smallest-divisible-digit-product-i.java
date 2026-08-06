class Solution {
    public int product(int n){
        int prod=1;
        while(n!=0){
            int ld=n%10;
            if(ld==0) return 0;
            prod=prod*ld;
            n=n/10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        while(true){
            int prod=product(n);
            if(prod%t==0){
                return n;
            }
            n++;
        }
        
    }
}