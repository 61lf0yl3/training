class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        int res = nums[0];
        int low = 0;
        int high = nums.size() - 1;

        while (low <= high)
        {
            // if (nums[low] < nums[high]) {
            //     return nums[low];
            // }
            int mid = low + (high - low) / 2;
            res = min(res, nums[mid]);

            // if mid is in left sorted part
            if (nums[0] <= nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                // if mid is in right sorted part
                high = mid - 1;
            }
        }
        return res;
    }
};