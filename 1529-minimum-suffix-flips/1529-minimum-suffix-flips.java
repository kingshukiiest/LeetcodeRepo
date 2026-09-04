class Solution {
    public int minFlips(String target) {
        int op=0;
        for(char ch : target.toCharArray()){
            if(op==0 || (op%2)==0){
                if(ch=='1') op++; 
            }
            else{
                char t='1';
                if(ch=='1'){
                    t='0';
                }
                if(t=='1') op++;
            }
        }
        return op;   
    }
}