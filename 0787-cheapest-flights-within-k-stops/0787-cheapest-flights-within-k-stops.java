class Solution {
    class Pair {
        int node; 
        int price;
        Pair(int node, int price){
            this.node= node;
            this.price= price;
        }
    }
    class State{
        int node;
        int price;
        int stops;
        State(int node, int price, int stops){
            this.node= node;
            this.price= price;
            this.stops= stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> list= new ArrayList<>();
        for(int i=0; i<n ; i++){
            list.add(new ArrayList<>());
        }
        for( int [] e : flights){
            int u=e[0];
            int v= e[1];
            int price=e[2];
            list.get(u).add(new Pair(v,price));
        }

        int [][] minPrice= new int [n][k+1];
        for( int [] arr : minPrice){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        minPrice[src][0]=0;

        PriorityQueue<State> pq= new PriorityQueue<>((a,b)->
                            Integer.compare(a.price, b.price));
        
        pq.add(new State(src,0,-1)); // node, price, stops

        while(pq.size()>0){
            State curr= pq.poll();
    
            if(curr.node==dst) {
                continue;
            }
            // if(minPrice[curr.node][curr.stops] < curr.price){
            //     continue;
            //     //dijkstra special
            // }

            // if(curr.stops == k){
            //     continue;
            // }

            if(curr.stops < k){
                int newStop= curr.stops+1;

                for( Pair p : list.get(curr.node)){
                    int totalPrice= p.price+ curr.price;

                    if( totalPrice < minPrice[p.node][newStop]){
                        minPrice[p.node][newStop]=totalPrice;
                        pq.add(new State(p.node,totalPrice,newStop));
                    }
                }
            }
        }
        for( int i=0; i<n ; i++){
            for(int j=0; j<=k ; j++){
                System.out.print(minPrice[i][j]+" ");
            }
            System.out.println();
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0; i<=k ; i++){
            ans= Math.min(ans,minPrice[dst][i]);
        }
        return (ans==Integer.MAX_VALUE)? -1 : ans;
    }
}