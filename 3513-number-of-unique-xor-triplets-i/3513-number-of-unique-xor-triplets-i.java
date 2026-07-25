class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // IUCI
    
        int n= nums.length;
        if(n<=2) return n;
        
        int bits= (32-Integer.numberOfLeadingZeros(n));
        return 1<<bits;
    }
}