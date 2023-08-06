package Model;

import Exceptions.StorageIsFullException;
import Exceptions.NullItemException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private static final int DEFAULT_SIZE = 17;

    private static Integer[] storage;
    private static int actualSize;

    public IntegerListImpl(int size) {
        this.storage = new Integer[size];
    }

    public IntegerListImpl() {
        this.storage = new Integer[DEFAULT_SIZE];
    }

/*
    private Integer[] extendStorage() {
        return new String[storage.length * 3 / 2 + 1];
    }
 */

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        //if (itemIndex = storage.length extendStorage();
        storage[actualSize] = item;
        actualSize++;
        return storage[actualSize - 1];
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == actualSize) add(item);
        else {
            System.arraycopy(storage, index, storage, index + 1, actualSize - index);
            storage[index] = item;
            actualSize++;
        }
        return storage[index];
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return storage[index];
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];
        if (index != actualSize) System.arraycopy(storage, index+1, storage, index, actualSize - index);
        actualSize--;
        return item;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    @Override
    public boolean contains(Integer item) {
        Integer[] copy = toArray();
        sortInsertion(copy);
        return binarySearch(copy, item);
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < actualSize; i++) {
            if (storage[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = actualSize - 1; i >= 0; i--) {
            if (storage[i].equals(item)) return i;
        }
        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {             // Вернуть фактическое количество элементов.
        return actualSize;
    }

    @Override
    public boolean isEmpty() {
        return actualSize == 0;
    }

    @Override
    public void clear() {
        actualSize = 0;
        Arrays.fill(storage, null);
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, actualSize);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < actualSize; i++) {
            if (storage[i] != null) result = result + storage[i] + " ";
            else return result;
        }
        return result;
    }

    private void validateItem(Integer item) {
        if (item == null) throw new NullItemException("Значение элемента не должно быть null");
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= actualSize)
            throw new ArrayIndexOutOfBoundsException("Заданный индекс выходит за пределы массива");
    }

    private void validateSize() {
        if (actualSize == storage.length) throw new StorageIsFullException("Массив заполнен");
    }

    // метод по перемещению элементов местами
    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    @Override
    // Пузырьковая сортировка
    public void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    @Override
    // Сортировка выбором
    public void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    @Override
    // Сортировка вставкой
    public void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    // Линейный поиск
    public boolean linearSearch(Integer[] arr, int element) {
        for (int i : arr) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    // Бинарный поиск
    public boolean binarySearch(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
