class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder res= new StringBuilder();
        int n=s.length();
        for(char ch : s.toCharArray()){
            String rawBinary=Integer.toBinaryString(ch);
            String paddedBinary=String.format("%8s",rawBinary).replace(' ','0');

            res.append(paddedBinary);
        }
        int i=0;
        int j=res.length()-1;
        boolean flag=true;
        while(i<=j){
            if(res.charAt(i)!=res.charAt(j))  {
                flag=false;
                break;
            }
            i++; j--;
        }
        return flag;
    }
}