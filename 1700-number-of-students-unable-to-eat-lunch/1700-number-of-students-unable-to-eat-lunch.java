class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n=students.length;
        int zero=0, one=0;
        for(int i=0; i< n; i++){
            if(students[i]==0) zero++;
            else one++;
        }
        for(int i=0; i<n ; i++){
            int val=sandwiches[i];
            if(val==0){
                if(zero==0) return n-i;
                else zero--;
            }
            else {
                if(one==0) return n-i;
                else one--;
            }
        }
        return 0;
    }
}