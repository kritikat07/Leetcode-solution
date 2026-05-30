/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> sorted =new ArrayList<>();
        for(ListNode node:lists){
            while(node!=null){
                sorted.add(node.val);
                node=node.next;
            }
        }
        Collections.sort(sorted);
        ListNode dummy =new ListNode(0);
        ListNode curr=dummy;
        for(int val:sorted){
            ListNode newnode=new ListNode(val);
            curr.next=newnode;
            curr=curr.next;
        }
        return dummy.next;
    }
}