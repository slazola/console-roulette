package com.lazola.roulette;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> players = new ArrayList<>();
        List<String> bet  = new ArrayList<>();
        List<Double> amount = new ArrayList<>();
        Random random = new Random();

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

        System.out.println("\nEnter number selection:\n 1 - place bet\n 2 - close bets\n 0 - Exit game");
        int selection = scanner.nextInt();

        do{
            switch (selection){
                case 1:
                    System.out.println("Enter player name, bet, amount");

                    players.add(scanner.next());
                    bet.add(scanner.next());
                    amount.add(Double.valueOf(scanner.next()));

                    break;
                case 2:
                    runRoullette(random,players,bet,amount);
                    break;
            }
            System.out.println("Enter number:\n 1 - place bet\n2 - close bets\n 0 - Exit game");
            selection = scanner.nextInt();
        }while (selection != 0);


    }

    public static void runRoullette(Random random,List<String > players,List<String> bet,List<Double> amount){
        int num = random.nextInt(36 - 1 + 1) + 1;
        System.out.printf("Number: %d%n", num);
        System.out.println("Player    Bet   Outcome  Winnings");
        String fmt = "%s  %-10s  %-7s %.2f%n";
        for (int i = 0; i < players.size(); i++){
            if(bet.get(i).equalsIgnoreCase("ODD") ){
                if(num % 2 > 0){
                    System.out.printf(fmt,players.get(i),bet.get(i),"WIN", Double.valueOf(amount.get(i)) * 2);
                }else {
                    System.out.printf(fmt,players.get(i),bet.get(i),"LOSE", 0d);
                }

            }else if(bet.get(i).equalsIgnoreCase("EVEN")){
                if(num % 2 == 0){
                    System.out.printf(fmt,players.get(i),bet.get(i),"WIN", Double.valueOf(amount.get(i)) * 2);
                }else {
                    System.out.printf(fmt,players.get(i),bet.get(i),"LOSE", 0d);
                }

            }else if(Integer.parseInt(bet.get(i)) == num){
                System.out.printf(fmt,players.get(i),bet.get(i),"WIN", Double.valueOf(amount.get(i)) * 36);
            }else{
                System.out.printf(fmt,players.get(i),bet.get(i),"LOSE", 0d);
            }
        }
    }
}
