class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r , int c){
            this.r=r;
            this.c=c;
        }
    }
    /// k is my limit 
    public boolean canReach(int k, int [][]minDist){
        int m=minDist.length;
        int n=minDist[0].length;

        if(minDist[0][0] < k) return false;

        Queue<Pair> q= new LinkedList<>();
        boolean [][] visited= new boolean[m][n];
        q.add(new Pair(0,0));
        visited[0][0]=true;

        int [][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
        while(q.size()>0){
            Pair front=q.poll();
            int r=front.r;
            int c=front.c;

            if(r==m-1 && c==n-1){
                return true;
            }

            for(int []a :dir){
                int nr=r+a[0];
                int nc=c+a[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && minDist[nr][nc] >=k && visited[nr][nc]==false){
                    q.add(new Pair(nr,nc));
                    visited[nr][nc]=true;
                }
            }
        }
        return false;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m=grid.size();
        int n=grid.get(0).size();

        int [][]minDist= new int [m][n];
        for(int []a : minDist){
            Arrays.fill(a,-1);
        }
        Queue<Pair> q =new LinkedList<>();
        for(int i=0; i<m ; i++){
            for(int j=0; j<n ; j++){
                if(grid.get(i).get(j)==1){
                    minDist[i][j]=0;
                    q.add(new Pair(i,j));
                }
            }
        }
        int [][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
        while(q.size()>0){
            Pair front=q.poll();
            int r=front.r;
            int c=front.c;

            for(int []a :dir){
                int nr=r+a[0];
                int nc=c+a[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && minDist[nr][nc]==-1){
                    minDist[nr][nc]= minDist[r][c]+1;
                    q.add(new Pair(nr,nc));
                }
            }
        }

        int low=0;
        int high = m+n-2;
        int store=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canReach(mid,minDist)){
                // maximizing the minimum distance
                store=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return store;
    }
}