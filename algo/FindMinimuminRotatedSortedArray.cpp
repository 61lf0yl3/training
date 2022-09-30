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

public:
    int findMin(vector<int> &nums)
    {
        int low = 0;
        int high = nums.size() - 1;

        // not low <= high since not searching for target
        while (low < high)
        {
            int mid = low + (high - low) / 2;
            // ex. [3,4,5,6,7,8,9,1,2], mid = 4, high = 8
            // nums[mid] > nums[high], min must be right
            if (nums[mid] > nums[high])
            {
                // never consider mid bc know for sure not min
                low = mid + 1;
                // ex. [8,9,1,2,3,4,5,6,7], mid = 4, high = 8
                // nums[mid] <= nums[right], min must be left
            }
            else
            {
                // consider mid still bc could be min
                high = mid;
            }
        }

        // low lands on correct value, never disqualified mins
        return nums[low];
    }
};