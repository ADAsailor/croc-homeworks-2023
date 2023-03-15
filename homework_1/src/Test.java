import java.util.*;
public class Test {
    /**
     * Задание 1:
     * Написать метод, форматирующий и выводящий на экран заданный размер в байтах в человекочитаемом виде.
     * Человекочитаемый вид:
     * {целая часть <= 1024}.{дробная часть макс. 1 знак} {единица измерения}
     *
     */
    public static String[] arrayMeasures = new String[] {"B","KB","MB","GB","TB","PB","EB","ZB"};
    /**
     * Обозначение единиц измерения:
     * "B" - байт
     * "KB" - килобайт
     * "MB" - мегабайт
     * "GB" - гигабайт
     * "TB" - терабайт
     * "PB" - петабайт
     * "EB" - эксабайт
     * "ZB" - зеттабайт
     */
    public static void printBytes(double num) {
        if (num < 0)
            System.out.println("Некорректные входные данные");
        int count = 0;
        while (num >= 1024) {
            num /= 1024;
            count++;
        }
        String result = String.format("%.1f", num).replace(',','.') + " " + arrayMeasures[count];
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        printBytes(number);
        sc.close();
    }
}
