class Solution {
    
public:
    int findKthLargest(vector<int>& nums, int k) {
        k = nums.size()-k;
        return partition(nums, k, 0, nums.size()-1);
    }

private:
    int partition(vector<int>& nums, int k, int l, int r) {
        int pivot = nums[r];
        int p = 0;
        for (int i=0; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums[i], nums[p++]);
            }
        }
        swap(nums[r], nums[p]);
        if (k > p) {
            return partition(nums, k, p+1, r);
        } else if (k < p) {
            return partition(nums, k, l, p-1);
        } else {
            return nums[p];
        }
    }    
};