class Solution
{
public:
    int evalRPN(vector<string> &tokens)
    {
        stack<long long int> stack;
        for (int i = 0; i < tokens.size(); i++)
        {
            string ch = tokens[i];
            if (ch.size() > 1 || isdigit(ch[0]))
            {
                stack.push(stoi(ch));
            }
            else
            {

                long long int num2 = stack.top();
                stack.pop();
                long long int num1 = stack.top();
                stack.pop();

                if (ch[0] == '*')
                {
                    stack.push(num1 * num2);
                }
                else if (ch[0] == '+')
                {
                    stack.push(num1 + num2);
                }
                else if (ch[0] == '-')
                {
                    stack.push(num1 - num2);
                }
                else if (ch[0] == '/')
                {
                    stack.push(num1 / num2);
                }
            }
        }
        return stack.top();
    }
};