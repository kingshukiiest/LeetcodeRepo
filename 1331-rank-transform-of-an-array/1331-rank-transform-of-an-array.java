class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n= arr.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        
        int [] arr2= Arrays.copyOf(arr,n);

        Arrays.sort(arr2);
        int c=1;
        for(int i=0; i<n ; i++){
            if(!map.containsKey(arr2[i])){
                map.put(arr2[i],c);
                c++;
            }
            
        }
        
        int [] ans=new int [n];
        for(int i=0; i<n ; i++){
            ans[i]=map.get(arr[i]);
        }
        return ans;
    }
}