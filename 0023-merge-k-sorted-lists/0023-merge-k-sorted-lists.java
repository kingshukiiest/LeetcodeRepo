class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k=lists.length;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        for(ListNode head : lists){
            if(head!=null) pq.add(head);
        }
        ListNode dummy= new ListNode();
        ListNode d=dummy;
        while(pq.size()>0){

            ListNode top= pq.poll();
            d.next=top;
            d=d.next;

            if(top.next!=null) pq.add(top.next);
        }
        return dummy.next;
    }
}