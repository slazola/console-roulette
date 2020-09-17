package com.lazola.roulette;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> players = new ArrayList<>();
        List<String> bet  = new ArrayList<>();
        List<Double> amount = new ArrayList<>();

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

        System.out.println("Enter number:\n 1 - place bet\n2 - close bets\n 0 - Exit game");
        int selection = scanner.nextInt();

        do{
            switch (selection){
                case 1:
                    System.out.println("Enter player name, bet, amount");

                    players.add(scanner.next());
                    bet.add(scanner.next());
                    amount.add(Double.valueOf(scanner.next()));

                    System.out.println("Players: " + players + " bet: " +  bet + "  Amount: " + amount);
                    break;
                case 2:
                    break;
            }
            System.out.println("Enter number:\n 1 - place bet\n2 - close bets\n 0 - Exit game");
            selection = scanner.nextInt();
        }while (selection != 0);


    }
}
