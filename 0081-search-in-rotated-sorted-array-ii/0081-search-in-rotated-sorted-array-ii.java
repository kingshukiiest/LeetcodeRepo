class Solution {
    public boolean search(int[] nums, int target) {
        int n= nums.length;
        int low=0; int high=n-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target) return true;
            else if (nums[low]==nums[high]){
                
                high--;
            }
            // right half is sorted ?
            else if(nums[mid] <=nums[high]){
                if(target <=nums[high] && target >=nums[mid]){
                    low=mid+1;
                }
                else{
                    high= mid-1;
                }
            }
            // left half is sorted?
            else {
                if(target <=nums[mid] && target >=nums[low]){
                     high= mid-1;
                }
                else{
                    low=mid+1;
                }
            }
        }
        return false;
    }
}