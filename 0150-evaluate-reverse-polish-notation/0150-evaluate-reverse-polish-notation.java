class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens) {
            switch (t) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    int second = stack.pop();
                    int first = stack.pop();
                    stack.push(first - second);
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;

                default:
                    stack.push(Integer.valueOf(t));
            }
        }

        return stack.pop();
    }
}