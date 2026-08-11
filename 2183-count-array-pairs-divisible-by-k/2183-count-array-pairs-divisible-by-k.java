class Solution {
    public long nc(int n){
        return (1L*n*(n-1))/2;
    }
    public int gcd( int a , int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public long countPairs(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        // for(int i=0; i<n ; i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1); 
        // }
        for(int i=0; i<n ; i++){
            int x= gcd(nums[i],k);
            map.put(x, map.getOrDefault(x,0)+1);
        }

        long count1=0, count2=0;

        // for(int x : map.keySet()){
        //     for(int y: map.keySet()){
        //         if(x==y){ // own case
        //             // suppose (10,2) present and k=2
        //             // 10 is not divisible by 4 , but 100 is 
        //             //x%k==0 ||
        //             if((1L*x*x)%k==0){
        //                 count2+=nc(map.get(x));
        //             }
        //             continue;
        //         }
        //         if(((1L*x*y)%k)==0){
        //             count1 +=(1L*map.get(x)*map.get(y));
        //         }  
        //     }
        // }
        List<Integer> list= new ArrayList<>(map.keySet());
      
        for(int i=0; i<list.size() ;i++){
            int x=list.get(i);
            for(int j=i+1; j<list.size() ; j++){
                int y=list.get(j);
                if(((1L*x*y)%k)==0){
                    count1 +=(1L*map.get(x)*map.get(y));
                } 
            }
        }
        for(int elem : map.keySet()){
            if((1L*elem*elem)%k==0){
                count2+=nc(map.get(elem));
            }
        }

        long ans=count1+ count2;
        // long ans=(count1)/2+ count2;
        return ans;
    }
}