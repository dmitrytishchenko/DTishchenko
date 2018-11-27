package ru.job4j.search;

        import com.sun.deploy.util.ArrayUtil;

        import java.util.ArrayList;
        import java.util.List;

public class CoffeeMashine {
    /*
        * реализовать метод выдачи сдачи из автомата
        * @param value купюра может быть 50, 100 и т.д.
        * @param price цена кофе
        * @return целочисленный массив в качестве сдачи
        */
    public int[] changes(int value, int price) {
        int[] coins = {1, 2, 5, 10};
        List<Integer> list = new ArrayList<>();
        int delivery = value - price;
        int i = coins.length - 1;
        while (delivery > 0) {
            while (delivery >= coins[i]) {
                list.add(coins[i]);
                delivery -= coins[i];
            }
            i--;
        }
        int[] result = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
        return result;
    }
}
