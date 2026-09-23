class Solution {
    public int calPoints(String[] operations) {
        int[] stack = new int[operations.length];
        int index = 0;

        for (String o : operations) {
            switch (o) {
                case "+" :
                    stack[index] = stack[index - 2] + stack[index - 1];
                    index++;
                    break;
                case "D" :
                    stack[index] = stack[index - 1] * 2;
                    index++;
                    break;
                case "C" :
                    index--;
                    stack[index] = 0;
                    break;
                default : 
                    stack[index++] = Integer.parseInt(o);
            }
        }

        int sum = 0;

        for (int val : stack) {
            sum += val;
        }

        return sum;
    }
}