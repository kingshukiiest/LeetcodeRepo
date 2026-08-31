class Solution {
    boolean [] column;
    boolean []diagonal1;
    boolean []diagonal2;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans= new ArrayList<>();
        char[][] board= new char[n][n];
        for(int i=0; i<n ; i++){
            for(int j=0; j<n ; j++){
                board[i][j]='.';
            }
        }
        column= new boolean[n];
        diagonal1= new boolean[2*n-1];
        diagonal2= new boolean[2*n-1];

        
        helper(board,0,ans);
        return ans;
    }
    public void helper(char[][] board, int row, List<List<String>> ans){
        int n=board.length;

        if(row==n){
            // i have filled a board;
            // now add it to list;
            List<String> list= new ArrayList<>();
            for(int i=0;i<n ; i++){
                String s = "";
                for(int j=0; j<n ; j++){
                    s+=(board[i][j]);
                }
                list.add(s);
            }
            ans.add(list);
            return;
        }
        for(int j=0; j<n ; j++){
            int d1=row+j;
            int d2=row-j+(n-1);
            if(column[j] || diagonal1[d1] || diagonal2[d2] ){
                // if any of the condition is true, so some queen is already placed there
                continue;
            }
           
            board[row][j]='Q';
            column[j]=true;
            diagonal1[d1]=true;
            diagonal2[d2]=true;

            helper(board,row+1,ans);
            board[row][j]='.';
            column[j]=false;
            diagonal1[d1]=false;
            diagonal2[d2]=false; 
            
        }
    }
    // public boolean canPlace(int cr, int cc, char[][]board){
    //     int n=board.length;
    //     // i wil check up, left diagonal ,right diag
    //     //UP
    //     int row=cr-1;
    //     int col=cc;
    //     while(row>=0){
    //         if(board[row][col]=='Q') return false;
    //         row--;
    //     }
    //     //LD
    //     row=cr-1;
    //     col=cc-1;
    //     while(row>=0 && col>=0){
    //         if(board[row][col]=='Q') return false;
    //         row--; col--;
    //     }
    //     //RD
    //     row=cr-1;
    //     col=cc+1;
    //     while(row>=0 && col<n){
    //         if(board[row][col]=='Q') return false;
    //         row--; col++;
    //     }
    //     return true;
    // }
}