class Solution {

    // //turn 0 for p1;
    // //turn 1 for p2
    // public int helper(int i, int j, int [] nums, int turn ){
    //     if(i>j) return 0;
    //     int scoreP1=0;
    //     int scoreP2=0;
    //     if(turn==0){
    //         int choice1=nums[i]+helper(i+1, j, nums,(turn^1));
    //         int choice2=nums[j]+ helper(i, j-1, nums, (turn^1));
            
    //         return Math.max(choice1, choice2);
    //     }
    //     else{
    //         int choice1=helper(i+1, j, nums,(turn^1));
    //         int choice2=helper(i, j-1, nums, (turn^1));
             
    //         return Math.min(choice1,choice2);
    //     }
        
        
    // }
    public boolean predictTheWinner(int[] nums) {
        int n= nums.length;
        // int sum=0;
        // for(int x : nums){
        //     sum+=x;
        // }

        // int p1Score = helper(0, nums.length-1, nums, 0);
        // int p2Score=sum-p1Score;

        // return (p1Score>=p2Score);
        
        return helper2(0,n-1, nums)>=0;
    }
    public int helper2(int i, int j , int []nums){
        if(i==j) return nums[i];

        int choice1= nums[i]- helper2(i+1, j , nums);
        int choice2= nums[j]- helper2(i, j-1, nums);

        return Math.max(choice1, choice2);
    }
}