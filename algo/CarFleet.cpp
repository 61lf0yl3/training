class Solution
{
public:
    int carFleet(int target, vector<int> &position, vector<int> &speed)
    {
        vector<pair<int, int> > combined;
        for (int i = 0; i < position.size(); i++)
        {
            combined.push_back({position[i], speed[i]});
        }
        sort(combined.begin(), combined.end());
        stack<double> stack;
        for (int i = position.size() - 1; i >= 0; i--)
        {
            double time = (double)(target - combined[i].first) / combined[i].second;
            if (stack.empty() || time > stack.top())
            {
                stack.push(time);
            }
        }
        return stack.size();
    }
};