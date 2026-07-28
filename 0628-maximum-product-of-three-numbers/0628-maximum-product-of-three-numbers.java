class Solution {
    public int maximumProduct(int[] nums) {
        int n= nums.length;
        int max=Integer.MIN_VALUE;
        int smax=Integer.MIN_VALUE;
        int tmax=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int smin=Integer.MAX_VALUE;

        for( int elem :  nums){
            if(elem >= max){
                tmax= smax;
                smax= max;
                max= elem;
            }
            else if(elem >=smax){
                tmax= smax;
                smax= elem;
            }
            else if(elem > tmax){
                tmax=elem;
            }
            
        }
        for(int elem : nums){
            if( elem <= min){
                smin=min;
                min=elem;
            }
            else if(elem <smin){
                smin=elem;
            }
        }
        int a=max*smax*tmax;
        int b=min*smin*max;

        return Math.max(a,b);
    }
}