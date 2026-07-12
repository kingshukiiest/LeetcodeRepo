class Solution {
    class Triplet {
        int node;
        long time;
        int power; // remaining power
        Triplet(int node, long time, int power){
            this.node= node;
            this.time= time;
            this.power=power;
        }
    }
    class Pair {
        int node;
        long time;
        Pair(int node,long time){
            this.node= node;
            this.time= time;
        }
    }
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int src, int target) {
        List<List<Pair>> list= new ArrayList<>();
        for( int i=0; i<n ; i++){
            list.add(new ArrayList<>());
        }
        
        for( int [] rows : edges){
            int u=rows[0];
            int v=rows[1];
            long time=rows[2];

            list.get(u).add(new Pair(v,time));
        }
        PriorityQueue<Triplet> pq= new PriorityQueue<>((a,b)->Long.compare(a.time , b.time));

        long [][] minTime = new long[n][power+1];

        for(long [] arr : minTime){
            Arrays.fill(arr,Long.MAX_VALUE);
        }
        minTime[src][power]=0;

        pq.add(new Triplet(src,0,power));

        while(pq.size()>0){
            Triplet front= pq.poll();
            int node=front.node;
            int powerLeft=front.power;
    //         if(front.time > minTime[node][powerLeft])
    // continue;
            
            if(powerLeft >= cost[node]){
                
                for(Pair p : list.get(node)){
                    long totalTime=p.time+front.time;
                    int newPower= powerLeft-cost[front.node];

                    if(totalTime < minTime[p.node][newPower] ){
                        minTime[p.node][newPower] = totalTime;
                        pq.add(new Triplet(p.node,totalTime,newPower));
                    }
                }
            }
        }
        long maxPower=0;
        long time=Long.MAX_VALUE;

        for(int i=0; i<=power; i++){
            if(time >= minTime[target][i]){
                time= minTime[target][i];
                maxPower=i;
            }
        }

        if(time==Long.MAX_VALUE){
            return new long[]{-1,-1};
        }
        return new long[]{time,maxPower};

    }
}