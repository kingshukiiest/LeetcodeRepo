class Solution {
    //1 1 2 2 2 3
    //      i
    //      k
    public int removeDuplicates(int[] nums) {
        int n= nums.length;
        if(n<=2){
            return 2;
        }
        int i=2;
        int j=2;
        while(j<n){
            if(nums[j]!=nums[i-2]){
                nums[i]=nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}