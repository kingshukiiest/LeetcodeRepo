class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set= new HashSet<>();
        for(int elem : nums){
            set.add(elem);
        }
        int i=1;
        while(true){
            int elem =k*i;
            if(!set.contains(elem)){
                return elem;
            }
            i++;
        }
    }
}