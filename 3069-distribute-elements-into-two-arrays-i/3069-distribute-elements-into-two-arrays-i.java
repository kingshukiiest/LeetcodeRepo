class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int [] res= new int [n];
        List<Integer>a= new ArrayList<>();
        List<Integer>b= new ArrayList<>();

        a.add(nums[0]);
        b.add(nums[1]);

        for(int i=2; i<n ; i++){
            if( a.get(a.size()-1) > b.get(b.size()-1)){
                a.add(nums[i]);
            }
            else b.add(nums[i]);
        }
        int idx=0;
        for(int elem : a){
            res[idx++]=elem;
        }
        for(int elem : b){
            res[idx++]=elem;
        }
        return res;
    }
}