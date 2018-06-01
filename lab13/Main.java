
package ua.lpnuai.oop.ryvak11;



import java.util.Arrays;

import java.util.Scanner;



public class Main {



    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);

        boolean isTrue;

        System.out.print("Введіть кількість елементів масиву: ");

        int size = input.nextInt();

        int array[] = new int[size], max = array[0], decision, sum = 0, find, temp=0, z = 0;



        System.out.print("Введіть елементи: ");

        for (int i = 0; i < size; i++) {

            array[i] = input.nextInt();

        }



        do {

            System.out.println("Паралельна обробка - 1");
            System.out.println("Послідовна обробка- 2");
            System.out.println("Порівняти- 3");
            decision = input.nextInt();

            if(decision == 1) {



                System.out.print("Елемент, який ви хочете знайти: ");

                find = input.nextInt();



                for (int i = 0; i < array.length; i++)

                {

                    if (find == array[i]){

                        System.out.println("Елемент знайдено");

                        break;

                    }

                }



                long startTime = System.currentTimeMillis();



                for (int a = 0; a < array.length; a++) {

                    if (array[a] > max)

                        max = array[a];

                }



                delayForSecond();



                for( int num : array) {

                    sum = sum + num;

                }

                System.out.println("Сума елементів масиву: " + sum);



                System.out.print("Посортований масив: ");

                Arrays.parallelSort(array);

                for (int i : array)

                    System.out.print(i + " ");



                System.out.println();



                delayForSecond();



                

                for (int a : array)

                    System.out.print(a + " ");



                delayForSecond();



                System.out.println();

                System.out.println("Максимальне значення: " + max);



                delayForSecond();



                long timeSpent = System.currentTimeMillis() - startTime;

                System.out.println("Програма виконувалась " + timeSpent / 1000 + " секунд");

                isTrue = true;

            }

            else if (decision == 2){

                System.out.print("Введіть елемент, який ви хочете знайти: ");

                find = input.nextInt();



                for (int i = 0; i < array.length; i++)

                {

                    if (find == array[i]){

                        System.out.println("Елемент знайдено");

                        break;

                    }

                }



                long startTime = System.currentTimeMillis();



                for (int a = 0; a < array.length; a++) {

                    if (array[a] > max)

                        max = array[a];

                }



                delayForSecond();



                for( int num : array) {

                    sum = sum + num;

                }

                System.out.println("Сума елементів масиву: " + sum);



                delayForSecond();



                System.out.println("Посортований масив: ");

                for (int i = 0; i < array.length; i++) {

                    for (int j = 1; j < (array.length - i); j++) {



                        if (array[j - 1] > array[j]) {

                            temp = array[j - 1];

                            array[j - 1] = array[j];

                            array[j] = temp;

                        }



                    }

                }



                for(int a = 0; a < array.length; a++)

                    System.out.print(array[a] + " ");

                System.out.println();



                delayForSecond();



               


                    System.out.println();

                delayForSecond();

                long timeSpent = System.currentTimeMillis() - startTime;

                System.out.println("Програма виконувалась " + timeSpent / 1000 + " секунд");

                isTrue = true;

            }

            else if(decision == 3){

                long startTime1 = System.currentTimeMillis();



                for (int a = 0; a < array.length; a++) {

                    if (array[a] > max)

                        max = array[a];

                }



                for( int num : array) {

                    sum = sum + num;

                }



                Arrays.parallelSort(array);



              



                long timeSpent1 = System.currentTimeMillis() - startTime1;

                long startTime2 = System.currentTimeMillis();



                for (int a = 0; a < array.length; a++) {

                    if (array[a] > max)

                        max = array[a];

                }



                for( int num : array) {

                    sum = sum + num;

                }



                for (int i = 0; i < array.length; i++) {

                    for (int j = 1; j < (array.length - i); j++) {



                        if (array[j - 1] > array[j]) {

                            temp = array[j - 1];

                            array[j - 1] = array[j];

                            array[j] = temp;

                        }



                    }

                }



                do{

                    array[z] = array[z] * array[z + 1];

                    z++;

                }while((z+1) != array.length);



                long timeSpent2 = System.currentTimeMillis() - startTime2;

                System.out.println("Різниця в часі " + (timeSpent1 - timeSpent2) + " мілісекунд");

                isTrue = true;

            }

            else{

                System.out.println("Неправильна команда");

                isTrue = false;

            }

        }while (!isTrue);

    }



    private static void delayForSecond() {

        try {

            Thread.sleep(1000);

        } catch (java.lang.InterruptedException iex) {

            System.out.println(iex);

        }

    }

}