import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class MyProgram {
    public static int kt = 0;
    public static void main(String[] args) {

        Scanner vvod = new Scanner(System.in);
        int action;
        System.out.println("Введите номер задания");
        action = vvod.nextInt();

        switch (action){
            case 1: //Задание 1
                System.out.println("Введите размер массива");
                int i = vvod.nextInt();
                System.out.println("Введите число для поика в массиве");
                int P = vvod.nextInt();
                int[] numbers = new int[i]; //Создание массива
                System.out.println("Созданный массив целочисленных чисел:");
                for (int n = 0; n < i; n++){
                    numbers[n] = (int) (Math.random() * 101);
                    System.out.print(numbers[n] + " ");
                }
                System.out.println("\nИспользуем бинарный поиск...");
                Arrays.sort(numbers);
                long start = System.nanoTime();
                int index = Arrays.binarySearch(numbers, P);
                long finish = System.nanoTime();
                if (index == -1) {
                    System.out.println("False");
                } else {
                    System.out.println("True, index = " + index);
                }
                System.out.println("Затраченное время: " + String.format("%d", finish-start));

                System.out.println("\nИспользуем последовательный поиск...");
                start = System.nanoTime();
                int chet = 0;
                for (int n = 0; n < i; n++){
                    if (numbers[n] == P){
                        System.out.println("True, index = " + index);
                        break;
                    } else {
                        chet++;
                    }
                }
                if (chet == i) System.out.println("False");
                finish = System.nanoTime();
                System.out.println("Затраченное время: " + String.format("%d", finish-start));
                break;

            case 2: //Задание 2
                System.out.println("Введите размер массива");
                i = vvod.nextInt();
                int[] numbers2 = new int[i]; //Создание массива
                System.out.println("Созданный массив целочисленных чисел:");
                for (int n = 0; n < i; n++){
                    numbers2[n] = (int) (Math.random() * 101);
                    System.out.print(numbers2[n] + " ");
                }
                int[]copiedArray1 = numbers2.clone();
                int[]copiedArray2 = numbers2.clone();
                int[]copiedArray3 = numbers2.clone();

                System.out.println("\nМетод сортировки:");

                    for (i = copiedArray1.length - 1; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            if (copiedArray1[j] > copiedArray1[j + 1]) {
                                int tmp = copiedArray1[j];
                                copiedArray1[j] = copiedArray1[j + 1];
                                copiedArray1[j + 1] = tmp;
                            }
                        }
                    }
                    System.out.println("Сортировка методом пузырьков:");
                    for (int n = 0; n < copiedArray1.length; n++) {
                        System.out.print(copiedArray1[n] + " ");
                    }

                    /*По очереди будем просматривать все подмножества элементов массива (0 - последний, 1-последний, 2-последний,...)*/
                    for (i = 0; i < copiedArray2.length; i++) {
                        /*Предполагаем, что первый элемент (в каждом подмножестве элементов) является минимальным */
                        int min = copiedArray2[i];
                        int min_i = i;
                        /*В оставшейся части подмножества ищем элемент, который меньше предположенного минимума*/
                        for (int j = i + 1; j < copiedArray2.length; j++) {
                            //Если находим, запоминаем его индекс
                            if (copiedArray2[j] < min) {
                                min = copiedArray2[j];
                                min_i = j;
                            }
                        }
                        /*Если нашелся элемент, меньший, чем на текущей позиции, меняем их местами*/
                        if (i != min_i) {
                            int tmp = copiedArray2[i];
                            copiedArray2[i] = copiedArray2[min_i];
                            copiedArray2[min_i] = tmp;
                        }
                    }
                    System.out.println("\nСортировка выбором:");
                    for (int n = 0; n < copiedArray2.length; n++) {
                        System.out.print(copiedArray2[n] + " ");
                    }

                    Arrays.sort(copiedArray3);
                    System.out.println("\nСортировка командой sort:");
                    for (int n = 0; n < copiedArray3.length; n++) {
                        System.out.print(copiedArray3[n] + " ");
        }

                System.out.println("\nНеотсортированный:");
                    for (int n = 0; n < numbers2.length; n++) {
                        System.out.print(numbers2[n] + " ");
                    }

                if(Arrays.equals(copiedArray3, copiedArray1)) System.out.println("\nСортировка сходится с пузырьковым методом");
                if(Arrays.equals(copiedArray3, copiedArray2)) System.out.println("\nСортировка сходится с сортировкой выбором");
                    break;



            case 3: //Задание 3
                String str = "Yesterday I visited my Granny in the countryside. We go there every weekend and I enjoy these trips. But not this time. It was raining cats and dogs, our car broke several times and we all were very tired. But when we saw the Granny, I forgot about the difficulties.";
                System.out.print("Текст: " + str);
                str = str.toLowerCase();
                System.out.print("\nВведите символ, который необходимо найти:");
                String b = vvod.next();
                char symbol = b.charAt(b.length()-1);

                int k = 0;
                k = str.codePointCount(0, str.length()-1);
                k = str.compareTo(b);
                //k = str.nextindexof(b);
                for (char element : str.toCharArray()){
                    if (element == symbol) k++;
                }
                System.out.print("Количество символов \""+ b + "\" в тексте равно = " + k);
                break;

            case 4: //Задание 4
                System.out.print("\nВведите количество дисков:");
                i = vvod.nextInt();
                moveRing('A', 'B', 'C', i);
                break;
            default:
                System.out.println("Некорректное значение, введите номер от 1 до 4");
        }
    }



    public static void moveRing(char a, char b, char c, int count) {
        if (count==1){
            kt=kt+1;
            System.out.println(String.format(kt + " moves %s to %s",a,b));

        }else {
            moveRing(a, c, b, count - 1);
            kt=kt+1;
            System.out.println(String.format(kt + " moves %s to %s",a,b));
            moveRing(c,b,a,count-1);
        }
    }
}





