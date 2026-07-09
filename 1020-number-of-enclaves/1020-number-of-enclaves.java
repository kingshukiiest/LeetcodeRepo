class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r= r;
             this.c= c;
        }
    }
    public int numEnclaves(int[][] grid) {
        
        int m= grid.length;
        int n= grid[0].length;

        int totalOne=0;
        int visitedOne=0;

        Queue<Pair> q= new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0;j<n ; j++){
                if(grid[i][j]==1) totalOne++;

                if(grid[i][j]== 1 && (i==0 || j==0 || i==m-1 || j==n-1
                )){
                   q.add(new Pair(i,j));
                   grid[i][j]=0;
                   visitedOne++;
                }
            } 
        }

        int [][] dir= {{0,1},{0,-1},{1,0},{-1,0}};

        while(q.size()>0){

            Pair front=q.poll();
            int r=front.r;
            int c= front.c;

            for(int [] rows : dir){
                int nr=r+ rows[0];
                int nc=c+ rows[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n &&  grid[nr][nc]==1 ){
                    q.add(new Pair(nr,nc));
                    visitedOne++;
                    grid[nr][nc]=0;
                }
            }
        }
        // for( int i=0; i<m ; i++){
        //     for( int j=0; j<n ; j++){
        //         System.out.print(grid[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        
        return (totalOne-visitedOne) ;
    }
}