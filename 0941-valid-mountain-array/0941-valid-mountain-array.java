class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        if(n<3) return false;
        
        int peakIdx=0;
        for(int i=1; i<n ; i++){
            if(arr[i]==arr[i-1]) return false;
            if(arr[i]>arr[i-1]){
                peakIdx=i;
            }
            else{
                break;
            }
        }
        if(peakIdx==0 || peakIdx==n-1) return false;
        for(int i=peakIdx+1; i<n; i++){
            if(arr[i]>=arr[i-1]) return false;
        }
        return true;
    }
}