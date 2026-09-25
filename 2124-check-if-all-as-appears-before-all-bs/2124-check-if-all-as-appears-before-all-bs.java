class Solution {
    public boolean checkString(String s) {
        boolean flag =true;
        for(char ch :s.toCharArray()){
            if(ch=='b') flag=false;
            if(ch=='a' && !flag) return false;
        }
        return true;
    }
}