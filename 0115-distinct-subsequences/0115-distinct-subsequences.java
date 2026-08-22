class Solution {
    int []space;

    public int numDistinct(String s, String t) {
        int m =s.length();
        int n =t.length();
        space= new int[n+1];
        space[0]=1;
        for(int i=1; i<=m ; i++){
            
             // if i go left to write, diagonal elem will be overridden
             // so go from right to left

            for(int j=n; j>=1; j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    space[j]+=space[j-1];// adding the diagonal elem actually
                }
            }
        }
        return space[n];
    }
}