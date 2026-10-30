import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {


    private static Student[] students;


    static {
        students = new Student[10];

        students[0] = new Student("Петров", true, "Школа №5", "Английский");
        students[1] = new Student("Сидоров", false, "Лицей №2", "Немецкий");
        students[2] = new Student("Алексеева", true, "Гимназия №1", "Французский");
        students[3] = new Student("Иванов", true, "Школа №10", "Английский");
        students[4] = new Student("Смирнова", false, "Техникум", "Французский");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Вывести всех студентов");
            System.out.println("2. Добавить студента");
            System.out.println("3. Задание А: Сколько нуждаются в общежитии");
            System.out.println("4. Задание Б: Студенты, изучавшие французский в техникуме");
            System.out.println("5. Задание В: Отсортировать по фамилиям");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printStudents();
                    break;
                case 2:
                    addStudent(scanner);
                    break;
                case 3:
                    countDormNeedy();
                    break;
                case 4:
                    listFrenchTechnicum();
                    break;
                case 5:
                    sortByLastName();
                    printStudents();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }


    public static void printStudents() {
        System.out.println("\n--- Список студентов ---");
        boolean isEmpty = true;
        for (Student s : students) {
            if (s != null) {
                System.out.println(s);
                isEmpty = false;
            }
        }
        if (isEmpty) System.out.println("Список пуст.");
    }


    public static void addStudent(Scanner scanner) {
        int freeIndex = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                freeIndex = i;
                break;
            }
        }

        if (freeIndex == -1) {
            System.out.println("Массив заполнен! Нет места.");
            return;
        }

        String name;
        while (true) {
            System.out.print("Введите фамилию: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Ошибка: Фамилия не может быть пустой! Попробуйте снова.");
            } else {
                break;
            }
        }

        boolean dorm;
        while (true) {
            System.out.print("Нуждается в общежитии (да/нет): ");
            String dormStr = scanner.nextLine().trim().toLowerCase();
            if (dormStr.equals("да") || dormStr.equals("yes")) {
                dorm = true;
                break;
            } else if (dormStr.equals("нет") || dormStr.equals("no")) {
                dorm = false;
                break;
            } else {
                System.out.println("Ошибка: Введите 'да' или 'нет'.");
            }
        }

        String edu;
        while (true) {
            System.out.print("Что окончил: ");
            edu = scanner.nextLine().trim();
            if (edu.isEmpty()) {
                System.out.println("Ошибка: Это поле не может быть пустым! Попробуйте снова.");
            } else {
                break;
            }
        }

        String lang;
        while (true) {
            System.out.print("Какой язык изучал: ");
            lang = scanner.nextLine().trim();
            if (lang.isEmpty()) {
                System.out.println("Ошибка: Это поле не может быть пустым! Попробуйте снова.");
            } else {
                break;
            }
        }

        students[freeIndex] = new Student(name, dorm, edu, lang);
        System.out.println("Студент успешно добавлен.");
    }


    public static void countDormNeedy() {
        int count = 0;
        for (Student s : students) {
            if (s != null && s.isNeedsDorm()) {
                count++;
            }
        }
        System.out.println("Количество студентов, нуждающихся в общежитии: " + count);
    }


    public static void listFrenchTechnicum() {
        System.out.println("\n--- Студенты, изучавшие французский в техникуме ---");
        boolean found = false;
        for (Student s : students) {
            if (s != null) {
                if (s.getLanguage().equalsIgnoreCase("Французский") &&
                        s.getPreviousEdu().equalsIgnoreCase("Техникум")) {
                    System.out.println(s);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Таких студентов не найдено.");
        }
    }


    public static void sortByLastName() {

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1 == null && s2 == null) return 0;
                if (s1 == null) return 1;
                if (s2 == null) return -1;
                return s1.getLastName().compareToIgnoreCase(s2.getLastName());
            }
        });
        System.out.println("Массив отсортирован по фамилиям.");
    }
}

