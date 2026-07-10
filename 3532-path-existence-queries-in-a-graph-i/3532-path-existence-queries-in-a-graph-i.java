class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int []connected = new int [n];
        int id=0;

        for( int i=1; i<n; i++){
            if(nums[i] - nums[i-1] <=maxDiff){
                connected[i]= id;
            }
            else{ 
                // diff connected component
                id++;
                connected[i]=id;
            }
        }
        boolean [] ans= new boolean[queries.length];
        int idx=0;

        for(int [] arr: queries){
            int u=arr[0];
            int v= arr[1];
            if(connected[u]==connected[v]){
                ans[idx]=true;
            }
           idx++;
        }
        return ans;
    }
}