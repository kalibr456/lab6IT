import java.util.*;

public class Shop {
    // Класс SoldItem для представления проданного товара
    static class SoldItem {
        private String name;
        private double price;

        public SoldItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Товар: " + name + ", Цена: " + price;
        }
    }

    static class SalesManager {
        private LinkedList<SoldItem> soldItems; // Список проданных товаров

        public SalesManager() {
            soldItems = new LinkedList<>();
        }

        // Добавление проданного товара
        public void addSoldItem(String name, double price) {
            soldItems.add(new SoldItem(name, price));
        }

        // Вывод списка проданных товаров
        public void displaySoldItems() {
            if (soldItems.isEmpty()) {
                System.out.println("Нет проданных товаров.");
            } else {
                System.out.println("Список проданных товаров:");
                for (SoldItem item : soldItems) {
                    System.out.println(item);
                }
            }
        }

        // Подсчет общей суммы продаж
        public double calculateTotalSales() {
            double total = 0;
            for (SoldItem item : soldItems) {
                total += item.getPrice();
            }
            return total;
        }

        // Определение наиболее популярного товара
        public String getMostPopularItem() {
            if (soldItems.isEmpty()) {
                return "Нет проданных товаров.";
            }

            Map<String, Integer> frequencyMap = new HashMap<>();
            for (SoldItem item : soldItems) {
                frequencyMap.put(item.getName(), frequencyMap.getOrDefault(item.getName(), 0) + 1);
            }

            String mostPopularItem = null;
            int maxCount = 0;
            for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
                if (entry.getValue() > maxCount) {
                    mostPopularItem = entry.getKey();
                    maxCount = entry.getValue();
                }
            }

            return mostPopularItem != null ? mostPopularItem : "Нет популярных товаров.";
        }
    }

    // Основной метод программы
    public static void main(String[] args) {
        SalesManager manager = new SalesManager();

        // Добавляем проданные товары
        manager.addSoldItem("Яблоки", 50.0);
        manager.addSoldItem("Хлеб", 30.0);
        manager.addSoldItem("Молоко", 70.0);
        manager.addSoldItem("Яблоки", 50.0);
        manager.addSoldItem("Хлеб", 30.0);
        manager.addSoldItem("Яблоки", 50.0);

        // Выводим список проданных товаров
        manager.displaySoldItems();

        // Подсчитываем общую сумму продаж
        double totalSales = manager.calculateTotalSales();
        System.out.println("Общая сумма продаж: " + totalSales);

        // Находим наиболее популярный товар
        String mostPopularItem = manager.getMostPopularItem();
        System.out.println("Наиболее популярный товар: " + mostPopularItem);
    }
}
