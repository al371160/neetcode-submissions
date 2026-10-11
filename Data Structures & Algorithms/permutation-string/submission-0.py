class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        l = 0;
        m1 = {}
        m2 = {}
        for i in range(len(s1)):
            m1[s1[i]] = m1.get(s1[i], 0) + 1
        for r in range(len(s2)):
            if r - l + 1 > len(s1):
                m2[s2[l]] = m2.get(s2[l], 0) - 1
                if m2.get(s2[l]) == 0:
                    m2.pop(s2[l])
                l += 1
            m2[s2[r]] = m2.get(s2[r], 0) + 1
            if m1 == m2:
                return True
        return False
            