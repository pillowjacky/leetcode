class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        """
        Hashing
        """
        return Counter(s) == Counter(t)
