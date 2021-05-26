//Implement stack using array

public class implementstack {
    private int maxSize;
    private int[] stack;
    private int top;

    // construct new stack
    public implementstack(int n) {
        this.maxSize = n;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    public void push(int num) {
        if (!this.isFull()) {
            this.stack[++this.top] = num;
        }
    }

    public int pop() {
        if (!this.isEmpty()) {
            return this.stack[this.top--];
        }

        return -1;
    }

    public int peek() {
        if (!this.isEmpty()) {
            return this.stack[this.top];
        }

        return -1;
    }

    public boolean isFull() {
        return (this.top == this.maxSize - 1);
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }

    public static void main(String[] args) {
        implementstack newStack = new implementstack(5);

        for (int i = 0; i < 5; i++)
            newStack.push(i);

        while (!newStack.isEmpty()) {
            int value = newStack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
    }
}