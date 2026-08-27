class Solution {
    public int numFriendRequests(int[] ages) {
        int n=ages.length;
        int req=0;

        Arrays.sort(ages);
        
        for(int i=n-1; i>=1; i--){
            int j=i-1;
            while(j>=0){
                int x=ages[i];
                int y=ages[j];
                if(!(y<=(x*0.5 +7))){
                    if(x==y) req= req+2;
                    else req++;
                }
                else{
                    break;
                }
                j--;
            }
        }
        return req;

    }
}