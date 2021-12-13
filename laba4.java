import java.util.InputMismatchException;
import java.util.Scanner;

//Написать программу, удаляющую из вещественного массива A размерности N «лишние» элементы так,
// чтобы оставшиеся элементы оказались упорядоченными по возрастанию (начиная от первого
//элемента): первый элемент не удаляется, второй элемент удаляется, если он меньше первого, третий —
// если он меньше предыдущего элемента, оставленного в массиве, и т. д. Например, массив 5.5, 2.5, 4.6,
// 7.2, 5.8, 9.4 должен быть преобразован к виду 5.5, 7.2, 9.4. а экран должны выводиться как
// оригинальное состояние массива, так и итоговое.
public class laba4 {
    public static void main(String[] args) {
        float[] firstarr = new float[0];
        System.out.println("Enter_the_number_of_elements_for_the_array:");
        try {
            Scanner in = new Scanner(System.in);
            int kolvo = in.nextInt();
            System.out.println("Enter_the_elements_of_the_array");
            firstarr = new float[kolvo];
            for (int i = 0; i < kolvo; i++) {
                firstarr[i] = in.nextFloat();
            }
            in.close();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect_data");
            System.exit(1);
        } //ввод и проверка
        System.out.println("Original_array:");
        for (float elem : firstarr) {
            System.out.print(elem + " ");
        } //ввод изначального массива
        int elemcount = 0;
        int maxelem = 0;
        for (int i = 1; i < firstarr.length; i++) {
            if (firstarr[i] > firstarr[maxelem]) {
                maxelem = i;
                elemcount = elemcount + 1;
            }
        } //расчитываем размер искомого массива
        maxelem = 0;
        float[] finalarr = new float[elemcount + 1];
        finalarr[0] = firstarr[0];
        //приравняем первые элементы
        elemcount = 1;
        for (int i = 1; i < firstarr.length; i++) {
            if (firstarr[i] > firstarr[maxelem]) {
                maxelem = i;
                finalarr[elemcount] = firstarr[maxelem];
                elemcount = elemcount + 1;
            }
        }
        //заполняем искомый массив подходящими элементами
        System.out.println("\nResult:");
        for (float elem : finalarr) {
            System.out.print(elem + " ");
        }
        //вывод результата

    }
}