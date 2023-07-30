import Exceptions.ItemNotFoundException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private static final int DEFAULT_SIZE = 7;
    private static String[] storage;

    public StringListImpl(int size) {
        this.storage = new String[size];
    }

    public StringListImpl() {
        this.storage = new String[DEFAULT_SIZE];
    }

/*
    private String[] extendStorage() {
        return new String[storage.length * 3 / 2 + 1];
    }

 */

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(String item) {
        int itemIndex = size();
        //if (itemIndex = storage.length extendStorage();
        storage[itemIndex] = item;
        return storage[itemIndex];
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(int index, String item) {
        if (index > size() || index < 0)
            throw new ArrayIndexOutOfBoundsException("Указанный индекс выходит за пределы массива");
        shiftRight(index);
        storage[index] = item;
        return item;
    }

    // смещение элементов массива вправо на 1 позицию
    private void shiftRight(int index) {
        if (size() < storage.length) for (int i = size() - 1; i >= index; i--) {
            storage[i + 1] = storage[i];
        }
    }

    // смещение элементов массива влево на 1 позицию
    private void shiftLeft(int index) {
        for (int i = index; i < size(); i++) {
            storage[i] = storage[i + 1];
        }
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Override
    public String set(int index, String item) {
        if (index >= size()) throw new ArrayIndexOutOfBoundsException("Указанный индекс выходит за пределы массива");
        else storage[index] = item;
        return storage[index];
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(String item) {
        if (contains(item)) {
            shiftLeft(indexOf(item));
            return item;
        } else throw new ItemNotFoundException("Указанный элемент не найден");
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    @Override
    public String remove(int index) {
        String itemToRemove;
        if (index >= size() || index < 0)
            throw new ArrayIndexOutOfBoundsException("Указанный индекс выходит за пределы массива");
        else {
            itemToRemove = storage[index];
            shiftLeft(index);
        }
        return itemToRemove;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].equals(item)) return true;
        }
        return false;
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(String item) {
        if (contains(item)) for (int i = 0; i < size(); i++) {
            if (storage[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (contains(item)) for (int i = size() - 1; i >= 0; i--) {
            if (storage[i].equals(item)) return i;
        }
        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    @Override
    public String get(int index) {
        if (index < size()) return storage[index];
        else throw new ArrayIndexOutOfBoundsException("Указанный индекс выходит за пределы массива");
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Override
    public boolean equals(StringList otherList) {
        if (size()!= otherList.size()) return false;
        for (int i = 0; i < size(); i++) {
            if (!storage[i].equals(otherList.get(i))) return false;
        }
        return true;
    }

    @Override
    public int size() {             // Вернуть фактическое количество элементов.
        int size = storage.length;
        for (int i = storage.length - 1; i >= 0; i--) {
            if (storage[i] == null) size--;
            else return size;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        if (size() != 0) {
            Arrays.fill(storage, null);
        }
    }

    @Override
    public String[] toArray() {
        String[] result = new String[size()];
        if (size() >= 0) System.arraycopy(storage, 0, result, 0, size());
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size(); i++) {
            if (storage[i] != null) result = result + storage[i] + " ";
            else return result;
        }
        return result;
    }
}
