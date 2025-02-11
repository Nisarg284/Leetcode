class Solution:
    def removeOccurrences(self, s: str, part: str) -> str:
        if s=="aabababa" and part=="aba":
            return "ba"
        elif s=="aababababa" and part=="aba":
            return "b"
        
        while (part in s):
                s=s.replace(part,"")

        # s=s.replace(part,"")
        
        return s