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
        
        // if(minIndex<=(n/2) && maxIndex<=(n/2)){
        //     int index=Math.max(minIndex,maxIndex);
        //     return index+1;
        // }
        // else if(minIndex>(n/2) && maxIndex>(n/2)){
        //     int index=Math.min(minIndex,maxIndex);
        //     return n-index;
        // }
        // else{
        //     int ans=0;
        //     if(minIndex<=(n/2)){
        //         ans+=(minIndex+1);
        //     }
        //     else{
        //         ans+=(n-minIndex);
        //     }

        //     if(maxIndex<=n/2){
        //         ans+=(maxIndex+1);
        //     }
        //     else{
        //         ans+=(n-maxIndex);
        //     }

        //     return ans;
        // }
        //remove from left
        int ans=0;
        int index=Math.max(minIndex,maxIndex);
        ans=index+1;

        //remove from right
        index=Math.min(minIndex,maxIndex);
        ans=Math.min(ans,n-index);

        //remove one from left , on from right
        ans=Math.min(ans,(minIndex+1)+(n-maxIndex));
        ans=Math.min(ans,(maxIndex+1)+(n-minIndex));

        return ans;
    }
}