package com.mycompany.game;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=================== Lets play Rock Paper Sezer game ============================\n");
        System.out.println("Where input 1 = Rock, 2 = Paper, 3 = Sezer\n");
        String[] choice={"Rock","Paper","sezer"};
        System.out.print("Enter the number how many round you want to play : ");
        short number = sc.nextShort();
        System.out.println();
        short playTime = 0;
        short correctInp= 0;
        short drowInp =0;
        while(playTime<number){
            System.out.print("Choose one of them ---> Rock \tPaper \tSezer : ");
            byte player_inp = sc.nextByte();

            String player_str = choice[player_inp%3>0 ? player_inp%3-1: player_inp%3+2];
            System.out.println("You select "+ player_str+" ;");
            System.out.print("Lets see what PC choose...");

            //Random Number Generate

            byte rand_int = (byte) (rand.nextInt(3));
            String pc_str=choice[rand_int];
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
            System.out.printf("Score : %.2f \n",((float)correctInp+((float)drowInp/2)));
            playTime ++;
            System.out.println("Round no of the match : "+playTime);
            System.out.println("\n");
        }
        System.out.printf("Total round of the match %s \nTotal wins in match %s \nTotal draw in the match %s\n",number,correctInp,drowInp);
        float winning_rate=(((float) correctInp+((float) drowInp/2))/(float) number)*100;
        System.out.printf("Your winning rate : %.2f\n",winning_rate);
        System.out.println(winning_rate<30? "You are too week in guessing.........":"You are not a noob !!!!!!!!");
    }
}
