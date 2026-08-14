class Solution {
    public int maximumLengthSubstring(String s) {
        int i=0; int j=0;
        int n=s.length();
        int []freq= new int [26];
        // HashSet<Character>set = new HashSet<>();
        // for(char ch :s.toCharArray()){
        //     set.add(ch);
        // }
        // int distinct=set.size();

        int maxLen=0;
        // int count=0;
        while(j<n){
            char ch =s.charAt(j);
            // if(freq[ch-'a']==0){
            //     count++;
            // }
            freq[ch-'a']++;
            
            if(freq[ch-'a']>2){
                // if(count==distinct){
                //     maxLen=Math.max(maxLen,j-i);
                // }
                maxLen=Math.max(maxLen,j-i);

                while(freq[ch-'a']>2){
                    char left= s.charAt(i);
                    freq[left-'a']--;
                    // if(freq[left-'a']==0){
                    //     count--;
                    // }
                    i++;
                }
            }
            j++;
        }
        maxLen=Math.max(maxLen,j-i);
        return maxLen;
    }
}