class Solution {
    public int[][] insert(int[][] iv, int[] niv) {
        Arrays.sort(iv,(a,b)->Integer.compare(a[0],b[0]));
        List<int []> list= new ArrayList<>();
        int n=iv.length;
        int i=0;

        while(i<n && iv[i][1] < niv[0] ){
            list.add(new int[]{iv[i][0], iv[i][1]});
            i++;
        }

        while(i<n  && niv[1]>=iv[i][0]){
            niv[0]=Math.min(niv[0],iv[i][0]);
            niv[1]=Math.max(niv[1],iv[i][1]);
            i++;
        }
        list.add(new int[]{niv[0],niv[1]});

        while(i<n){
            list.add(new int[]{iv[i][0], iv[i][1]});
            i++;
        }
        int [][]ans= new int [list.size()][2];
        int idx=0;
        for(int [] a : list){
            ans[idx++]=a;
        }
        return ans;
    }
}