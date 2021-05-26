//Implement 2 stacks using one array

/* Structure of the class is
class TwoStack
{

	int size;
	int top1,top2;
	int arr[] = new int[100];

	TwoStack()
	{
		size = 100;
		top1 = -1;     //s1 grows to the right from index 0
		top2 = size;   //s2 grows to the left from last index of array
	}
}*/

public class implement2stacks {
    // Function to push an integer into the stack1.
    void push1(int x, TwoStack sq) {
        if (sq.top1 < sq.top2 - 1) {
            sq.top1++;
            sq.arr[sq.top1] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }
    }

    // Function to push an integer into the stack2.
    void push2(int x, TwoStack sq) {
        if (sq.top1 < sq.top2 - 1) {
            sq.top2--;
            sq.arr[sq.top2] = x;
        } else {
            System.out.println("Stack Overflow");
            System.exit(1);
        }

    }

    // Function to remove an element from top of the stack1.
    int pop1(TwoStack sq) {
        if (sq.top1 >= 0) {
            int x = sq.arr[sq.top1];
            sq.top1--;
            return x;
        } else {
            return -1;
        }
    }

    // Function to remove an element from top of the stack2.
    int pop2(TwoStack sq) {
        if (sq.top2 < sq.size) {
            int x = sq.arr[sq.top2];
            sq.top2++;
            return x;
        } else {
            return -1;
        }
    }
}
