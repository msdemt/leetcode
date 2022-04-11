package 初级算法;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
 * <p>
 * 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
 * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润。
 */
public class test002_买卖股票的最佳时机Ⅱ {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit2(prices);
        System.out.println("maxProfit: " + maxProfit);
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        //初始条件
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < length; i++) {
            //递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候，利润才会最大，
        //只需返回 dp[length-1][0] 即可
        return dp[length - 1][0];
    }

    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        //初始条件
        int hold = -prices[0]; //持有股票
        int noHold = 0; //没持有股票
        for (int i = 1; i < length; i++) {
            //递推公式转换
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候利润才会最大，
        //所以这里返回的是noHold
        return noHold;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int total = 0, index = 0, length = prices.length;
        while (index < length) {
            //如果股票下跌就一直找，直到找到股票开始上涨为止
            while (index < length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            //股票上涨开始的值，也就是这段时间上涨的最小值
            int min = prices[index];
            //一直找到股票上涨的最大值为止
            while (index < length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }
            //计算这段上涨时间的差值，然后累加
            total += prices[index++] - min;
        }
        return total;
    }
}
