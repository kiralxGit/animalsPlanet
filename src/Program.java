import pets.*;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Program {
    static AnimalRepository animals = new AnimalRepository();

    public static void main(String[] args) {
        System.out.println(">>> Выберите пункт: <<<");
        while(true){
            System.out.println("1. Добавить животное\n" +
                    "2. Посмотреть всех животных\n" +
                    "3. Общее кол-во животных\n" +
                    "4. Удалить животное\n" +
                    "5. Посмотреть команды животного\n" +
                    "6. Добавить команду животному\n" +
                    "---\n0. Выход");
            int command = getUserCommand();
            if(command == 0) break;
            else if(command == 1) addAnimal();
            else if(command == 2) animals.printAllAnimals();
            else if(command == 3) System.out.println("Всего животных: " + animals.getSize() + "\n");
            else if(command == 4) removeAnimal();
            else if(command == 5) System.out.println("Функция в процессе реализации...");
            else if(command == 6) System.out.println("Функция в процессе реализации...");
            else System.out.println("Введите корректное значение!");
        }
        System.out.println(">>> Программа завершена! <<<");
    }
    private static int getUserCommand(){
        Scanner sc = new Scanner(System.in);
        String input;
        int res;
        while(true) {
            input = sc.next();
            try {

                res = parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Вы ввели символы: " + input + " введите цифру:");
            }
        }
        return res;
    }

    private static void addAnimal(){
        System.out.println("Введите кличку:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Введите дату рождения:");
        String birthday = sc.next();
        System.out.println("Выберите животное:");
        System.out.println("1. Cat\n" +
                "2. Dog\n" +
                "3. Hamster\n" +
                "4. Camel\n" +
                "5. Donkey\n" +
                "6. Horse\n" +
                "---\n0. Выход");
        int command = getUserCommand();
        if(command == 0) return;
        else if(command == 1) animals.add(new Cat(name, birthday));
        else if(command == 2) animals.add(new Dog(name, birthday));
        else if(command == 3) animals.add(new Hamster(name, birthday));
        else if(command == 4) animals.add(new Camel(name, birthday));
        else if(command == 5) animals.add(new Donkey(name, birthday));
        else if(command == 6) animals.add(new Horse(name, birthday));
    }
    private static void removeAnimal(){
        if (animals.getSize() < 1){
            System.out.println("Нет животных!");
            return;
        }
        System.out.println("Выберите животное: ");
        animals.printAllAnimals();
        System.out.println("0. Отмена");
        while(true){
            int command = getUserCommand();
            if(command == 0) break;
            else if (command <= animals.getSize() && command > 0){
                animals.removeAnimal(command - 1);
                break;
            }
            else System.out.println("Введите корректное значение!");
        }
    }
}
