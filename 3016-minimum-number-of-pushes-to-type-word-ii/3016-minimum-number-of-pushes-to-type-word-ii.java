class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int ans=0;
        int x=1;
        int c=0;
        int [] freq= new int[26];
        for(char ch : word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        for(int i=25; i>=0; i--){
            if(freq[i]==0) break;

            ans+=(freq[i]*x);
            c++;
            if(c==8){
                c=0;
                x++;
            }
        }
        return ans;
    }
}