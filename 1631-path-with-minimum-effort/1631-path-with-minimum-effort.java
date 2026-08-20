class Solution {
    public class EffortCompare implements Comparator<Triplet>{
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
        PriorityQueue<Triplet> pq= new PriorityQueue<>(
            (a,b)->Integer.compare(a.effort,b.effort));
        // PriorityQueue<Triplet> pq= new PriorityQueue<>(new EffortCompare);

        int [][] minEffort= new int[m][n];
        for(int []a : minEffort){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        minEffort[0][0]=0;
        pq.add(new Triplet(0,0,0));
        int [][] dir={{0,1},{0,-1},{1,0},{-1,0}};

        while(pq.size()>0){
            Triplet top= pq.poll();
            int r=top.r;
            int c= top.c;
            int effort= top.effort;

            if(effort >minEffort[r][c]) continue;
            //special 
            if(r==m-1 && c== n-1) return effort;

            for(int []a : dir){
                int nr=a[0]+r;
                int nc=a[1]+c;

                if(nr>=0 && nc>=0 && nr<m && nc <n ){
                    int totalEffort=Math.max(effort, Math.abs(heights[nr][nc]-heights[r][c]));
                    if(totalEffort < minEffort[nr][nc]){
                        minEffort[nr][nc]=totalEffort;
                        pq.add( new Triplet(nr,nc,totalEffort));
                    }
                }
            } 

        }    

        return minEffort[m-1][n-1];
    }
}