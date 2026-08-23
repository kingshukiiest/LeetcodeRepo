class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> list= new ArrayList<>(); // missing elem list
        int n=nums.length;  
        HashSet<Integer> set= new HashSet<>();
        for(int i=0; i<n ; i++){
            set.add(nums[i]);
        }
        for(int i=lower; i<=upper; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        int i=0;
        int j=1;
        if(list.size()==0) return new ArrayList<>();

        else if(list.size()==1){
            int elem= list.get(0);
            List<Integer> temp= new ArrayList<>();
            temp.add(elem);
            temp.add(elem);
            res.add(temp);   
        }
        else{
            while(j<list.size()){
                if(list.get(j)!=list.get(j-1)+1){
                    List<Integer> temp= new ArrayList<>();
                    temp.add(list.get(i));
                    temp.add(list.get(j-1));
                    res.add(temp);
                    i=j;
                }
                j++;
            }
        
            List<Integer> temp= new ArrayList<>();
            temp.add(list.get(i));
            temp.add(list.get(j-1));
            res.add(temp);
        }

        return res;
    }
}