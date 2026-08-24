class Solution {
    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (isPalindrome(s, i, j)) {
                    String sub = s.substring(i, j + 1);
                    if (sub.length() > result.length()) {
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
