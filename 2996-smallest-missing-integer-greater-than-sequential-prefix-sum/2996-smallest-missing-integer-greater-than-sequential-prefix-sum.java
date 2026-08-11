class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set= new HashSet<>();
        int i=1;
        int sum=nums[0];
        while(i<n){
            if(nums[i]!=nums[i-1]+1){
                break;
            }
            else{
                sum+=nums[i];
                i++;
            }
        }
        for(int k=0; k<n ; k++){
            set.add(nums[k]);
        }
        while(true){
            if(!set.contains(sum)){
                return sum;
            }
            sum++;
        } 
    }

}