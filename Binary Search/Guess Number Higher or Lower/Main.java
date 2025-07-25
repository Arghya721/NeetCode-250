// LeetCode Problem: https://leetcode.com/problems/guess-number-higher-or-lower/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class GuessGame {
    int pick;

    public GuessGame(int pick) {
        this.pick = pick;
    }

    public int guess(int num) {
        if (num < pick) return 1;
        else if (num > pick) return -1;
        else return 0;
    }
}

class Solution extends GuessGame {
    public Solution(int pick) {
        super(pick);
    }

    public int guessNumber(int n) {
        long low = 1, high = n;
        while(low <= high){
            int mid = (int)((low + high) / 2);
            int result = guess(mid);
            if(result == 0)
                return mid;
            if(result == 1)
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution(6);
        int result = solution.guessNumber(10);
        System.out.println("Guessed number: " + result);
    }
}
