public class Level1 {
    public static int MaximumDiscount(int n, int[] price) {
        if (n < 3) return 0;

        int[] ma = new int[n];

        for (int i = 0; i < n; i++) {
            ma[i] = price[i];
        }

        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < n - 1; i++) {
                if (ma[i + 1] > ma[i]) {
                    int x = ma[i];

                    ma[i] = ma[i + 1];
                    ma[i + 1] = x;

                    flag = true;
                }
            }
        }

        int discount = 0;

        for (int i = 2; i < n; i += 3) {
            discount += ma[i];
        }

        return discount;
    }
}
