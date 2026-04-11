// To reverse a single linked list assume it is always equal to the swapping two numbers.
// Assume when ever you break currentNode.next=null, 
                    you must set it currentNode.next = previousNode to reverse it..
                      But how can you move to the next node after currentNode... simple By storing its address before breaking
                        i.e, nextNode = currentNode.next;
                             currentNode.next = previousNode;

                    Great but how would you make sure swapping happens.
                    In LinkedList always last node should point to null to make sure it ends.. So Now assume previous Node starts with null and will assign it to the head.next
                    i.e, currentNode = head, previousNode = null , nextNode = null ;
                          while(currentNode!=null) {
                            nextNode = currentNode.next; ---> pointer to move forward
                            currentNode.next = previousNode; ---> previous node with null values starts assigning to head., currentNode and it also moves forward
                            previousNode = currentNode ; -----> Now previous node comes from null to currentNode to progress forward, as currentNode moves to nextNode
                            currentNode = nextNode ; --> after assing its value to previousNode to not break chain , then currentNode moves to nextNode 
                          }
                    // The main caveat is 
                    // CurrentNode starting from head always progress one node forward.
                    // Before forwarding.. it stores its next destination in another node to jump once it breaks connection
                    // It breaks its connection by assigning it next node to a previousNode which always holds its predecessor node
                    // That previous node will be moved to currentNode to become immediate predecessor once currentNode moves to next Node
                    //  Now at this position connection is reversed, so currentNode moves to next by assigning next node and follows the same procedure

                    // By the time currentNode becomes null, previous node is at last position and no link between previous node and current
                    // That only happens during the loop, once loop completed.. currentNode and NextNode will be at same position and disconnected from previous node
                    // So return previous Node 


// Solution

ListNode currNode=head, prevNode=null,nextNode=null;
        while(currNode!=null){
            nextNode=currNode.next;
            currNode.next=prevNode;
            prevNode=currNode;
            currNode=nextNode;
        }

        return prevNode;
