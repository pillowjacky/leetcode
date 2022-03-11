class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        """
        Hashing
        """
        dict = {}
        for i, num in enumerate(nums):
            delta = target - num
            if delta in dict:
                return [dict[delta], i]
            dict[num] = i
