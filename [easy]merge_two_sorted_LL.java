// This we can solve by iteratvie way i.e, with while loop
// We take an intial New ListNode which its next field points to the start of the merge list
// Additional ListNode which would traverse two lists and merge two pointers into one

// In a while loop we have if or else condition to make the very first connection to the currentNode.next to hold the start variable
// So in the very first if or else block.. we make sure original list is moved to its immediate node after it assigned to the currentNode.next
// So that in next iteration.. if the currentNode.next which is holding list1 may connect to list2 or list2 to list1
// This might break the connection to traverse further..
// Look at the below code to understand better


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {  
    
        ListNode pointerNode = new ListNode(); // PointerNode.next acts as pointer/remember node which holds the next variable acts as start of the merged list
        ListNode currentNode = pointerNode; // currentNode helps to traverse and merge the both list into one.
                                            // Now pointerNode address is hold by the currentNode , as the chaining done by currentNode is indirectly 
                                            // chaining the merged list to the pointerNode's next field.
                                            

        while(list1!=null && list2!=null) { // If any of the list becomes null break
            if(list1.val<list2.val) {      
                currentNode.next = list1;    // if this block executed first.. we make sure 
                currentNode = list1;      
                list1=list1.next;        // the list1 is traversed to its immediate next. If this step is not there.. original list will not move
                                        // we will fall in infintie loop.. so this step helps to stand at very uncovered node and avoid infinite loop
            } else {
                currentNode.next = list2;  // so if currentNode hold list1 may connect to list2. So the above list1 connection may be broken, but
                                            // list1 is already traversed to its next.. holding the next variable to compare
                currentNode = list2;   
                list2=list2.next;   //  list2 is made to its next node because in next iteration currentNode with list2
                                    // might connect to list1.. so if this step is not there.. its an infinite loop

            }
        }

       currentNode.next = (list1!=null)?list1:list2;  // so only one list will be left uncovered and ternanry is helpful in this case

        return pointerNode.next;       
    }
