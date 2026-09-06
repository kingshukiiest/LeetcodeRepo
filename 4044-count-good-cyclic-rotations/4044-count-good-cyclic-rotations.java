class Solution {
    public int countGoodRotations(int[] nums) {
        int n=nums.length;
        int count=0;
        long totalSum=0;
        int mid=(n/2);
        long leftSum=0;
        
        for(int i=0; i<n; i++){
            totalSum+=nums[i];
            if(i<mid){
                leftSum+=nums[i];
            }
        }

        int i=0;
        int j=(n/2);

        while(i<n){
            long  rightSum=totalSum-leftSum;
            if(leftSum> rightSum){
                count++;
            }
            leftSum-=nums[i];
            leftSum+=nums[j];
            i++;
            j= ((j+1)%n);
        }
        return count;
    }
}