class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n=nums.length;
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<n ; i++){
            list.add(new ArrayList<>());
        }
        for(int i=1; i<n ; i++){
            int p=parent[i];
            list.get(p).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int [] depth= new int[n];
        depth[0]=1;
        int height=1;

        
        while(q.size()>0){
            int front=q.poll();
            for(int elem : list.get(front)){
                q.add(elem);
                depth[elem]= depth[front]+1;
                height=Math.max(height,depth[elem]);
            }
        }

        long sum=0;
        for(int i=0; i<n ; i++){
            long weight=(1L*nums[i]*(height-depth[i]+1));
            sum+=weight;
        }
        return sum;

    }
}