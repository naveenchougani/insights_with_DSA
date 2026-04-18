// min stack means you have to get the minimum element in the stack when getMin() is called
// By the nature of Stack it can only return last in First out.. but how to make it
// Regular stack to have elements, along with that.. another stack which just keeps only minimum elements

class MinStack {
    Deque<Integer> mainStack;
    Deque<Integer> minStack;

    public MinStack() {
         mainStack=new ArrayDeque<>();
         minStack =new ArrayDeque<>();
    }
    
    public void push(int val) {
        this.mainStack.push(val);

        if(minStack.isEmpty() || val<=minStack.peek())  // yeah current value <= existing value include it
            minStack.push(val);

    }
    
    public void pop() {
        if(minStack.peek()==mainStack.peek())  // while deleting elements make sure if it present in min stack
            minStack.pop();  // delete from it also to have a sync between them
        
        mainStack.pop();
    }
    
    public int top() {
        return this.mainStack.peek();  // return from main stack
    }
    
    public int getMin() {
       return this.minStack.peek(); // return from minstack
    }
}
