/*
 * TC: O(n)
 * SC: O(1)
 */
public class ShortestWayString {
    public int shortestWay(String source, String target) {
        // exists array is just to be able to
        // quickly check if a char exists in source
        boolean[] exists = new boolean[128];
        for(char c: source.toCharArray()) {
            exists[c] = true;
        }
        int count = 0;
        // i is index into target,
        // j is index into source
        int i = 0, j = 0;
        while(i < target.length()) {
            char t = target.charAt(i);
            // if char not in source, the target
            // string cannot be constructed at all
            if(!exists[t]) return -1;
            // if the char exists in source increment i
            if(t == source.charAt(j)) {
                i++;
            }
            // always increment j, even if not a match
            j++;
            // if j has hit the source length, we have
            // found a subsequence. increment count and reset j
            if(j == source.length()) {
                count++;
                j = 0;
            }

        }
        // if j == 0 it was reset at the end of the loop
        // so count is correct. else return count + 1
        return j == 0 ? count : count + 1;
    }
}
