class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        int i=0; int j=0;
        int maxLen=1;
        while(j<n){
            int elem = nums[j];
            map.put(elem, map.getOrDefault(elem,0)+1);
            if(map.get(elem)>k){
                maxLen=Math.max(maxLen,j-i);

                while(map.get(elem)>k){
                    int freq=map.get(nums[i]);
        
                    if(freq==1) map.remove(nums[i]);
                    else{
                        map.put(nums[i],freq-1);
                    }
                    i++;
                }     
            }
            j++;
        }
        maxLen=Math.max(maxLen,j-i);
        // for(int i=0; i<n ; i++){
        //     for(int j=i; j<n ; j++){
        //         map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            
        //         if(map.get(nums[j]) > k){
        //             break;
        //         }
        //         maxLen=Math.max(maxLen,j-i+1);
        //     }
        //     map.clear();
        // }
        
        return maxLen;
    }
}