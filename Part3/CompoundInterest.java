public class CompoundInterest {
    public static void main(String[] args) {
        final double STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;

        double[] interestRate = new double[NRATES];
        for (int j = 0; j < interestRate.length; j++) {
            interestRate[j] = (STARTRATE + j) / 100.0;
        }

        double[][] balances = new double[NYEARS][NRATES];

        for (int j = 0; j < balances[0].length; j++) {
            balances[0][j] = 10000;
        }

        for (int i = 1; i < balances[i].length; i++) {
            for (int j = 0; j < balances[i].length; j++) {
                double oldBalance = balances[i - 1][j];
                double interest = oldBalance * interestRate[j];
                balances[i][j] = oldBalance + interest;
            }
        }

        for (int j = 0; j < interestRate.length; j++) {
            System.out.printf("%9.0f%%", 100 * interestRate[j]);
        }

        System.out.println();

        /* 这里用到了Java中的for each循环结构，
         * 可以理解为增强型的for循环，
         * 其使用方法如下：
         *     for (variable : collection) statement
         *     定义一个变量用于暂时寄存集合中的每一个元素，
         *     并执行相应的语句（也可以是语句块）。
         *     collection这一集合表达式必须是一个数组，
         *     或者是一个实现了Iterable接口的类对象（比如ArrayList）
         */
        for (double[] row : balances) {
            for (double b : row) {
                System.out.printf("%10.2f", b);
            }
            System.out.println();
        }
    }
}


