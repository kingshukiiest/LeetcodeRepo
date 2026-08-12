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

                while(i<n && nums[i]!=elem){
                    int freq=map.get(nums[i]);
                    if(freq==1) map.remove(nums[i]);
                    else{
                        map.put(nums[i],freq-1);
                    }
                    i++;
                }
                
                int freq=map.get(nums[i]);
                if(freq==1) map.remove(nums[i]);
                else{
                    map.put(nums[i],freq-1);
                }
                i++;// once more 
                
            }
            j++;
        }
        maxLen=Math.max(maxLen,j-i);
        return maxLen;
    }
}