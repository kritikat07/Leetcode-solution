class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        int maxCount = 0;
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                maxCount++;
            }
        }
        int res = (maxFreq - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, res);
    }
}
    