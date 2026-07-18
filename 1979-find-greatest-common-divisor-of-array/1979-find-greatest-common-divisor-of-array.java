class Solution {
    public int findGCD(int[] nums) {
        int n=nums.length;

        int a=nums[0];
        int b=nums[0];
        for( int i=0; i<n ; i++){
            a=Math.min(a,nums[i]);
            b=Math.max(b,nums[i]);
        }

        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}