import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Level1 {
    public static int MaximumDiscount(int n, int[] price) {
        if (n < 3) return 0;

        int[] sortedPrice = new int[n];

        System.arraycopy(price, 0, sortedPrice, 0, price.length);

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < n - 1; i++) {
                if (sortedPrice[i + 1] > sortedPrice[i]) {
                    int x = sortedPrice[i];

                    sortedPrice[i] = sortedPrice[i + 1];
                    sortedPrice[i + 1] = x;

                    isSorted = false;
                }
            }
        }

        // считаем максимальную скидку (каждый 3 товар бесплатно)
        int discount = 0;
        for (int i = 2; i < n; i += 3) {
            discount += sortedPrice[i];
        }

        return discount;
    }
}
