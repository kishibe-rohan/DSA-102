//Implement k stacks in a single array efficiently
//Naive approach : Divide the array into 'k' slots,1 slot for each stack
//Optimisation: Use auxillary arrays to maintain top indices of each stack,next empty slot

public static class implementkstacks {
    int arr[]; // array of size n to store the elements
    int top[]; // array of size k to store indices of top elements of each stack
    int next[]; // array of size n to store next entry in all stacks

    int n, k;
    int free; // beginning of free list

    implementkstacks(int k, int n) {
        this.k = k;
        this.n = n;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // Initialize all stacks as empty
        for (int i = 0; i < k; i++)
            top[i] = -1;

        // Initialize all spaces as free
        free = 0;
        for (int i = 0; i < n - 1; i++)
            next[i] = i + 1;

        next[n - 1] = -1;

    }

    boolean isFull() {
        return (free == -1);
    }

    boolean isEmpty(int sn) {
        return (top[sn] == -1);
    }

    // push item x in stack number sn
    void push(int x, int sn) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        int index = free; // get the free slot to insert this element;

        free = next[index]; // update index of free slot to next of this index

        // update next of top and top index for this stack number
        next[index] = top[sn];
        top[sn] = i;

        arr[index] = x; // push element to stack
    }

    // pop element from stack number sn
    int pop(int sn) {
        if (isEmpty(sn)) {
            System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;
        }

        // Find top index of the stack
        int index = top[sn];

        top[sn] = next[index]; // update top index of this stack

        // update next and free
        next[index] = free;
        free = index;

        // return the element
        return arr[i];
    }

}
