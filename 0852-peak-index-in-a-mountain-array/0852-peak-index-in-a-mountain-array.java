class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int low=0;
        int high= n-1;
        int store=-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            
            if(arr[mid]<arr[mid+1]){
                low=mid+1;
            }
            else{
                store=mid;
                high=mid-1;
            }
        }
        return store;
    }
}