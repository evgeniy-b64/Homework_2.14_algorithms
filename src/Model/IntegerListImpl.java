package Model;

import Exceptions.StorageIsFullException;
import Exceptions.NullItemException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private static final int DEFAULT_SIZE = 17;
    private static Integer[] storage;
    private static int actualSize;

    public IntegerListImpl(int size) {
        storage = new Integer[size];
    }

    public IntegerListImpl() {
        storage = new Integer[DEFAULT_SIZE];
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
        return indexOf(item) != -1;
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
}
