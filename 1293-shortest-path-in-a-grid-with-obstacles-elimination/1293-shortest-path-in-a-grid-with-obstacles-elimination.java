class Solution {
    class CompareSteps implements Comparator<Quad>{
        @Override
        public int compare(Quad a, Quad b){
            // if()
            return Integer.compare(b.chance,a.chance);
        }
    } 
    class Quad{
        int r;
        int c;
        int steps;
        int chance;
        Quad(int r, int c, int steps, int chance){
            this.r=r;
            this.c=c;
            this.steps=steps;
            this.chance=chance;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        
        PriorityQueue<Quad> pq= new PriorityQueue<>(new CompareSteps());

        int[][] minSteps= new int[m][n];
        for( int [] a : minSteps){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        minSteps[0][0]=0;
        pq.add(new Quad(0,0,0,k));

        int [][] dist={{0,1},{0,-1},{1,0},{-1,0}};

        while(pq.size()>0){
            Quad front=pq.poll();
            int r=front.r;
            int c=front.c;
            int steps=front.steps;
            int chance=front.chance;

            //Special
            // if(r==m-1 && c==n-1) return steps;
            
            //dSpecial
            if(steps >minSteps[r][c]) continue;

            for(int []row : dist){
                int nr=r+row[0];
                int nc=c+row[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){

                    if(grid[nr][nc]==1 && chance==0) continue;

                    int totalSteps=steps+ 1;
                    if(totalSteps < minSteps[nr][nc]){
                        minSteps[nr][nc]=totalSteps;
                        if(grid[nr][nc]==1) {
                            pq.add(new Quad(nr,nc,totalSteps, chance-1));
                        }
                        else{
                            pq.add(new Quad(nr,nc,totalSteps, chance));
                        }
                    }
                }
            }
        }   
        return( minSteps[m-1][n-1]==Integer.MAX_VALUE)
                    ? -1 :minSteps[m-1][n-1] ;
    }
}