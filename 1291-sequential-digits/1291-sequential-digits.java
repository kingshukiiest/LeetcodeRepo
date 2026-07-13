class Solution {
    public int countDigits(int n){
        int count=0;
        while(n!=0){
            count++;
            n= n/10;
        }
        return count;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list= new ArrayList<>();

        int len1=countDigits(low);
        int len2=countDigits(high);
        String s ="123456789";
        for(int length= len1 ; length<=len2 ; length++){

            // int i=0;
            // int j= i+length -1;

            // while(j<s.length()){
            //     int digit=Integer.parseInt(s.substring(i,j+1));
            //     if(digit > high) break;

            //     if(digit >= low) {
            //         list.add(digit);
            //     }
            //     i++;
            //     j++;
            // }
            for( int i=0; i<=(s.length()-length); i++){
                int digit=Integer.parseInt(s.substring(i,i+length));
                if(digit > high) break;

                if(digit >= low) {
                    list.add(digit);
                }
            }
        }
        return list;
    }
}