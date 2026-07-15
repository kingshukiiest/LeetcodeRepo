class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n= heights.length;
        Stack <Integer> st= new Stack<>();
        int [] ans=new int [n];
        ans[n-1]=0;
        st.push(n-1);

        for( int i= n-2; i>=0 ; i--){
            int count=0;
            while(!st.isEmpty() && heights[st.peek()] <= heights[i]){
                st.pop();
                count++;
            }
            if(st.size()==0){
                ans[i]=count;
            }
            else{
                ans[i]=count+1;
            }
            
            st.push(i);
        }
        return ans;

    }
}