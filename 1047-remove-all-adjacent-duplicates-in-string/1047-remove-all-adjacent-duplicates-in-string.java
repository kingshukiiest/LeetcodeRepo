class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb= new StringBuilder();
        for(char ch : s.toCharArray()){
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=ch){
                sb.append(ch);
            }
            else{
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}