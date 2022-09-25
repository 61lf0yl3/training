class MinStack
{
public:
    MinStack()
    {
    }

    void push(int val)
    {
        if (stack.empty() || val < stack.top().second)
        {
            stack.push({val, val});
        }
        else
        {
            stack.push({val, stack.top().second});
        }
    }

    void pop()
    {
        stack.pop();
    }

    int top()
    {
        return stack.top().first;
    }

    int getMin()
    {
        return stack.top().second;
    }

private:
    // val and min;
    stack<pair<int, int> > stack;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */