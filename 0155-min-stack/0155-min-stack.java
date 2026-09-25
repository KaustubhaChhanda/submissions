class MinStack {
    private Node head;

    public MinStack() {
            
    }
    
    public void push(int value) {
        if (head == null) {
            head = new Node(value, value);
        } else {
            Node temp = new Node(value, Math.min(value, head.min));
            temp.next = head;
            head = temp;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    class Node {
        int val;
        int min;
        Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */