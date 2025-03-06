package com.mycompany.game;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lets play Rock Paper Sezer game : ");
        System.out.println("Where input 1 = Rock, 2 = Paper, 3 = Sezer");
        System.out.print("Enter the number how many time you want to play : ");
        short number = sc.nextShort();
        short playTime = 0;
        short correctInp= 0;
        short drowInp =0;
        while(playTime<number){
            System.out.print("Choose one of them ---> Rock \tPaper \tSezer : ");
            byte player_inp = sc.nextByte();
            String player_str;
            if(player_inp%3==1){
                player_str ="Rock";
            }
            else if(player_inp%3==2){
                player_str ="Paper";
            }
            else {
                player_str ="Sezer";
            }
            System.out.println("You select "+ player_str);
            System.out.print(", Lets see what PC choose...");

            //Random Number Generate

            Random rand = new Random();
            byte rand_int = (byte) (rand.nextInt(3));
            String pc_str;
            if(rand_int==0){
                pc_str = "Rock";
            } else if (rand_int==1) {
                pc_str = "Paper";
            }
            else{
                pc_str = "Sezer";
            }
            System.out.println("PC select : "+pc_str);
            if(player_str.equals(pc_str)){
                System.out.println("Match Draw");
                drowInp++;
            }
            else {
                if(player_str.equals("Rock") && pc_str.equals("Paper")){
                    System.out.println("You loss");
                }
                else if(player_str.equals("Rock") && pc_str.equals("Sezer")){
                    System.out.println("You Win");
                    correctInp++;
                }
                else if(player_str.equals("Paper") && pc_str.equals("Sezer")){
                    System.out.println("You Loss");
                }
                else if(player_str.equals("Paper") && pc_str.equals("Rock")){
                    System.out.println("You Win");
                    correctInp++;
                }
                else if(player_str.equals("Sezer") && pc_str.equals("Rock")){
                    System.out.println("You Loss");
                }
                else if(player_str.equals("Sezer") && pc_str.equals("Paper")){
                    System.out.println("You Win");
                    correctInp++;
                }
            }
            System.out.println("Score : "+ correctInp);
            playTime ++;
            System.out.println("Match no : "+playTime);
        }
        System.out.printf("Total wins %s total match %s\n",playTime,number);
        float winning_rate=(((float) correctInp+((float) drowInp/2))/(float) number)*100;
        System.out.printf("Your winning rate : %.2f",winning_rate);

    }
}
