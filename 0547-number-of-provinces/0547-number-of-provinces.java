class Solution {
       
    public int find(int i, int []parent){
        if(parent[i]== i) return i;
        // i will find now on its parent
        return parent[i]=find(parent[i] , parent);
    }
    public void union(int u , int v,int []parent, int [] size){
        int leaderU= find(u, parent);
        int leaderV= find(v, parent);
        //equal hoga to same component main already hain
        if(leaderU != leaderV){
            if(size[leaderU] > size[leaderV]){
                parent[leaderV]= leaderU;
                size[leaderU] +=size[leaderV];
            }
            else{
                parent[leaderU]=leaderV;
                size[leaderV] +=size[leaderU];
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        
        int [] parent= new int[n];
        int [] size= new int [n];
        for(int i=0; i<n ; i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0; i<n ; i++){
            for(int j=0; j< n ; j++){
                if(i!=j && isConnected[i][j]==1){
                    union(i,j,parent,size);
                }
            }
        }

        int count=0;
        for(int i=0; i<n ; i++){
            if(parent[i]==i) count++;
        }
        return count;
    }
}