class Solution {
    static final int MOD=1000000007;
    class Pair{
        int node;
        long time;
        Pair(int node, long time){
            this.node=node;
            this.time=time;
        }
    }
    public int countPaths(int n, int[][] roads) {
       
        List<List<Pair>> list= new ArrayList<>();
        for(int i=0; i<n ; i++){
            list.add(new ArrayList<>());
        }
        for(int []edge : roads){
            list.get(edge[0]).add(new Pair(edge[1],edge[2]));
            list.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        pq.add(new Pair(0,0));

        long [] minTime=new long[n];
        long [] count= new long[n];
        count[0]=1;
        Arrays.fill(minTime,Long.MAX_VALUE);
        minTime[0]=0;

        while(pq.size()>0){
            Pair front=pq.poll();
            int node=front.node;
            long time=front.time;
            
            if(time >minTime[node]) continue;

            for(Pair p :list.get(node)){
                long totalTime=time+p.time;
                if(totalTime < minTime[p.node]){
                    minTime[p.node]=totalTime;
                    pq.add(new Pair(p.node,totalTime));
                    count[p.node]=count[node];
                }
                else if(totalTime==minTime[p.node]){

                    count[p.node]=(count[p.node]+count[node])%MOD;
                
                }
            }
        }
        return (int) ((count[n-1])%MOD);
    }
}