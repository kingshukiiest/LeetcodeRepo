class Solution {
    public int lowerUpperBound(long [] prefix, long shift){
        int low=0;
        int high=prefix.length-1;
        int store=-1;
        while(low<=high){
            int mid= low +(high-low)/2;
            if(prefix[mid]<shift){
                low=mid+1;
            }
            else {
                store=mid;
                high= mid-1;
            }
        }
        return store;
    }
    
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n= tasks.length;
        int [] ans = new int [shifts.length];
        long [] prefix=new long [tasks.length];
        
        prefix[0]=tasks[0];
        for( int i=1; i<n ; i++){
            prefix[i]=prefix[i-1]+tasks[i];
        }
        
        int idx=0;
        long done=0;

        for( int s= 0; s<shifts.length; s++){
            long consumed= ( (idx==0)? 0:prefix[idx-1])+done;
            long target=consumed+shifts[s];
            
            if(prefix[n-1]<=target){
                ans[s]=0;
                idx=0;
                done=0;
                continue;
            }
            //can't consume completely
            // else if(prefix[n-1] > currShift){
                
            int lib=lowerUpperBound(prefix,target);

            if(prefix[lib]==target){
                idx=lib+1;
                ans[s]=(n-idx);
                done=0;
            }
            else{
                idx=lib;
                ans[s]=(n-idx);
                long prev=(idx==0)?0 : prefix[idx-1];
                done=(target-prev);
            }
        }
        return ans;
    }
}