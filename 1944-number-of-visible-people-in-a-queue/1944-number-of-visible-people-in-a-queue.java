class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        Stack<Integer> st= new Stack<>();
        int n=arr.length;
        int[] ans = new int[n];
        st.push(arr[n-1]);
        ans[n-1]=0;
        int count;
        for(int i=n-2;i>=0;i--){
            count=0;
            while(st.size()>0 && st.peek()<arr[i]){
                st.pop();
                count++;
            }
            if(st.size()==0) ans[i]=count;
            else{
                ans[i]=(count+1);
            }
            st.push(arr[i]);
        }
        return ans;
    }
}