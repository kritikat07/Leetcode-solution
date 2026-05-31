class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        while (!map.isEmpty()) {
            int first = map.firstKey();
            int freq = map.get(first);
            for (int i = 0; i < groupSize; i++) {
                int card = first + i;
                if (!map.containsKey(card) || map.get(card) < freq) {
                    return false;
                }
                map.put(card, map.get(card) - freq);
                if (map.get(card) == 0) {
                    map.remove(card);
                }
            }
        }
        return true;
    }
}