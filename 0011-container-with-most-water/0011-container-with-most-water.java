class Solution {
    public int maxArea(int[] height) {
       
        int n=height.length;
        int maxArea=0;
         //brute force
        // for(int i=0; i<n ; i++){
        //     for(int j=i+1; j<n ; j++){
        //         int h=Math.min(height[i],height[j]);
        //         int width=(j-i);
        //         maxArea=Math.max(maxArea,(h*width));
        //     }
        // }
        int i=0;
        int j=n-1;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            int width=(j-i);
            maxArea=Math.max(maxArea,(h*width));

            if(height[i]< height[j]){
                i++;
            }
            else if(height[i]>height[j]){
                j--;
            }
            else{
                i++;
                j--;
            }
        }
        return maxArea;
    }
}