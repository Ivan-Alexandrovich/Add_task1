package com.metanit;
/*1 Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
указанное пользователем число чем загаданное, или меньше. После победы или проигрыша
выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет» (1 – повторить, 0 – нет).*/
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
	    Guess();
    }

    public static void Guess() {
        Scanner input = new Scanner(System.in);
        int n = (int)(Math.random()*10); /*Math.random() возвращает дробное число в диапазоне [0;1)
        значит когда домножим на 10 получим дробное число в диапазоне [0,10), а взяв (int) от этого
        выражения, получим уже целое число [0;10), т.е. от 0 до 9*/
        System.out.println("Comp generated an integer number from 0 to 9, guess it. You have 3 attempts:");

        for (int i = 0; i < 3; i++) {
            System.out.print("Attempt number " + (i + 1) + ": ");
            int a = input.nextInt();
            if (a > n) System.out.println("Your number is greater than generated one");
            if (a < n) System.out.println("Your number is less than generated one");
            if (a == n) {System.out.println("You won!");
                System.out.println("Do u want to repeat the game? 1 – yes / 0 – no");
                a = input.nextInt();
                if (a == 1) Guess();
                else {System.out.println("Thank you for the game!");
                    Thread.currentThread().stop();
                }
            }
        }
        System.out.println("You lost");
        System.out.println("Do u want to repeat the game? 1 – yes / 0 – no");
        int a = input.nextInt();
        if (a == 1) Guess();
        else System.out.println("Thank you for the game!");
    }
}
