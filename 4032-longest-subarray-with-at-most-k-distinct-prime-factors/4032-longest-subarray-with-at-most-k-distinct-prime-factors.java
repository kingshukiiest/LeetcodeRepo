class Solution {
    public List<Integer> countDistinctPrime(int n){
        // int c=0;
        List<Integer> list= new ArrayList<>();
        for(int i=2;i*i<=n; i++){
            if(n%i==0){
                list.add(i);
                // c++;
            }
            while(n%i==0){
                n= n/i;
            }
        }
        if(n>1) list.add(n);

        return list;
    }

    public int longestSubarray(int[] nums, int k) {
        int n=nums.length;
        // int []countPrime=new int[n];
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0; i<n;i++){
            ans.add(countDistinctPrime(nums[i]));
        }


        int i=0;
        int j=0;
        // int distinct=0;
        int maxLen=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        while(j<n){
            for(int elem : ans.get(j)){
                map.put(elem, map.getOrDefault(elem,0)+1);
            }
        
            if(map.size()<=k){
                maxLen=Math.max(maxLen,j-i+1);
            }
            else{
                while(map.size()>k){
                    for(int elem : ans.get(i)){
                        int freq=map.get(elem);
                        if(freq==1){
                            map.remove(elem);
                        }
                        else map.put(elem,freq-1);
                    }
                    i++;
                }
            }
            j++;
        }
        return maxLen;
    }
}