class Solution {
    public int countCharacters(String[] words, String chars) {
        int [] count= new int [26];
        for(char ch : chars.toCharArray()){
            count[ch-'a']++;
        }

        int n=words.length;
        int ans=0;
        for(int i=0; i<n; i++){
            int [] count2= new int[26];
            for(char ch : words[i].toCharArray()){
                count2[ch-'a']++;
            }
            boolean flag=true;
            for(int j=0; j<26; j++){
                if(count2[j]>count[j]) {
                    flag=false;
                    break;
                }
            }
            if(flag) ans+=(words[i].length());
        }
        return ans;
    }
}