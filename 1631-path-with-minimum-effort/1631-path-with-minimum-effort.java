class Solution {
    class CompareEffort implements Comparator<Triplet>{
        @Override
        public int compare(Triplet a, Triplet b){
            return a.effort-b.effort;
        }
    }
    class Triplet{
        int r;
        int c;
        int effort;
        Triplet(int r, int c, int effort){
            this.r=r;
            this.c=c;
            this.effort=effort;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        
        PriorityQueue<Triplet> pq= new PriorityQueue<>(new CompareEffort());

        int[][] minEffort= new int[m][n];
        for( int [] a : minEffort){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        minEffort[0][0]=0;
        pq.add(new Triplet(0,0,0));

        int [][] dist={{0,1},{0,-1},{1,0},{-1,0}};

        while(pq.size()>0){
            Triplet front=pq.poll();
            int r=front.r;
            int c=front.c;
            int effort=front.effort;

            if(r==m-1 && c==n-1) return effort;
            
            //dSpecial
            if(effort >minEffort[r][c]) continue;

            for(int []row : dist){
                int nr=r+row[0];
                int nc=c+row[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){

                    int totalEffort=Math.max(effort, Math.abs(heights[nr][nc]-heights[r][c]));
                    
                    if(minEffort[nr][nc] > totalEffort){
                        minEffort[nr][nc]=totalEffort;
                        pq.add(new Triplet(nr,nc,totalEffort));
                    }  
                }
            }
        }   
        return minEffort[m-1][n-1];
    }
}