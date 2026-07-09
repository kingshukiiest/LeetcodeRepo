class Solution {
    public void replace(int ele, List<Integer> list){
        int low= 0;
        int high= list.size()-1;
        int lowerBound=-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(list.get(mid) >= ele){
                lowerBound=mid;
                high=mid-1;
            }
            else{
                low= mid+1;
            }
        }
        list.set(lowerBound, ele);
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> list= new ArrayList<>();

        int n= nums.length;
        for( int i=0; i< n ; i++){
            if(list.size()==0 || list.get(list.size()-1) < nums[i]){
                list.add(nums[i]);
            }
            else {
                replace(nums[i], list);
            }
        }
        return list.size();
    }
}