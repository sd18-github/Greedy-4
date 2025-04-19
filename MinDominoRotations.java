/*
 * TC: O(n)
 * SC: O(1)
 */
public class MinDominoRotations {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topCount = new int[7];
        int[] bottomCount = new int[7];
        int[] equal = new int[7];
        int n = bottoms.length;
        // get counts of each number (1-6) as well as
        // number of times tops[i] == bottoms[i] for each number
        for(int i = 0; i < n; i++) {
            topCount[tops[i]]++;
            bottomCount[bottoms[i]]++;
            if(tops[i] == bottoms[i]) equal[tops[i]]++;
        }
        // if for a particular number topCount + bottomCount - equalCount = number of dominoes
        // that is a target number. minRotations = min(topCount, bottomCount) - equalCount
        for(int j = 1; j < 7; j++) {
            if(topCount[j] + bottomCount[j] - equal[j] == n) {
                return Math.min(topCount[j], bottomCount[j]) - equal[j];
            }
        }
        // if not found return -1
        return -1;
    }
}
