//Time complexity of push() - O(1) because we are directly pushing into the stack
//Time complexity of pop() - O(1) because we are directly removing the top element
//Time complexity of top() - O(1) because we are directly looking the top element
//Time complexity of getMin() - O(1) we are getting only the top element

//Space complexity - O(n) - because we have n elements in the stack

class MinStack {

    private int[] minStack;
    private int[] stack;
    private int minTop;
    private int top;
    private int capacity;

    public MinStack() {
        capacity = 1000;
        minStack = new int[capacity];
        stack = new int[capacity];
        minTop = -1;
        top = -1;
    }
    
    public void push(int val) {
        if (top == capacity-1) return; 
        stack[++top] = val;

        if (minTop == -1 || val <= minStack[minTop]) {
            minStack[++minTop] = val;
        }

    }
    
    public void pop() {
        if (top < 0) return;
        int val = stack[top--];

        if (val == minStack[minTop]) {
            minTop--;
        }
    }
    
    public int top() {
        if (top < 0) throw new IllegalStateException("Stack is empty");
        return stack[top];
    }
    
    public int getMin() {
        if (minTop < 0) throw new IllegalStateException("Stack is empty");
        return minStack[minTop];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */