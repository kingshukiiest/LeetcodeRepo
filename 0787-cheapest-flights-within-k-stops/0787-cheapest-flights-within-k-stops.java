class Solution {
    class Pair{
        int node;
        int price;
        Pair(int node, int price){
            this.node=node;
            this.price=price;
        }
    }
    class State{
        int node;
        int price;
        int stops;
        State(int node, int price, int stops){
            this.node=node;
            this.price=price;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        List<List<Pair>> list= new ArrayList<>();
        for(int i=0; i<n ; i++){
            list.add(new ArrayList<>());
        }
        for(int []edge : edges){
            list.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        PriorityQueue<State> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(b.stops,a.stops)
        );
        pq.add(new State(src,0,-1));

        int [][]minPrice= new int[n][k+1];
        for(int [] a : minPrice){
            Arrays.fill(a,Integer.MAX_VALUE);  
        }  
        minPrice[src][0]=0;

        while(pq.size()>0){
            State curr=pq.poll();
            int node= curr.node;
            int price=curr.price;
            int stops=curr.stops;

            if(curr.stops+1 > k){
                continue;
            }

            for(Pair p: list.get(node)){
                int newStop=stops+1;

                int totalPrice=price+p.price;
                if(totalPrice<minPrice[p.node][newStop]){
                    minPrice[p.node][newStop]=totalPrice;
                    pq.add(new State(p.node,totalPrice,newStop));
                }
            }
        }
        
        int ans=Integer.MAX_VALUE;
        for(int j=0; j <k+1; j++){
            ans=Math.min(ans,minPrice[dst][j]);
        }
        return (ans==Integer.MAX_VALUE)? -1 : ans;
    }
}