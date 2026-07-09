class Solution {
   class Pair{
        int r;
        int c;
        
        Pair(int r, int c){
            this.r= r;
            this.c= c;
        }
    }
    public int[][] updateMatrix(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        int [][] ans = new int [m][n];

        Queue<Pair> q= new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0;j<n ; j++){

                if(grid[i][j]== 0){
                   q.add(new Pair(i,j));
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

                if(nr>=0 && nr<m && nc>=0 && nc<n &&  grid[nr][nc]==1  && ans[nr][nc]==0 ){
                    q.add(new Pair(nr,nc));
                    // grid[nr][nc]=0;
                    ans[nr][nc]= 1+ ans[r][c];
                }
            }
        }
        // for( int i=0; i<m ; i++){
        //     for( int j=0; j<n ; j++){
        //         System.out.print(ans[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        
        return ans;
    }
}