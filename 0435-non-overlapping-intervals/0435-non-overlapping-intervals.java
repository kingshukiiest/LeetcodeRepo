class Solution {
    public class CompareArray implements Comparator<int[]>{
        @Override
        public int compare(int []a,int []b){
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        // Arrays.sort(intervals, (a,b)->(a[0]==b[0])? a[1]-b[1] : a[0]-b[0]);
        Arrays.sort(intervals,new CompareArray());
        for(int []a : intervals){
            System.out.println(a[0]+" "+a[1]);
        }

      
        int end=intervals[0][1];
        int kept=1;

        for(int i=1; i<n; i++){
            if(intervals[i][0] >= end){
                kept++;
                end=intervals[i][1];
            }
            else{
                end=Math.min(end, intervals[i][1]);
            }
        }
        return n-kept;
    }
}