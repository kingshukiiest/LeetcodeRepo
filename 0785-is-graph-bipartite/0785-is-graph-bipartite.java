class Solution {
    public boolean bfs(int[][] graph, int [] visited, int i){
        Queue<Integer> q= new LinkedList<>();
        q.add(i);
        visited[i]=1;

        while(q.size()>0){
            int front= q.poll();
            int bit= visited[front];

            for( int elem : graph[front]){
                // not visited -> mark with reverse bit
                // visited -> same bit -> return false
                // visited -> reverse bit-> okay
                if(visited[elem]==0){
                    if((bit&1)==1){
                        visited[elem]=2;
                    }
                    else{
                        visited[elem]=1;
                    }
                    q.add(elem);
                }
                else if(visited[elem]==bit){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int [] visited= new int [n];

        // return bfs(graph, visited, 0);
        // can be multiple component , so .

        for( int i=0; i<n ; i++){
            if(visited[i]==0){
                boolean flag = bfs(graph, visited, i);
                if(!flag) return false;
            }
        }
        return true;
    }
}