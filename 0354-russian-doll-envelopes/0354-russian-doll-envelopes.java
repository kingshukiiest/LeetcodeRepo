class Solution {
    class NumsComparator implements Comparator<int []>{
        @Override
        public int compare(int []a, int []b){
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        }
    }

    public int maxEnvelopes(int[][] nums) {
        Arrays.sort(nums, new NumsComparator());
        int n= nums.length;
        
        ArrayList<Integer> list= new ArrayList<>();
   
        
        int [] LIS= new int[n];
        for( int i=0; i<n; i++){
           LIS[i]=nums[i][1];
        }

        return lengthOfLIS(LIS);
    
    }

    public void replace(int ele, List<Integer> list){
        int low= 0;
        int high= list.size()-1;
        int lowerBound=-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(list.get(mid) >= ele){
                lowerBound=mid;
                high=mid-1;
            }
            else{
                low= mid+1;
            }
        }
        list.set(lowerBound, ele);
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> list= new ArrayList<>();

        int n= nums.length;
        for( int i=0; i< n ; i++){
            if(list.size()==0 || list.get(list.size()-1) < nums[i]){
                list.add(nums[i]);
            }
            else {
                replace(nums[i], list);
            }
        }
        return list.size();
    }
}