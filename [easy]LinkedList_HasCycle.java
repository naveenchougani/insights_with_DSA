  public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        // floyd algorithm which says if there is cycle..
        // A Fast pointer which moves 2 nodes ,  slow pointer which moves 1 node
        // They would meet if cycle exist.. else fast pointer reaches to null end of list

        // So we stop while if fast node is null, or fast.next = null
    // Becuase if fast=null, we reached end of list , so no cycle
  // Also if fast.next = null.. we stop because , we cannot move to fast.next.next as it thowrs null pointer exception.
  // So once either of any condition fails we stop lopp
  // One if to check if it reached end of list.. another is to check it has atleast next node available to jump
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) 
            return true;
        }
        return false;

       
    }
