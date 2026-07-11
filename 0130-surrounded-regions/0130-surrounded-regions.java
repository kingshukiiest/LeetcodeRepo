class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r= r;
             this.c= c;
        }
    }
    public void solve(char[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        for( int i=0; i<m ;i++){
            for( int j=0; j<n ; j++){
                if(grid[i][j]=='O'){
                    grid[i][j]='T';
                }
            }
        }
        Queue<Pair> q= new LinkedList<>();

        // for( int i=0; i<m ; i++){
        //     for(int j=0; j<n ; j++){
        //         if((i==0 ||j==0 || i==m-1 || j==n-1) && grid[i][j]=='T'){
        //             q.add(new Pair(i,j));
        //             grid[i][j]='O';
        //         }
        //     }
        // }
        //instead of full iteration
        for(int i=0; i<m; i++){
            if(grid[i][0]=='T'){
                q.add(new Pair(i,0));
                grid[i][0]='O';
            }
            if(grid[i][n-1]=='T'){
                q.add(new Pair(i,n-1));
                grid[i][n-1]='O';
            }
        }
        for(int j=0; j<n; j++){
            if(grid[0][j]=='T'){
                q.add(new Pair(0,j));
                grid[0][j]='O';
            }
            if(grid[m-1][j]=='T'){
                q.add(new Pair(m-1,j));
                grid[m-1][j]='O';
            }
        }
        

        int [][] dir= {{0,1},{1,0},{-1,0},{0,-1}};
        while(q.size()>0){
            Pair front= q.poll();
            
            int r=front.r;
            int c= front.c;

            for(int [] rows : dir){
                int nr=r+ rows[0];
                int nc=c+ rows[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='T' ){
                    q.add(new Pair(nr,nc));
                    grid[nr][nc]='O';
                }
            }
        }
        for( int i=0; i<m ; i++){
            for(int j=0; j<n ; j++){
                if(grid[i][j]=='T'){
                    grid[i][j]='X';
                }
            }
        }
    }
}