class Solution {
    public String smallestPalindrome(String s) {
    
        StringBuilder sb =new StringBuilder();
        int n= s.length();

        int []freq= new int [26];
        for(int i=0; i<(n/2); i++){
            char ch =s.charAt(i);
            freq[ch-'a']++;
        }
        for( int i=0; i<26 ; i++){
            char ch= (char)(i+'a');
            while(freq[i]>0){
                sb.append(ch);
                freq[i]--;
            }
        }
        String result="";
        result+=sb.toString();
        if((n&1)==1){
            char midChar=s.charAt(n/2);
            result+=midChar;
        }
        result+=sb.reverse();

        return result;
    }
}