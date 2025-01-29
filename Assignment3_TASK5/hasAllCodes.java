 class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            seen.add(substring);
            if (seen.size() == (1 << k)) {
                return true;
            }
        }
        return seen.size() == (1 << k);
    }
}
