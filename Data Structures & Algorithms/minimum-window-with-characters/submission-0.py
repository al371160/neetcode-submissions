class Solution:
    def minWindow(self, s: str, t: str) -> str:
        m1 = defaultdict(int)
        m2 = {}


        for i in t:
            m1[i] += 1
        
        m3 = defaultdict(int)

        any_valid = False

        head = 0

        best_head = 0
        best_tail = len(s) - 1
        for index, i in enumerate(s):
            if (i in m1):
                m3[i] += 1
            
            satisfied = True
            for j in m1:
                if m3[j] < m1[j]:
                    satisfied = False
            if satisfied:
                for i in range(head, index):
                    c = s[i]
                    if c in m1:
                        if m3[c] - 1 < m1[c]:
                            break
                        else:
                            m3[c] -= 1
                            head += 1
                    else:
                        head += 1

                if (index - head < best_tail - best_head):
                    best_tail = index
                    best_head = head

                if not any_valid:
                    tail = index
                    any_valid = True
        
        if not any_valid:
            return ""

        return s[best_head:best_tail + 1]
            
            #algo, t gets turned into m1, s we will process
            #first, drag y through the entirety of s or until we match m1
            #fill out chars in m1 in m2
            #next, move up 

        #s = "XXYZ", t = "XYZ"