import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // Указываем путь к файлу
        String filePath = "C:\\Users\\Gigabyte\\IdeaProjects\\lab6\\text.txt";

        // Создаем объект File
        File file = new File(filePath);

        // Создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + filePath);
            e.printStackTrace();
            return;
        }

        // Создаем объект Map для хранения слов и их количества
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zа-яё]", "");
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        // Закрываем Scanner
        scanner.close();

        // Создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

        // Сортируем список по убыванию количества повторений
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // Выводим топ-10 слов
        System.out.println("Топ-10 самых часто встречающихся слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue());
        }
    }
}
