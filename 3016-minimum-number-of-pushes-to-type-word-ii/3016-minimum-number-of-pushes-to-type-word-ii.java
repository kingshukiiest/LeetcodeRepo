class Solution {
    class Pair{
        char ch ;
        int freq;
        Pair(char ch , int freq){
            this.ch= ch;
            this.freq= freq;
        }
    }
    public int minimumPushes(String word) {
        int n=word.length();
        int count=0;
        int x=1;

        HashMap<Character, Integer> map= new HashMap<>();
        for(char ch : word.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(b.freq,a.freq) );
        
        for(char ch : map.keySet()){
            pq.add(new Pair(ch, map.get(ch)));
        }

        while(pq.size()!=0){
            int grp=Math.min(pq.size(),8);

            while(grp-- > 0){
                Pair top= pq.poll();
                int freq=top.freq;
                count+= (x*freq);
            }
            x++;
        }
        return count;
    }
}