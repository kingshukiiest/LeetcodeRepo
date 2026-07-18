class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int [] dp= new int[n];
        int [] count= new int [n];
        count[0]=1;
        int ans=0;
        int maxLen=0;

        for( int i=0; i<n ; i++){
            int max=0; 
            int c=1;
            for( int j=0; j<i ; j++){
                if(nums[j]< nums[i]){
                    if(max < dp[j]){
                        max=dp[j];
                        c= count[j];
                    }
                    else if(max==dp[j]){
                        c+= count[j];
                    }
                }
            }
            count[i]=c;
            dp[i]=1+max;
            maxLen=Math.max(maxLen, dp[i]);
        }
        for(int i=0; i<n ; i++){
            if(maxLen==dp[i]){
                ans+=count[i];
            }
        }

        return ans;
    }
}