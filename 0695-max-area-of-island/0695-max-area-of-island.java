class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r , int c){
            this.r= r; 
            this.c= c;
        }
    }
    public int bfs(int [][]grid, int i , int j){
        int m= grid.length;
        int n= grid[0].length;
        int area=0;

        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(i,j));
        grid[i][j]=0;
        int [][] dir= {{0,1},{0,-1},{1,0},{-1,0}};

        while(q.size()>0){
            Pair front=q.poll();
            area++;

            for(int [] rows : dir){
                int nr=rows[0]+ front.r;
                int nc=rows[1]+ front.c;

                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                    q.add(new Pair(nr,nc));
                    grid[nr][nc]=0;
                }
            }
        }
        return area;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int maxArea=0;

        for( int i=0; i<m ; i++){
            for( int j=0; j<n ; j++){
                if(grid[i][j]==1){
                    maxArea= Math.max(maxArea, bfs(grid,i,j));
                }
            }
        }
        return maxArea;
    }
}