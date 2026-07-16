class Solution {
    public long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public long gcdSum(int[] nums) {
        int n= nums.length;
        long [] prefixGcd= new long[n];
        int mx=nums[0];
        for( int i=0; i<n ; i++){
            mx=Math.max(mx,nums[i]);
            prefixGcd[i]=gcd(mx,nums[i]);
        }
        Arrays.sort(prefixGcd);
        int i=0;
        int j=n-1;
        long ans=0;
        while(i<j){
            long gcd_pair=gcd(prefixGcd[i],prefixGcd[j]);
            ans+=gcd_pair;
            i++;
            j--;
        }
        return ans;
    }
}