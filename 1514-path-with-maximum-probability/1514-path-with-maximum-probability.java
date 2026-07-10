class Solution {
    class Pair{
        int node;
        double prob;
        Pair(int node, double prob ){
            this.node=node;
            this.prob=prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int src, int end) {
        
        List<List<Pair>> list= new ArrayList<>();
        for( int i=0; i<n ; i++){
            list.add(new ArrayList<>());
        }
        double [] maxProb= new double[n];
        // 0<=p<=1
        Arrays.fill(maxProb,0);
        maxProb[src]=1;

    
        for(int i=0; i<edges.length ;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            list.get(u).add(new Pair(v,succProb[i]));
            list.get(v).add(new Pair(u,succProb[i]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.prob, a.prob));
        pq.add(new Pair(src, 1));

        while(pq.size()>0){

            Pair front=pq.poll();
            int node=front.node;
            double prob=front.prob;

            if(prob < maxProb[front.node]) continue;

            for(Pair p : list.get(node)){
                double totalProb= p.prob * front.prob;
                if(totalProb > maxProb[p.node]){
                    maxProb[p.node]=totalProb;
                    pq.add(new Pair(p.node, totalProb));
                }
            }
        }
        return maxProb[end];
    }
}