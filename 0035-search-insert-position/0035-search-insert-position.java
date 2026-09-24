class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        if(target> nums[n-1]){
            return n;
        }
        int low=0;
        int high=n-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]< target) low=mid+1;
            else if (nums[mid]> target) high=mid;
            else return mid;
        }
        return low;
    }
}