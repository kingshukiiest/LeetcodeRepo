class Solution {
    // public int lub(int i, int j, int []ages, double limit){
    //     int store=-1;
    //     while(i<=j){
    //         int mid=i+(j-i)/2;
    //         if(ages[mid] <= limit) i=mid+1;
    //         else {
    //             store=mid;
    //             j= mid-1;
    //         }
    //     }
    //     return store;
    // }
    // public int upperBound(int i, int j, int []ages, int elem){
    //     int store=-1;
    //     while(i<=j){
    //         int mid=i+(j-i)/2;
    //         if(ages[mid] <= elem) {
    //             store=mid;
    //             i=mid+1;
    //         }
    //         else {
    //             j=mid-1;
    //         }
    //     }
    //     return store;
    // }
    public int numFriendRequests(int[] ages) {
        int n=ages.length;
        int req=0;

        int []count=new int [121];
        for(int age : ages){
            count[age]++;
        }
        for(int i=1; i<=120; i++){
            if(count[i]==0) continue;

            for(int j=1;j<=i; j++){
                if(count[j]==0) continue;

                // if(j>i) break;

                if(j<= (0.5*i+7)) continue;

                req+=(count[j]*count[i]);

                if(i==j){
                    req= req-count[j];
                }
            }
        }
        
        return req;

    }
}