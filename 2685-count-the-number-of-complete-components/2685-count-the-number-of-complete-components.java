class Solution {
    int [] parent;
    int [] size;
    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    public void union(int u, int v){
        u=find(u);
        v=find(v);
        if(u!=v){
            if(size[u]> size[v]){
                parent[v]=u;
                size[u] +=size[v];
            }
            else{
                parent[u]=v;
                size[v]+=size[u];
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        parent= new int [n];
        size= new int[n];


        for(int i=0; i<n ; i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int [] e : edges){
            int u=e[0];
            int v=e[1];
            union(u,v);
        }
        
        int [] edgeCount=new int [n];
        for(int [] e : edges){
            int u=e[0];
            // int v=e[1];
            int leader=find(u);
            edgeCount[leader]++;
        }
        int []nodeInComp=new int[n];
        for(int i=0; i<n ; i++){
            int leader=find(i);
            nodeInComp[leader]++;
        }
  
        int ans=0;
        for(int i=0; i<n ;i++){
            if(parent[i]==i){
                int node=nodeInComp[i];
                if(edgeCount[i] >= (node*(node-1))/2){
                    ans++;
                }
            }
        }

        return ans;
    }
}