package DP;
public class GuessNumberHigherOrLower {
//        666. Guess Number Higher or Lower II
//        We are playing the Guess Game. The game is as follows:
//        I pick a number from 1 to n. You have to guess which number I picked.
//        Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
//        However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
//
//        Example
//        Given n = 10, I pick 8.
//        First round: You guess 5, I tell you that it's higher. You pay $5.
//        Second round: You guess 7, I tell you that it's higher. You pay $7.
//        Third round: You guess 9, I tell you that it's lower. You pay $9.
//
//        Game over. 8 is the number I picked.
//        You end up paying $5 + $7 + $9 = $21.
//
//        Given a particular n ? 1, find out how much money you need to have to guarantee a win.
//        So when n = ?10, return16`
    /**
     * @param n: An integer
     * @return: how much money you need to have to guarantee a win
     */
    public int getMoneyAmount(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return cost(1, n, memo);
    }

    private int cost(int start, int end, int[][] memo) {
        if (start >= end) {
            return 0;
        }
        if (memo[start][end] > 0) {
            return memo[start][end];
        }
        int cost = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            // TODO: formula is cost[i][j] = min(cost[i][j], max(k + cost[i][k - 1], cost[k + 1][j])), f(cost) means the maximum cost from i to j
            cost = Math.min(cost, i + Math.max(cost(start, i - 1, memo), cost(i + 1, end, memo)));
        }
        return memo[start][end] = cost;
    }
}
