class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n=students.length;
        
        int [] count= new int[2];
        for(int i=0; i<n ; i++){
            count[students[i]]++;
        }
        for(int i=0; i<n; i++){
            if(count[sandwiches[i]]==0){
                break;
            }
            count[sandwiches[i]]--;
        }
        return count[0]+count[1];
    }
}