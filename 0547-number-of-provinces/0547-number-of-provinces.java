class Solution {
    // public void dfs(int[][] isConnected,int i,boolean[] visited) {
    //     int n=isConnected.length;
    //     visited[i] = true;
        
    //     for(int j=0; j<n; j++){
    //         if(isConnected[i][j]==1 && !visited[j]){
    //             dfs(isConnected,j,visited);
    //         }
    //     }
    // }
    // public void bfs(int[][] isConnected, int i , boolean []visited){
    //     int n=isConnected.length;
    //     visited[i]=true;
    //     Queue<Integer> q= new LinkedList<>();
    //     q.add(i);
    //     while(q.size()>0){
    //         int front=q.poll();
    //         for(int j=0; j<n; j++){
    //             if(isConnected[front][j]==1 && visited[j]==false){
    //                 q.add(j);
    //                 visited[j]=true;
    //             }
    //         }
            
    //     }
    // }
    public int find(int i, int []groupLeader){
        if(groupLeader[i]== i) return i;
        // i will find now on its parent
        return find(groupLeader[i] , groupLeader);
    }
    public void union(int u , int v,int []groupLeader){
        int leaderU= find(u, groupLeader);
        int leaderV= find(v, groupLeader);
        //equal hoga to same component main already hain
        if(leaderU != leaderV){
            groupLeader[leaderV]= leaderU;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        
        int [] groupLeader= new int[n];
        for(int i=0; i<n ; i++){
            groupLeader[i]=i;
        }

        for(int i=0; i<n ; i++){
            for(int j=0; j< n ; j++){
                if(i!=j && isConnected[i][j]==1){
                    union(i,j,groupLeader);
                }
            }
        }

        int count=0;
        for(int i=0; i<n ; i++){
            if(groupLeader[i]==i) count++;
        }
        return count;
    }
}