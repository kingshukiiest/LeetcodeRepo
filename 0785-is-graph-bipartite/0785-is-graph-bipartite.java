class Solution {
    int [] parent;
    int [] size ; 
    int [] parity;
    public int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }
    public void union(int a , int b){
        int u=find(a);
        int v=find(b);
        if(u!=v){
            if(size[u]> size[v]){
                parent[v]=u;
                size[u]+=size[v];
                parity[b]=(parity[a]^1);
            }
            else{
                parent[u]=v;
                size[v]+=size[u];
                parity[a]=(parity[b]^1);
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;

        size= new int[n];
        parent= new int[n];
        parity= new int[n];
        for( int i=0; i<n ; i++){
            parent[i]=i;
            size[i]=1;
            parity[i]=0;
        }

        for( int i=0; i<n ; i++){
            int [] adj = graph[i];
            for(int node : adj){
                int u=i;
                int v=node;
                if(v > u){
                    if(find(u)!=find(v)){
                        union(u,v);
                    }
                    else{
                        if(parity[u]==parity[v]) return false;
                    }
                }
            }
        }
        return true;
    } 
}