package com.lazola.roulette;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome. Please enter player list file");
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        if(scanner.hasNextLine()){
            String file = scanner.next();
            System.out.println("File : " + file);
        }
    }
}
