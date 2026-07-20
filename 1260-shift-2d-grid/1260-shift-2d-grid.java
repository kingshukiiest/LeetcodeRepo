class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        // size m*n 
        // k= k%(m*n)
        // if k==0? return same
        //cr=0, cc=1
        // after k=4, cr=1, cc=2
        // n=3, m=3
        // cc will be incremented by k%m (4%3) =1 
        // then cc%m
        // cr will be incremented by k/m
        // then cr%n for 3 to 0

        int m=grid.length;
        int n=grid[0].length;
        List<List<Integer>> res =new ArrayList<>();
        int [][] ans= new int [m][n];
        int size=(m*n);
        k = k%(size);

        for( int i=0; i<m ; i++){
            for( int j=0; j<n ; j++){
                int elem=grid[i][j];
                int cr=i; //0
                int cc=j; //2

                cc = cc+ (k%n); //2+1=3
                cr= cr+ (k/n);
                
                if(cc>=n) cr++;
                cc= cc%n;

                cr= cr%m;

                ans[cr][cc]=grid[i][j];
            }
        }
        for( int i=0; i<m ; i++){
            List<Integer> list= new ArrayList<>();
            for( int j=0; j<n ; j++){
                list.add(ans[i][j]);
            }
            res.add(list);
        }
        
        return res;
    }
}