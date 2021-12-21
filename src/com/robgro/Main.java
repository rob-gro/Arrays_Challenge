package com.robgro;

// Create a program using arrays that sorts a list of integers in descending order.
// Descending order is highest value to lowest.
// In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
// ultimately have an array with 106, 81, 26, 15, 5 in it.
// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers
// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers
// you will have to figure out how to copy the array elements from the passed array into a new
// array and sort them and return the new sorted array.

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // 1. tworzymy pole pobierające dane z consoli
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // 1. tworzymy tablicę z Integers na 5 elementów  (można później dowolnie zmieniać ilość pobieranych
        int[] myIntegers = getIntegers(5);

        // 6. po sortowaniu
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);

        // 7. RUN -->
        /*
        Enter 5 integer values:
        106
        26
        81
        5
        15
        Element 0 contents 106
        Element 1 contents 81
        Element 2 contents 26
        Element 3 contents 15
        Element 4 contents 5
         */

    }

    // 2. metoda pobierająca Integers
    public static int[] getIntegers(int capacity) {
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values:\r");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // 3. tablica drukująca
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

    // 4. kopiowanie elementów ze starej tablicy(wprowadzonej) do nowej tablicy, posortowanie malejąco i wypuszczenie nowej
    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }
//  8. INNY SPOSÓB NA KOPIOWANIE TABLICY
//     int[] sortedArray = Arrays.copyOf(array, array.length);

        // 5. S O R T O W A N I E
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;

            // element 0    50
            // element 1    160
            // element 2    40

            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {   // jeżeli( 50 < 160) {
                    temp = sortedArray[i];                //  temp = 50       // temp = element 0
                    sortedArray[i] = sortedArray[i + 1];    // 50 = 160         // element 0 = element 1
                    sortedArray[i + 1] = temp;              // 160 = temp       // element 1 = temp

                    // po zamianie elementy wyglądają:
                    // element 0    160
                    // element 1    50
                    // element 2    40

                    // zmieniamy flagę na TRUE i wtedy pętla WHILE musi znowu przejść przez resztę elementów
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
