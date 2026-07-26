class Solution {
    public int sum(int n){
        int sum=0;
        while(n!=0){
            int ld = n%10;
            sum+= ld ;
            n= n/10;
        }
        return sum;
    }
    public int largestInteger(int n, int s) {
        int store=-1;
        if(n==1){
            for(int num=0; num<=9; num++){
                if(sum(num)==s){
                    store=num;
                }
            }
        }
        else if (n==2){
            for(int num=0; num<=99; num++){
                if(sum(num)==s){
                    store=num;
                }
            }
        }
        else if (n==3){
            for(int num=0; num<=999; num++){
                if(sum(num)==s){
                    store=num;
                }
            }
        }
        else if (n==4){
            for(int num=0; num<=9999; num++){
                if(sum(num)==s){
                    store=num;
                }
            }
        }
        else if (n==5){
            for(int num=0; num<=99999; num++){
                if(sum(num)==s){
                    store=num;
                }
            }
        }

        return store;
        
    }
}