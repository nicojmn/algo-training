// https://leetcode.com/problems/two-sum/description/

#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
  public:
    vector<int> twoSum(vector<int> &nums, int target) {
        unordered_map<int, int> hashmap;
        for (size_t i = 0; i < nums.size(); i++) {
            hashmap[nums[i]] = i;
        }

        for (int i = 0; i < nums.size(); i++) {
            int comp = target - nums[i];
            if (hashmap.find(comp) != hashmap.end() && hashmap[comp] != i) {
                return vector<int>{i, hashmap[comp]};
            }
        }

        return vector<int>{};
    }
};

int main() { return 0; }