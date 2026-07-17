class Solution {
    public boolean countDays(int[] arr,int limit, int days)
    {
        int n=arr.length;
        int capacity=0;
        int day=1;
        for( int i=0; i<n ; i++){
            if(capacity+ arr[i] <= limit){
                capacity+=arr[i];
            }
            else{
                day++;
                capacity=arr[i];
            }
        }
        return (day<=days);
    }
    public int shipWithinDays(int[] arr, int days) {
        int low=0, high=0;
        int store=0;
        for(int elem : arr){
            low=Math.max(low,elem);
            high+=elem;
        }
        while(low<=high){
            int mid=low+(high-low)/2;

            if(countDays(arr,mid,days)){
                store=mid;
                high=mid-1;
            } 
            else low=mid+1;
        }
        return store;
    }
}