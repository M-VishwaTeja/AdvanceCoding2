class Solution {
    public int longestDecomposition(String text) {
        int count = 0;
        for (int start = 0, end = text.length() - 1; start <= end;) {
            boolean foundMatchingPart = false;

            for (int k = 1; start + k - 1 < end - k + 1; ++k) {
                if (isMatchingPart(text, start, end - k + 1, k)) {
                    count += 2;
                    start += k;
                    end -= k;  
                    foundMatchingPart = true;
                    break; 
                }
            }
            if (!foundMatchingPart) {
                count++; 
                break;
            }
        }
        return count; 
    }
    private boolean isMatchingPart(String s, int start, int end, int k) {
        while (k-- > 0) {
            if (s.charAt(start++) != s.charAt(end++)) {
                return false;
            }
        }
        return true;
    }
}
