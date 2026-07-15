class MinStack {
    Stack<Long> st;
    long min;
    
    public MinStack() {
        st= new Stack<>();
        min=-1;
    }
    
    public void push(int value) {
        if(st.size()==0){
            min=value;
            st.push((long)value);
        }
        else if(value >= min){
            st.push((long)value);
        }
        else{
            long newVal=(2L*value)-min;
        // int val= value+ (value-min)
        //WE ARE INSERTING A SMALLER NUMBER THAN OUR MINIMUM
            st.push(newVal);
            min=value;
        } 
    }
    
    public void pop() {
        if(st.peek() < min){
            min=(2*min)-st.peek();
        }
        //DONT CARE IF IT IS EQUAL
        st.pop();
    }
    
    public int top() {
        long peek=st.peek();

        if(peek >= min ){
            return (int)peek;
        }
        else{
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int) min;
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