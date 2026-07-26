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
        int end=-1;
        if(n==1)  end=9;
        else if (n==2) end=99;
        else if (n==3) end=999;
        else if (n==4) end= 9999;
        else if (n==5) end= 99999;

        for(int num=0; num<=end; num++){
            if(sum(num)==s){
                store=num;
            }
        }
        return store;
        
    }
}