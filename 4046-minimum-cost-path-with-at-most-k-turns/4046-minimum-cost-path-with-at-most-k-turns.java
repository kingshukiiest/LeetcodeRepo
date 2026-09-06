class Solution {
    class State{
        int r, c, cost, turn, dir;
        State(int r, int c, int cost, int turn, int dir){
            this.r= r;
            this.c=c;
            this.cost=cost;
            this.turn=turn;
            this.dir=dir;
        }
    }
    public int minCost(int[][] grid, int k) {
        int m=grid.length;
        int n =grid[0].length;

        int [][][][] minCost= new int [m][n][k+1][4];

        for(int [][][]a : minCost){
            for(int [][] b : a){
                for(int []c : b){
                    Arrays.fill(c,Integer.MAX_VALUE);
                }    
            }
        }
        for(int d=0; d<4; d++){
            minCost[0][0][0][d]=grid[0][0];
        }

        PriorityQueue<State> pq= new PriorityQueue<>(
            (a,b)->(Integer.compare(a.cost,b.cost))
        );

        pq.add(new State(0,0,grid[0][0],0,4));//r,c,cost,turn,dir

        int [][] move={{0,-1},{-1,0},{0,1},{1,0}};

        while(pq.size()>0){
            State top=pq.poll();
            int r=top.r;
            int c=top.c;
            int cost=top.cost;
            int prev_dir=top.dir;
            int turn =top.turn;

            for(int i=0; i<4; i++){
                int nr=move[i][0]+r;
                int nc=move[i][1]+c;

                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int newCost=cost+grid[nr][nc];
                    
                    int curr_dir = i;
                    int newTurn;
                    if(prev_dir==4 || prev_dir==curr_dir){
                        newTurn=turn;
                    }
                    else{
                        newTurn = turn+1;
                    }

                    if(newTurn >k) continue;

                    
                    if(minCost[nr][nc][newTurn][curr_dir] > newCost){
                        minCost[nr][nc][newTurn][curr_dir]=newCost;
                        pq.add(new State(nr,nc,newCost,newTurn,curr_dir));
                    }
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int turn=0; turn<=k; turn++){
            for(int d=0; d<4; d++){
                ans=Math.min(ans,minCost[m-1][n-1][turn][d]);
            }  
        }
        return (ans==Integer.MAX_VALUE) ? -1 :ans;
    }
}