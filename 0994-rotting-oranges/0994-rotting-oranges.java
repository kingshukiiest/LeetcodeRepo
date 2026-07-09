class Solution {
    class Triplet{
        int r;
        int c;
        int time;
        Triplet(int r, int c, int time){
            this.r= r;
            this.c= c;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int rottenOrange=0;
        int emptyCell=0;

        Queue<Triplet> q= new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0;j<n ; j++){
                if(grid[i][j]==0) emptyCell++;

                if(grid[i][j]==2){
                   q.add(new Triplet(i,j,0));
                   grid[i][j]=0;
                   rottenOrange++;
                }
            } 
        }

        int [][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
        int maxTime=0;

        while(q.size()>0){
            Triplet front=q.poll();
            int r=front.r;
            int c= front.c;
            int time= front.time;
            maxTime=Math.max(maxTime, time);

            for(int [] rows : dir){
                int nr=r+ rows[0];
                int nc=c+ rows[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n &&  grid[nr][nc]==1 ){
                    q.add(new Triplet(nr,nc, time+1));
                    rottenOrange++;
                    grid[nr][nc]=0;
                }
            }
        }
        for( int i=0; i<m ; i++){
            for( int j=0; j<n ; j++){
                System.out.print(grid[i][j]+ " ");
            }
            System.out.println();
        }
        int totalOrange= (m*n)- emptyCell;
        
        return (rottenOrange == totalOrange)? maxTime : -1;
    }
}