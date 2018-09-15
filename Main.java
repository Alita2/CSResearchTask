package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int array[] = { 45, 65, 37, 18, 7, 90, 58, 96, 70 };
        CycleSort.sort(array);
        System.out.println("After sort : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
