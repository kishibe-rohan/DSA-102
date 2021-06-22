//Question Link: https://practice.geeksforgeeks.org/problems/special-stack/1

class minStack{
    int mini = Integer.MAX_VALUE;
    
    //for pushing min, push 2*a - min
	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    if(s.isEmpty())
	    {
	        s.push(a);
	        mini = a;
	    }
	    
	    else if(a >= mini)
	    s.push(a);
	    
	    else
	    {
	        s.push(2*a- mini);
	        mini = a;
	    }
	    
	}
	
	//update min as 2*min - a
	public int pop(Stack<Integer> st)
        {
            //add code here.
            
            if(st.isEmpty())
            return -1;
            
            if(st.peek() >= mini)
            return st.pop();
            
            else
            {
                int a = st.pop();
                int temp = mini;
                mini = 2*mini - a;
                return mini;
            }
	}
	public int min(Stack<Integer> s)
        {
           //add code here.
           if(s.isEmpty())
           return -1;
           
           return mini;
           
	}
	public boolean isFull(Stack<Integer>s, int n)
        {
           //add code here.
           return s.size() >= n;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           //add code here.
           return s.isEmpty();
	}
}