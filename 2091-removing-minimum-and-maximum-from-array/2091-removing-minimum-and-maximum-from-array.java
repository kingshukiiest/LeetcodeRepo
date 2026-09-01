class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;

        int min=nums[0];
        int max=nums[0];
        int minIndex=0;
        int maxIndex=0;
        for(int i=0; i<n ;i++){
            if(min>nums[i]){
                min=nums[i];
                minIndex=i;
            }
            if(max<nums[i]){
                max=nums[i];
                maxIndex=i;
            }
        }
        
        
        // int ans=0;
        // int index=Math.max(minIndex,maxIndex);
        // ans=index+1;

        
        // index=Math.min(minIndex,maxIndex);
        // ans=Math.min(ans,n-index);

        // //remove one from left , on from right
        // ans=Math.min(ans,(minIndex+1)+(n-maxIndex));
        // ans=Math.min(ans,(maxIndex+1)+(n-minIndex));
        int ans=0;
        int left=Math.min(minIndex,maxIndex);
        int right=Math.max(minIndex,maxIndex);

        //remove from left
        ans=right+1;

        //remove from right
        ans=Math.min(ans,n-left);


        ans=Math.min(ans,(left+1)+(n-right));

        return ans;
    }
}