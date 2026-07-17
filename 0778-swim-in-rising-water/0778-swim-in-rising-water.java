class Solution {
    class CompareTime implements Comparator<Triplet>{
        @Override
        public int compare(Triplet a, Triplet b){
            return a.time-b.time;
        }
    }
    class Triplet{
        int r;
        int c;
        int time;
        Triplet(int r, int c, int time){
            this.r=r;
            this.c=c;
            this.time=time;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;

        PriorityQueue<Triplet> pq= new PriorityQueue<>(new CompareTime());

        int[][] minTime= new int[n][n];
        for( int [] a : minTime){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        minTime[0][0]=grid[0][0];
        pq.add(new Triplet(0,0,grid[0][0]));

        int [][] dist={{0,1},{0,-1},{1,0},{-1,0}};

        while(pq.size()>0){
            Triplet front=pq.poll();
            int r=front.r;
            int c=front.c;
            int time=front.time;

            //dSpecial
            if(time >minTime[r][c]) continue;

            for(int []row : dist){
                int nr=r+row[0];
                int nc=c+row[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n){

                    int leastTime=Math.max(grid[nr][nc], minTime[r][c]);
                    if(leastTime<minTime[nr][nc]){
                        minTime[nr][nc]=leastTime;
                        pq.add(new Triplet(nr,nc,leastTime));
                    }  
                }
            }
        } 
        return minTime[n-1][n-1];
    }
}