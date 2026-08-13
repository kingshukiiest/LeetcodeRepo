class Solution {
    int pair;
    public void merge(int []a, int []b , int []c){
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                c[k++]=a[i++];
            }
            else{
                c[k++]=b[j++];
            }
        }
        while(i!=a.length){
            c[k++]=a[i++];
        }
        while(j!=b.length){
            c[k++]=b[j++];
        }
    }
    public void mergeSort(int []arr){
        int n=arr.length; 
        if(n==1) return;
        int [] a= new int [n/2];
        int [] b= new int[n-n/2];
        int idx=0;
        for(int i=0; i<a.length; i++){
            a[i]=arr[idx++];
        }
        for(int i=0; i<b.length; i++){
            b[i]=arr[idx++];
        }

        mergeSort(a);
        mergeSort(b);
        
        // for(int i=0; i<a.length; i++){
        //     for(int j=0; j<b.length; j++){
        //         if(1L*a[i] > 2L*b[j]){
        //             pair++;
        //         }
        //         else break;
        //     }
        // }
        
        int j=0;
        for(int i=0; i<a.length ; i++){
            // j does not move backwards
            while(j<b.length && 1L*a[i] > 2L*b[j]){
                j++;
            }
            pair+=j;
        }
        merge(a,b,arr);
    }
    public int reversePairs(int[] nums) {
        int n= nums.length;
        pair=0;
        mergeSort(nums);
        return pair;
    }   
}