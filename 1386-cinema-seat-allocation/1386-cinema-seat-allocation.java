class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // boolean [][]blocked= new boolean[n][10];
        // HashSet<Integer> set=  new HashSet<>();
        HashMap<Integer,boolean []>  map= new HashMap<>();
        
        for(int [] a : reservedSeats){
            int r= a[0];
            int c= a[1];
            if(!map.containsKey(r)){
                map.put(r,new boolean[10]);
            }
            map.get(r)[c-1]=true;
           
        }
        int ans=(n-map.size())*2;

        // cheking two, four six,
        for(boolean []blocked : map.values()){
            // if(blocked[row][1]==true && blocked[row][5]==true
            //     || blocked[row][3]==true && blocked[row][5]==true){
            //         continue;
            // }
           
            // if(blocked[row][1]==false){
            //     int c=1;
            //     for(int i=2; i<=4; i++){
            //         if(blocked[row][i]==false){
            //            c++;
            //         }
            //         else break;
            //     }
            //     if(c==4) {
            //         ans++;
            //         blocked[row][3]=true;
            //     }
            // }
            // if(blocked[row][3]==false){
            //     int c=1;
            //     for(int i=4; i<=6; i++){
            //         if(blocked[row][i]==false){
            //            c++;
            //         }
            //         else break;
            //     }
            //     if(c==4) {
            //         ans++;
            //         blocked[row][5]=true;
            //     }
            // }
            // if(blocked[row][5]==false){
            //     int c=1;
            //     for(int i=6; i<=8; i++){
            //         if(blocked[row][i]==false){
            //            c++;
            //         }
            //         else break;
            //     }
            //     if(c==4) ans++;

            // }
            boolean left=true;
            boolean middle= true;
            boolean right=true;

            for(int i=1; i<=4; i++){
                if(blocked[i]==true){
                    left=false;
                    break;
                }
            }
            for(int i=3; i<=6; i++){
                if(blocked[i]==true){
                    middle=false;
                    break;
                }
            }
            for(int i=5; i<=8; i++){
                if(blocked[i]==true){
                    right=false;
                    break;
                }
            }
            if(left && right){
                ans+=2;
            }
            else if ( left || right || middle ){
                ans+=1;
            }

        }
        return ans;
    }
}