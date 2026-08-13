class Solution {
    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void solve(String s, int i,List<List<String>> list,List<String> l){
        int n=s.length();
        if(i==n){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int end=i;end<n; end++){
            String curr=s.substring(i,end+1);
            if(isPalindrome(curr)){
                l.add(curr);
                solve(s,end+1,list,l);
                l.remove(l.size()-1);
            }
           
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list= new ArrayList<>();
        solve(s,0,list,new ArrayList<>());

        return list;
    }
}