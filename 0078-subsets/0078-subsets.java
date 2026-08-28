class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n =nums.length;
        int range= 1<<n ;

        for( int i=0 ; i<range ; i++){
           
            List<Integer> list= new ArrayList<>();
            for(int j=0; j<n; j++){
                if(((i>>j)&1)==1){
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}