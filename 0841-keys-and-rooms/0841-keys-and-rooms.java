class Solution {
    public void bfs(List<List<Integer>> rooms, boolean [] visited){
        int n= rooms.size();
        Queue<Integer> q= new LinkedList<>();
        q.add(0);

        visited[0]=true;

        while(q.size()>0){
            int front= q.poll();

            for(int ele : rooms.get(front)){
                
                if(!visited[ele]){
                    q.add(ele);
                    visited[ele]=true;   
                } 
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean[] visited= new boolean[n];
        bfs(rooms, visited);

        for( boolean a : visited){
            if(a==false) return false;
        }
        return true;
    }
}