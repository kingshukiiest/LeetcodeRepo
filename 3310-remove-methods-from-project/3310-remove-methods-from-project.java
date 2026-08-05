class Solution {
    public void bfsDesease(int node, int []isEffected,List<List<Integer>> list){
        int n=isEffected.length;
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited= new boolean[n];
        q.add(node);
        isEffected[node]=1;
        visited[node]=true;

        while(q.size()>0){
            int front=q.poll();
            for( int elem : list.get(front)){
               if(!visited[elem]){
                    q.add(elem);
                    visited[elem]=true;
                    isEffected[elem]=1;
               }
            }
        }
    }
    public void bfsHealth(int node, int []isEffected,List<List<Integer>> list,boolean [] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node]=true;

        while(q.size()>0){
            int front=q.poll();
            for( int elem : list.get(front)){
                if(!visited[elem]){
                    q.add(elem);
                    isEffected[elem]=0;
                    visited[elem]=true;
                }
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> directed= new ArrayList<>();
        for(int i=0; i<n ; i++){
            directed.add(new ArrayList<>());
        }
        for(int [] a : invocations){
            int u=a[0];
            int v=a[1];
            directed.get(u).add(v);
        }
        List<List<Integer>> undirected= new ArrayList<>();
        for(int i=0; i<n ; i++){
            undirected.add(new ArrayList<>());
        }
        for(int [] a : invocations){
            int u=a[0];
            int v=a[1];
            undirected.get(u).add(v);
            undirected.get(v).add(u);

        }
        int []isEffected= new int[n];
        
        //default all health is zero
        bfsDesease(k,isEffected,directed);

        
        boolean [] visited= new boolean[n];
        for(int i=0;i<n ; i++){
            if(isEffected[i]==0 && !visited[i]){
                bfsHealth(i,isEffected,undirected,visited);
            }
        }
        List<Integer> ans= new ArrayList<>();
        for( int i=0; i<n ; i++){
            if(isEffected[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }   
}