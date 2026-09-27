class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int [] count= new int [101];
        int maxFreq=0;
        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;
            maxFreq=Math.max(maxFreq,count[nums[i]]);
        }

        int [] ans= new int [n];
        int idx=0;

        for(int i=1; i<=maxFreq;i++){
            for(int j=1; j<=100; j++){
                if(count[j]!=0){
                    ans[idx++]=j;
                    count[j]--;
                }
            } 
        }
        return ans;
    }
}