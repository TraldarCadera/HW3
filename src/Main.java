import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        // Делаем возможность выбора игры
        System.out.println("В какую игру будем играть?\n1 - Угадай число, 2 - Угадай слово.");
        int startGame = scan.nextInt();
        if (startGame == 1) {
            guessNumber();
        } else if (startGame == 2) {
            guessWord();
        }


    }

    //Задача 1. Игра угадай число
    public static void guessNumber() {
        int guessNumber = random.nextInt(10);
//        System.out.println(guessNumber); // для проверки
        System.out.println("Угадайте число от 0 до 9.");
        int count = 0;
        while (true) {
            System.out.printf("Введите Ваше число: \n");
            int inputNumber = scan.nextInt();
            if (inputNumber == guessNumber) {
                System.out.printf("Вы угадали!!!\n");
                break;
            } else if (count == 2) {
                System.out.printf("Вы проиграли. Закончились попытки\n");
                System.out.println("Повторить еще раз? 1 – да / 0 – нет");
                int enterNumb = scan.nextInt();
                if (enterNumb == 0) {
                    System.out.println("Жаль =( Приходи еще.");
                    break;
                } else {
                    count = 0;
                    System.out.println("Окей, начинаем снова.");
                }
            } else {
                count++;
                System.out.printf("Вы не угадали =( Осталось попыток - %d.\n", ( 3 - count ));
            }
        }
        scan.close();
    }

    // Задача 2. Удагай слово. 1й - вариант. Вылезала ошибка если длинна слова меньше загаданного
/*    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String guessWord = words[random.nextInt(words.length)];
        System.out.println(guessWord); // Для проверки
        System.out.print("Я загадал слово. Попробуй отгадать:");
        String inputWord;
        do {
            System.out.println("\nВведи слово");
            inputWord = scan.next();
            for (int i = 0; i < guessWord.length(); i++)
                if (guessWord.charAt(i) == inputWord.charAt(i)) {
                    System.out.print(guessWord.charAt(i));
                } else if (guessWord.charAt(i) != inputWord.charAt(i)) {
                    System.out.print("#");
                } else if (inputWord.length() < guessWord.length()) {
                    System.out.println("Загаданное слово больше");
                }
        } while (!guessWord.equals(inputWord));
        System.out.println("\nВы угадали!");
        scan.close();
    } */

    // Задание 2. Новый метод с чуть исправленной логикой
    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String guessWord = words[random.nextInt(words.length)];
//        System.out.println(guessWord); // Для проверки
        System.out.print("Я загадал слово. Попробуй отгадать:");
        String inputWord;
        do {
            System.out.println("\nВведи слово");
            inputWord = scan.next();
            for (int i = 0; i < guessWord.length(); i++) {
                if (i < guessWord.length() && i < inputWord.length() &&
                        guessWord.charAt(i) == inputWord.charAt(i)) {
                    System.out.print(guessWord.charAt(i));
                } else {
                    System.out.print(guessWord.equals(inputWord) ? "" : "#");
                }
            }
        } while (!guessWord.equals(inputWord));
        System.out.println("\nВы выйграли!");
        scan.close();
    }
}

