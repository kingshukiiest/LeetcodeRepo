class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        int[] ans = new int[n];
        
        for( int i=0; i<n ; i++){
            int prevMax=Integer.MIN_VALUE;
            int count=0;
            for( int j=i+1; j<n ; j++){
                if(prevMax < heights[j]){
                    prevMax=heights[j];
                    count++;
                }
                if(heights[j]>= heights[i]) break;
            }
            ans[i]=count;
        }
        return ans;
    }
}