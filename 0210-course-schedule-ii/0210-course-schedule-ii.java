class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for( int i=0; i<n ; i++){
            adj.add(new ArrayList<>());
        }
        int [] indegree= new int[n];

        for(int [] rows : prerequisites){
            int u=rows[0];
            int v= rows[1];
            // v to u edge
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for( int i=0;i<n ;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans= new ArrayList<>();
        while(q.size()>0){
            int front= q.poll();
            ans.add(front);

            for( int elem : adj.get(front)){
                indegree[elem]--;
                if(indegree[elem]==0){
                    q.add(elem);
                }
            }
        }

        if(ans.size()==n){
            int [] arr= new int [n];
            for( int i=0; i<n; i++){
                arr[i]=ans.get(i);
            }
            return arr;
        }
        return new int[]{};
    }
}