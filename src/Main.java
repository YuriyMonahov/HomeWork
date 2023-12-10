import java.util.*;

public class Main {



//    Задание: Реализуйте структуру телефонной книги с помощью HashMap. Программа также должна учитывать,
//    что в во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать,
//    как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

        public static void main (String[]args){
            HashMap<String, List<String>> phoneBook = new HashMap<>();
            addContact(phoneBook, "Иванов", "123456789");
            addContact(phoneBook, "Петров", "987654321");
            addContact(phoneBook, "Сидоров", "111222333");
            addContact(phoneBook, "Иванов", "+555666777");
            addContact(phoneBook, "Иванов", "123454321");
            addContact(phoneBook, "Сидоров", "000111222");
            printSortedContacts(phoneBook);
        }


            private static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
                // Если имя уже есть в книге, добавляем телефон к существующему списку
                if (phoneBook.containsKey(name)) {
                    phoneBook.get(name).add(phoneNumber);
                } else {
                    // Иначе создаем новую запись в книге
                    List<String> phoneNumbers = new ArrayList<>();
                    phoneNumbers.add(phoneNumber);
                    phoneBook.put(name, phoneNumbers);
                }
            }


            private static void printSortedContacts(HashMap<String, List<String>> phoneBook) {
                phoneBook.entrySet().stream()

                        .sorted(Comparator.<Map.Entry<String, List<String>>>comparingInt(entry -> entry.getValue().size()).reversed())
                        .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
            }
        }


