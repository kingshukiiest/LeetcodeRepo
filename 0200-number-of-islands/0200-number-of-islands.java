class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r= r;
             this.c= c;
        }
    }
    public void bfs(char [][]grid, int i, int j){
        int m= grid.length;
        int n= grid[0].length;

        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(i,j));
        grid[i][j]='0';

        int [][] dir= {{0,1},{0,-1},{1,0},{-1,0}};

        while(q.size()>0){
            Pair front=q.poll();
            int r=front.r;
            int c= front.c;

            for(int [] rows : dir){
                int nr=r+ rows[0];
                int nc=c+ rows[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n &&  grid[nr][nc]!='0' ){
                    q.add(new Pair(nr,nc));
                    grid[nr][nc]='0';
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int count=0;

        for(int i=0; i<m; i++){
            for(int j=0;j<n ; j++){
                if(grid[i][j]=='1'){
                    bfs(grid , i , j );
                    count++;
                }
            } 
        }
        return count;
    }
}