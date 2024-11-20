public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10); // Создаем стек на 10 элементов

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());  // Вывод: 3

        System.out.println(stack.peek()); // Вывод: 2

        stack.push(4);

        System.out.println(stack.pop());  // Вывод: 4
    }
    static class Stack<T> {
        private T[] data; // Массив для хранения элементов стека
        private int size; // Текущий размер стека

        public Stack(int capacity) {
            data = (T[]) new Object[capacity]; // Инициализация массива
            size = 0; // Стек изначально пуст
        }

        // Метод для добавления элемента в стек
        public void push(T element) {
            if (size == data.length) {
                throw new StackOverflowError("Стек переполнен");
            }
            data[size++] = element; // Добавляем элемент и увеличиваем размер
        }

        // Метод для удаления элемента из стека
        public T pop() {
            if (size == 0) {
                throw new IllegalStateException("Стек пуст");
            }
            T element = data[--size]; // Уменьшаем размер и извлекаем верхний элемент
            data[size] = null; // Удаляем ссылку на объект для избежания утечки памяти
            return element;
        }

        // Метод для получения верхнего элемента стека без его удаления
        public T peek() {
            if (size == 0) {
                throw new IllegalStateException("Стек пуст");
            }
            return data[size - 1];
        }

        // Метод для проверки, пуст ли стек
        public boolean isEmpty() {
            return size == 0;
        }

        // Метод для получения текущего размера стека
        public int getSize() {
            return size;
        }
    }
}
