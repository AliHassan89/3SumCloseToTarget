/*

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers.

Assume that there will only be one solution

Example:
given array S = {-1 2 1 -4},
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

Solution is in O(n^2)

 */

package main.java;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosestToTargetFinder {

    public int threeSumClosest(ArrayList<Integer> list, int target) {
        if (list.size() < 3)
            return 0;

        Collections.sort(list);
        int closest = Integer.MAX_VALUE;;
        int sum;
        int result = 0;

        for (int i=0; i<list.size(); i++) {
            int j = i+1;
            int k = list.size() - 1;
            while (j < k) {
                sum = list.get(i) + list.get(j) + list.get(k);
                int diff = Math.abs(target - sum);

                if (diff == 0)
                    return sum;

                if (diff < closest) {
                    closest = diff;
                    result = sum;
                }
                else if (sum <= target) {
                    ++j;
                }
                else if (sum > target) {
                    --k;
                }
                else {
                    ++i;
                    j = i+1;
                }
            }
        }

        return result;
    }

}
