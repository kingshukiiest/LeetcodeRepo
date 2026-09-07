class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Set<List<Integer>> ans= new HashSet<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(nums[0],0);
        for(int i=0; i<n ; i++){
            int target=(-nums[i]);
            
            for(int j=i+1; j<n ; j++){
                // if(i==j) continue;
                if(map.containsKey(target-nums[j])){
                    int index=map.get(target-nums[j]);
                    if(index!=i && index!=j){
                        List<Integer> list= new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[index]);
                        Collections.sort(list);
                        ans.add(list);
                    }
                }
                map.put(nums[j],j);
            }
        }
        return new ArrayList<>(ans); 
        
    }
}