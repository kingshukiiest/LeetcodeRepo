class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode a= head;
        ListNode b=a.next;
        ListNode c= b.next;
        if(c==null || c.next==null){
            return new int[]{-1,-1};
        }

        int currIndex=1;
        int prevIndex=-1;
        int firstIndex=-1;
        int minDist=Integer.MAX_VALUE;
        while(c!=null){
            //checking maxima or minima
            if((b.val >a.val && b.val > c.val) 
                || (b.val<a.val && b.val<c.val)){
                    //this is a critical point

                    if(firstIndex==-1){
                        firstIndex=currIndex;
                        prevIndex=currIndex;
                    }
                    else{
                        minDist=Math.min(minDist,currIndex-prevIndex);
                        prevIndex=currIndex;
                    }
            }
            a=b;
            b=c;
            c=c.next;
            currIndex++;
        }
        if(minDist==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        int maxDist=(prevIndex-firstIndex);

        return new int[]{minDist,maxDist};
    }
}