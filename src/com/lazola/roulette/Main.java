package com.lazola.roulette;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome. Please enter players list file with directory path.");
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        if(scanner.hasNextLine()){
            String file = scanner.next();
            try {
                String fileData = new String(Files.readAllBytes(Paths.get(file)));
                System.out.println("Players : \n" + fileData);
            }catch (IOException exc){
                System.out.println(String.format("Error reading file : %s", exc.getMessage()));
            }

        }
    }
}
