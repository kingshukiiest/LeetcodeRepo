class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int min=nums[0];
        int max=nums[n-1];
        int target=min+1;
        List<Integer> list= new ArrayList<>();
        for(int i=1; i<n ;i++){
            while(i<n && nums[i]!=target){
                list.add(target);
                target++;
            }
            target++;
        }
        return list;
    }
}