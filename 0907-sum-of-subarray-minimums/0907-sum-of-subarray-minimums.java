class Solution {
    public int sumSubarrayMins(int[] arr) {
        // 2,2 testcase actual catch
        int n=arr.length;
        int [] pse = new int [n];
        int [] nse = new int[n];
        //nse
        Stack<Integer> st = new Stack<>();
        for( int i=n-1; i>=0 ;i--){
            while(st.size()!=0 && arr[st.peek()]> arr[i]){
                st.pop();
            }
            if(st.size()==0){
                nse[i]=n;
            }
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for( int i=0; i<n ;i++){
            while(st.size()!=0 && arr[st.peek()]>= arr[i]){
                st.pop();
            }
            if(st.size()==0){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }

        long ans=0;
        long MOD=1000000007;

        for( int i=0; i<n ; i++){
            
            long left=(i-pse[i]);
            long right=(nse[i]-i);

            long count=((left*right)%MOD *arr[i])%MOD;
            ans = (ans + count) % MOD;
        }
        return (int)ans;
    }
}