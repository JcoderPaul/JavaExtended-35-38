package Less_36_ch_1_Scanner;
/*
Задача:
Из файла получить текст и разбить его на слова.
Подсчитать слов всего и оригинальных слов в тексте.
*/
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Less_36_Scanner_Step5 {
    public static void main(String[] args) {
        Scanner myScan = null;
        // Создаем сет, который хранит только оригинальные элементы
        Set<String> mySet = new TreeSet<>();
        // Для размещения всех слов текста применим обычный список
        List<String> verse_word = new ArrayList<>();
        try {
            // Передаем в сканер файл
            myScan = new Scanner(new FileReader(
                    new File("src\\Less_36_ch_1_Scanner\\MyFiles\\verse.txt").getAbsolutePath()));
            // Передаем в сканер правило по которому будем делить наш текст
            myScan.useDelimiter("[\\s\\,\\-\\.«»]");
            // Пока в тексте есть хотя бы один символ цикл работает
            while (myScan.hasNext()) {
                // Выделяем слово и помещаем его и в коллекцию и в список
                String single_word = myScan.next();
                verse_word.add(single_word);
                mySet.add(single_word);
            }
        } catch (IOException ex){
            ex.printStackTrace();
            ex.getMessage();
        } finally {
            // Закрываем сканер
            myScan.close();
        }
        for (String word_prn:mySet) {
            System.out.println(word_prn);
        }
        // Выводим размер списка и коллекции
        System.out.println("Количество слов в стихе -> " + verse_word.size());
        System.out.println("Количество оригинальных слов -> " + mySet.size());
    }
}