class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int required = need.size();  
        int formed = 0;              
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int[] result = {-1, 0, 0};  // {window length, left, right}
  for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            have.put(c, have.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && have.get(c).equals(need.get(c))) {
                formed++;
            }
            while (formed == required) {
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    result[0] = windowLen;
                    result[1] = left;
                    result[2] = right;
                }
                char leftChar = s.charAt(left);
                have.put(leftChar, have.get(leftChar) - 1);
                if (need.containsKey(leftChar) && have.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
    