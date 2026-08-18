class Solution {
    public int largestInteger(int[] nums, int k) {
        int n= nums.length;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i],
            map.getOrDefault(nums[i],0)+1);
        }

        if(k==1){   
            int val=-1;
            for(int elem : nums){
                if(map.get(elem)==1)
                {
                    val=Math.max(elem,val);
                }
            }
            return val;
        }
        if(k==n){
            int val= nums[0];
            for(int elem : nums){
                val=Math.max(val,elem);
            }
            return val;
        }
        
            
        int ans=-1;
        if(map.get(nums[0])==1){
            ans=nums[0];
        }
        if(map.get(nums[n-1])==1){
            ans=Math.max(nums[n-1],ans);
        }

        return ans;
        
    }
}