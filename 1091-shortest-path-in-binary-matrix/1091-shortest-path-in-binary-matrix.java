class Solution {
    class Triplet{
        int r;
        int c;
        int dist;
        Triplet(int r , int c, int dist){
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int [][] dir={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        if(grid[0][0]!=0) return -1;

        Queue<Triplet> q = new LinkedList<>();
        int count=Integer.MAX_VALUE;
        boolean[][] visited= new boolean[m][n];
        q.add(new Triplet(0,0,1));
        visited[0][0]=true;
        boolean flag= false;

        while(q.size()>0){
            Triplet front=q.poll();
            
            int r=front.r;
            int c=front.c;
            int dist=front.dist;
            if(r==m-1 && c==n-1) {
                flag=true;
                count=Math.min(count,dist);
            }

            for(int [] a : dir){
                int nr=r+a[0];
                int nc=c+a[1];
                if(nr>=0 && nc>=0 && nr<m && nc<n && visited[nr][nc]==false && grid[nr][nc]==0){
                    q.add(new Triplet(nr,nc,dist+1));
                    visited[nr][nc]=true;
                }
            }
        }
        return (flag == true)?count : -1;
    }
}