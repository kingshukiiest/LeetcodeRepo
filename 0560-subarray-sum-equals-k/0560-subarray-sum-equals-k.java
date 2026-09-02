class Solution {
    public int subarraySum(int[] nums, int k) {
        // tar=3 
        // 1 2 3 -3 3 -3
        //s=1 c=0 0,1
        // s=3 c=1 3,1
        //s=6 c=2, 6,1
        //s=3 c=3 3,2 
        //s=6 c=5 6,2
        //s=3 c=6 3,3
        
        HashMap<Integer,Integer> map= new HashMap<>();
        int n=nums.length;
        map.put(0,1);
        int sum=0;
        int count=0;
        
        for(int i=0; i<n ; i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=(map.get(sum-k));
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }
}