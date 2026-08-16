class Solution {
    public int kthDigit(long k) {
        if(k<=9) return (int)k;

        long n=9;
        long x=2;
        long y=10;
        long prev=n;
        while(n<k){
            prev=n;
            n+=(9*y)*x;
            if(n>=k) break;
            y= y*10;
            x=x+1;
        } 
        System.out.print(x+" ");
        // x digit wala group
        long m = (long) Math.pow(10, x - 2) - 1;// prev digit wala group ka last block no
        // long blockStart=m+1;
        k= k-prev;
        long temp=(k/(x*10));
        long blockNo=m+temp;

        if(k%(x*10)!=0){
            blockNo= blockNo+1;
        }
        
        System.out.print(blockNo+" ");
        long blockSmall=(10*blockNo);
        long blockLarge=(10*blockNo)+9;
        System.out.print(blockSmall+" ");

        StringBuilder sb= new StringBuilder();
        if((blockNo&1)==1){
            while(blockLarge>=blockSmall){
                sb.append(blockLarge);
                blockLarge--;
            }
        }
        else{ // even block no
            while(blockSmall<=blockLarge){
                sb.append(blockSmall);
                blockSmall++;
            }
        }

        k= (k%(x*10));
        if(k==0){
            if((blockNo&1)==1){
                return 0;
            }
            else{
                return 9;
            }
        }
       return sb.charAt((int) (k-1)) - '0';
    }
}