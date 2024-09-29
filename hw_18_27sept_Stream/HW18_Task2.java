package de.telran.hw_18_27sept_Stream;

import java.util.*;
import java.util.stream.Collectors;

public class HW18_Task2 {
    public static void main(String[] args) {
        // ДЛЯ УДОБСТВА СГРУППИРУЮ ЗАДАНИЯ ПО ТИПУ ИСХОДНЫХ ДАННЫХ

        // Задача 1: Фильтрация четных чисел и умножение на 2.
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 9, 4, 2, 3, 54, 48, 51, 54, 51, 48, 17, 62, 789, 554, 18));

        List<Integer> listT1 = integerList.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .toList();
        System.out.println("исходный список:  " + integerList);
        System.out.println("Фильтрация четных чисел и умножение на 2:  " + listT1);
        System.out.println();

        // Задача 3: Сортировка списка чисел в порядке убывания и выбор первых трех элементов.
        System.out.println("--------3- Сортировка списка чисел в порядке убывания и выбор первых трех элементов---------");
        List<Integer> listT3 = integerList.stream()
                .sorted((n1, n2) -> n2 - n1) // Сортировка в порядке убывания
                .limit(3)
                .toList();
        System.out.println("исходный список:  " + integerList);
        System.out.println("Сортировка списка чисел в порядке убывания и выбор первых трех элементов:  " + listT3);
        System.out.println();

        // Задача 5: Пропуск первых двух элементов и вывод оставшихся.
        System.out.println("--------Задача 5: Пропуск первых двух элементов и вывод оставшихся---------");
        List<Integer> listT5 = integerList.stream()
                .skip(2)
                .toList();
        System.out.println("исходный список:  " + integerList);
        System.out.println("Пропуск первых двух элементов и вывод оставшихся:  " + listT5);
        System.out.println();

        // Задача 6: Фильтрация чисел больше 50 и вывод их квадратов.
        System.out.println("--------Задача 6: Фильтрация чисел больше 50 и вывод их квадратов---------");
        System.out.println("исходный список:  " + integerList);
        System.out.print("Фильтрация чисел больше 50 и вывод их квадратов:  ");

        integerList.stream()
                .filter(x -> x > 50)
                .map(x -> x * x)
                .forEach(x -> System.out.print(" ," + x));
        System.out.println();
        System.out.println();

        // Задача 8: Фильтрация чисел, оставить только нечетные и вывести их в порядке возрастания.
        System.out.println("--------8: Фильтрация чисел, оставить только нечетные и вывести их в порядке возрастания---------");
        List<Integer> listT8 = integerList.stream()
                .filter(x -> x % 2 != 0)
                .sorted((n1, n2) -> n1 - n2) // Сортировка в порядке возрастания
                .toList();
        System.out.println("исходный список:  " + integerList);
        System.out.println("оставим только нечетные и выведем их в порядке возрастания:  " + listT8);
        System.out.println();

        // Задача 9: Получить среднее значение чисел в списке.
        System.out.println("--------9: Получить среднее значение чисел в списке---------");
        OptionalDouble average = integerList.stream()
                .mapToInt(Integer::intValue) // Преобразование элементов в int
                .average(); // Вычисление среднего значения
        System.out.println("среднее значение чисел в списке:  " + average.getAsDouble());
        System.out.println();

        // Задача 14: Пропустить первые 2 элемента и оставить только уникальные.
        System.out.println("--------14: Пропустить первые 2 элемента и оставить только уникальные---------");
        Set<Integer> setInt14 = integerList.stream()
                .skip(2)
                .collect(Collectors.toSet());
        System.out.println("исходный список:  " + integerList);
        System.out.println("Пропустим первые 2 элемента и оставить только уникальные:  " + setInt14);
        System.out.println();

        // Задача 11: Получить список квадратов чисел из другого списка.
        System.out.println("--------11: Получить список квадратов чисел из другого списка---------");
        List<Integer> integerList11 = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10));
        List<Integer> list11 = integerList11.stream()
                .map(x -> x * x)
                .toList();
        System.out.println("исходный список:  " + integerList11);
        System.out.println("список квадратов чисел из другого списка:  " + list11);
        System.out.println();

        // Далее будем работать со строками, для этого создадим список строк
        List<String> stringList = new ArrayList<>(Arrays.asList("Apollon", "Olga", "Max", "Peter", "Elena", "Peter", "Olga", "Ivan", "Marina", "Boris"));

        // Задача 2: Удаление дубликатов из списка строк.
        System.out.println("--------2: Удаление дубликатов из списка строк---------");
        Set<String> set1 = stringList.stream()
                .collect(Collectors.toSet());
        System.out.println("исходный список:  " + stringList);
        System.out.println("список без дубликатов:  " + set1);
        System.out.println();

        // Задача 4: Фильтрация строк, начинающихся на "A" и преобразование в верхний регистр.
        System.out.println("--------4: Фильтрация строк, начинающихся на (A) и преобразование в верхний регистр---------");
        List<String> strList4 = stringList.stream()
                .filter(x -> x.startsWith("A"))
                .map(x -> x.toUpperCase())
                .toList();

        System.out.println("исходный список:  " + stringList);
        System.out.println("Фильтрация строк, начинающихся на (A) и преобразование в верхний регистр:  " + strList4);
        System.out.println();

        // Задача 7: Оставить только слова, содержащие букву "o" и вывести их в обратном порядке.
        System.out.println("--------7: Оставить только слова, содержащие букву (o) и вывести их в обратном порядке---------");
        List<String> strList7 = stringList.stream()
                .filter(x -> x.contains("o"))
                .sorted((w1, w2) -> w2.compareTo(w1))
                .toList();

        System.out.println("исходный список:  " + stringList);
        System.out.println("Оставим только слова, содержащие букву (o) и выведем их в обратном порядке:  " + strList7);
        System.out.println();

        // Задача 10: Получить строку, объединяющую элементы списка через запятую.
        System.out.println("--------10: Получить строку, объединяющую элементы списка через запятую---------");
        String string10 = stringList.stream()
                .collect(Collectors.joining(", ")); // Объединение элементов через запятую
        System.out.println("исходный список:  " + stringList);
        System.out.println("строка, объединяющую элементы списка через запятую:  " + string10);
        System.out.println();

        // Задача 12: Получить список букв из списка слов и вывести их в алфавитном порядке.
        System.out.println("--------12: Получить список букв из списка слов и вывести их в алфавитном порядке---------");
        List<Character> sortChar = stringList.stream()
                .flatMap(word -> word.chars() // Преобразование слова в поток символов
                        .mapToObj(c -> (char) c)) // Преобразование int в char
                .sorted() // Сортировка в алфавитном порядке
                .collect(Collectors.toList()); // Сбор результата в список

        System.out.println("исходный список:  " + stringList);
        System.out.println("список букв из списка слов и вывод их в алфавитном порядке:  " + sortChar);
        System.out.println();

        // Задача 13: Получить первые 3 строки из списка и вывести их в обратном порядке.
        System.out.println("--------13: Получить первые 3 строки из списка и вывести их в обратном порядке---------");
        List<String> list13 = stringList.stream()
                .limit(3)
                .collect(Collectors.toList());

        Collections.reverse(list13);     // Переворачиваем порядок строк

        System.out.println("исходный список:  " + stringList);
        System.out.println("первые 3 строки из списка выведем в обратном порядке:  " + list13);
        System.out.println();

        // Задача 15: Фильтрация и сортировка пользователей User по возрасту.
        class User {
            private String name;
            private int age;

            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            @Override
            public String toString() {
                return "User{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }

        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("Peter", 23),
                new User("Olga", 45),
                new User("Ivan", 17),
                new User("Hella", 67),
                new User("Max", 27)
        ));
        System.out.println(" исходный список:   " + userList);
        List<User> userSortAge = userList.stream()
                .sorted((x1, x2) -> x1.age - x2.age)
                .toList();

        System.out.println(" отсортированный по возрасту список:   "+ userSortAge);
    }

}
