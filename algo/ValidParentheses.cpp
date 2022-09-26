class Solution
{
public:
    bool isValid(string s)
    {
        stack<char> stck;

        for (int i = 0; i < s.size(); i++)
        {
            char ch = s[i];
            if (ch == '(' || ch == '{' || ch == '[')
            {
                stck.push(ch);
            }
            else
            {
                if (stck.size() == 0)
                {
                    return false;
                }
                if (ch == ')' && stck.top() == '(')
                {
                    stck.pop();
                }
                else if (ch == '}' && stck.top() == '{')
                {
                    stck.pop();
                }
                else if (ch == ']' && stck.top() == '[')
                {
                    stck.pop();
                }
                else
                {
                    return false;
                }
            }
        }

        return stck.size() == 0;
    }
};