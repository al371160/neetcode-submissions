class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        ret = 0
        l = 0
        #tail = 0
        maxf = 0
        curr = 0
        count = {}

    # how to make sure majority element is preserved? we only need to calculate # majority & non-majority element, or maybe do some bs with hashmaps. 
    # set the first element as majority and go until # transformations is reached

        for r in range(len(s)):
            count[s[r]] = count.get(s[r], 0) + 1
            maxf = max(maxf, count[s[r]])
            while r - l + 1 > maxf + k:
                count[s[l]] -= 1
                l += 1
                #move head, delete what's on head from hashmap
                #if freq = map.get(char)...
                # guess what, we don't need to do this!!! (...??)
                # maxf doesn't have to be decremented, only case where
                # there is a better string is if there's a better maxf.
            ret = max(ret, r - l + 1)
        
        return ret
                


