class Solution {
    public int[][] merge(int[][] iv) {
        int n=iv.length;
        Arrays.sort(iv,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> list= new ArrayList<>();
        int start=iv[0][0];
        int end=iv[0][1];
        for(int i=1; i<iv.length; i++){
            if(iv[i][0] <=end){
                end=Math.max(iv[i][1],end);
            }
            else{
                list.add(new int[]{start,end});
                start=iv[i][0];
                end=iv[i][1];
            }
        }
        list.add(new int[]{start,end});
        int [][] ans = new int[list.size()][2];
        int idx=0;
        for(int [] a : list){
            ans[idx++]=a;
        }
        return ans;
    }
}