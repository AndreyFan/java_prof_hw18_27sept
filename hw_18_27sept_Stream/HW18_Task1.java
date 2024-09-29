package de.telran.hw_18_27sept_Stream;

import java.util.*;
import java.util.stream.Collectors;

public class HW18_Task1 {
   //   1 уровень сложности: Stream 1:

public static void main(String[] args) {
    //Задание 1: Фильтрация списка целых чисел на нечетные числа
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 17, 45, 4, 16, 78, 94, 43, 4, 5, 7, 8));
    System.out.println("исходный список list:   " + list);
    List<Integer> listOdd = list.stream()
            .filter(x -> x % 2 != 0)
            .toList();

    System.out.println("только нечетные из исходного списка :   " + listOdd);

//Задание 2: Преобразование списка строк в список чисел
    System.out.println();
    System.out.println("---------------2 Преобразование списка строк в список чисел--------------");
    List<String> listStr = new ArrayList<>(Arrays.asList("1", "2", "3", "17", "45", "4", "16", "78", "94", "43", "4", "5", "7", "8"));
    List<Integer> integerList = listStr.stream()
            .map(Integer::parseInt)
            .toList();
    System.out.println("исходный список строк" + listStr);
    System.out.println("список чисел:  " + integerList);
    System.out.println();

    //Задание 3: Суммирование списка чисел
    System.out.println("----------- 3: Суммирование списка чисел-----------------");
    int sum = list.stream()
            .mapToInt(Integer::intValue) // Преобразование элементов в int
            .sum();
    System.out.println("исходный список list:   " + list);
    System.out.println("сумма всех чисел списка=  " + sum);
    System.out.println();

    //Задание 4: Определение максимального значения в списке
    System.out.println("----------- 4: Определение максимального значения в списке -----------------");
    Optional<Integer> max = list.stream()
            .max(Integer::compareTo);
    System.out.println("исходный список list:   " + list);
    // Вывод результата
    if (max.isPresent()) {
        System.out.println("Максимальное значение список list: " + max.get());
    } else {
        System.out.println("Список пуст");
    }
    System.out.println();

    //Задание 5: Фильтрация списка строк на те, которые начинаются с
    // определенной буквы и преобразование их в верхний регистр
    System.out.println("----------- 5: Фильтрация списка строк -----------------");
    List<String> listString = new ArrayList<>(Arrays.asList("Olga", "Ivan", "Oksana", "Oleg", "Oksana", "Maxim"));

    List<String> listString_task5 = listString.stream()
            .filter(x -> x.startsWith("i") || x.startsWith("I")) // Фильтрация по начальной букве
            .map(String::toUpperCase)
            .toList();

    System.out.println("исходный список:  " + listString);
    System.out.println(" список строк на букву (I,i) преобразованные в верхний регистр:  " + listString_task5);
    System.out.println();

    //Задание 6: Получение списка уникальных слов из списка строк, длина которых больше 4 символов
    System.out.println("----------- 6: Получение списка уникальных слов из списка строк, длина к-х больше 4 символов -----------------");
    Set<String> listString_task6 = listString.stream()
            .filter(x -> x.length() > 4) // Фильтрация по количеству букв
            .collect(Collectors.toSet()); // При сборе в сет дубликаты будут удалены

    System.out.println("исходный список:  " + listString);
    System.out.println(" список уникальных слов из списка строк, длина которых больше 4 символов  " + listString_task6);
    System.out.println();

//Задание 7:Преобразование списка объектов класса в список их имен, отсортированных по возрасту ------
    // для этой задачи создаём класс HumanStream1 и несколько объектов этого класса
    System.out.println("----------- 7:Преобразование списка объектов класса в список их имен, отсортированных по возрасту -----------------");
    List<HumanStream1> humanStream1s = new ArrayList<>(Arrays.asList(
            new HumanStream1("Oleg", 65),
            new HumanStream1("Olga", 26),  // по идее станет первой
            new HumanStream1("Ivan", 45),
            new HumanStream1("Anna", 32),
            new HumanStream1("Pavel", 77))); // станет последним после сортировки

    List<String> list7 = humanStream1s.stream()
            .sorted(Comparator.comparing(x -> x.age)) // сортировка по возрасту
            .map(x -> x.name)  // извлечение имен
            .collect(Collectors.toList());
    System.out.println("исходный список объектов:  " + humanStream1s);
    System.out.println("список имен объектов, отсортированных по возрасту" + list7);
    System.out.println();

    //Задание 8:Нахождение суммы чисел, кратных 3 и 5, из списка чисел -------
    // в качестве источника будем исп-ть список4 к заданию 1
    // list (1,2,3,17,45,4,16,78,94,43,4,5,7,8)

    System.out.println("----------- 8:Нахождение суммы чисел, кратных 3 и 5, из списка чисел -----------------");

    int sum8 = list.stream()
            .filter(x -> x % 3 == 0 || x % 5 == 0) // отфильтруем эл-ты кратные 3 и 5 (не одновременно !!!)
            .mapToInt(Integer::intValue) // Преобразование элементов в int
            .sum();

    System.out.println("исходный список:  " + list);
    System.out.println("сумма чисел, кратных 3 и 5, из списка чисел:  " + sum8);
    System.out.println();

    //Задание 9:Получение списка слов, содержащих только уникальные символы, из списка строк
    System.out.println("----------- 9:Получение списка слов, содержащих только уникальные символы, из списка строк -----------------");
// воспользуемся списком из задания 5 listString ("Olga","Ivan", "Oksana", "Oleg", "Oksana", "Maxim")

    // Получение списка слов, содержащих только уникальные символы
    List<String> list9 = listString.stream()
            .filter(HW18_Task1::hasUniqueChar) // Фильтрация слов с уникальными символами (для этого напишем свой метод фильтрации)
            .collect(Collectors.toList()); // Сбор результата в список

    System.out.println("исходный список:  " + listString);
    System.out.println("Слова с уникальными символами: " + list9);
}

// метод для фильтрации в Задании 9 основан на свойстве Set , в котором останутся только уникальные символы
    private static boolean hasUniqueChar (String word){
        Set<Character> charSet = word.chars() // Преобразование строки в поток символов
                .mapToObj(c -> (char) c) // Преобразование каждого символа в объект типа Character
                .collect(Collectors.toSet()); // Сбор уникальных символов в Set

        return charSet.size() == word.length(); // Проверка: если длина Set равна длине слова, все символы уникальны
    }


}
