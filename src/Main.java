import Model.IntegerList;
import Model.IntegerListImpl;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Integer[] DEFAULT_ARRAY = new Integer[]{66, 44, 33, 11, 55, 22};
    private static final Integer[] OTHER_ARRAY = new Integer[]{101, 202, 303, 404, 505, 606};
    private static final int amount = 10;

    public static void main(String[] args) {
        IntegerList integerList = new IntegerListImpl(10);
        Integer[] sampleArray = generate(amount);
        Integer[] testArray1 = Arrays.copyOf(sampleArray, amount);
        Integer[] testArray2 = Arrays.copyOf(sampleArray, amount);
        Integer[] testArray3 = Arrays.copyOf(sampleArray, amount);

        System.out.println("Весь массив sampleArray: " + Arrays.toString(sampleArray));

        System.out.print("Пузырьковая сортировка: ");
        long start = System.currentTimeMillis();
        integerList.sortBubble(testArray1);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("Сортировка выбором");
        start = System.currentTimeMillis();
        integerList.sortSelection(testArray2);
        System.out.println(System.currentTimeMillis() - start);

        System.out.println("Сортировка вставкой");
        start = System.currentTimeMillis();
        integerList.sortInsertion(testArray3);
        System.out.println(System.currentTimeMillis() - start);

    }

    public static Integer[] generate(int amount) {
        Random random = new Random();
        Integer[] result = new Integer[amount];
        for (int i = 0; i < amount; i++) {
            result[i] = random.nextInt(amount);
        }
        return result;
    }
}
