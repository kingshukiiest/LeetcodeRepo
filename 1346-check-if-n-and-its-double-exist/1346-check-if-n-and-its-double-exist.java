class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set= new HashSet<>();
        for(int elem : arr){
            if(set.contains(elem*2) ||((elem%2)==0 && set.contains(elem/2))) return true;
            set.add(elem);
        }
        return false;
    }
}