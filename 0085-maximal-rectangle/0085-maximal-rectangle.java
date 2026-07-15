class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int [] nse= new int[n];
        int [] pse= new int[n];
        //marking idx
        Stack<Integer> st= new Stack<>();
        //nse
        for(int i=n-1; i>=0; i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0) nse[i]=n;
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        while(st.size()>0) st.pop();
        //pse
        for(int i=0; i<n; i++){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0) pse[i]=-1;
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        int maxArea=0;
        int area=0;
        int width=0;
        for(int i=0; i<n ; i++){
            width=nse[i]-pse[i]-1;
            area=width*arr[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {

        int m=matrix.length;
        int n=matrix[0].length;
        int [][] arr= new int[m][n];
        for( int j=0; j<n ; j++){
            arr[0][j]=(int)(matrix[0][j]-'0');
        }
        for( int j=0; j<n ;j++){
            for( int i=1; i<m ; i++){
                if(matrix[i][j]!='0'){
                    int prev=arr[i-1][j];
                    arr[i][j]= (prev+ matrix[i][j]-48);
                }
            }
        }
        // for( int i=0; i<m ;i++){
        //     for( int j=0; j<n ; j++){
        //        System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        //BROHHHHHH YOU MISSED THIS 
        int maxArea=0;
        for( int [] row : arr){
            maxArea=Math.max(maxArea,largestRectangleArea(row));
        }
        return maxArea;
    }
    
}