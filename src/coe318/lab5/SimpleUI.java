package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("Your cards are;\n" + game.getYourCards());
        System.out.println("House cards are;\n" + game.getHouseCards());
    }

  @Override
    public boolean hitMe() {
        System.out.println("Do you want to hit. If yes, type 'yes', otherwise, type 'no'");
        String hit = user.nextLine().toLowerCase();
        if(hit.equals("yes")){
            return true;
        }
        else if (hit.equals("no")){
            return false;
        }
        else{
            System.out.println("You need to either enter 'yes' or 'no' with no capitals");
            return false;
        }
    }

  @Override
    public void gameOver() {
        int yourScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());
        System.out.println("\nThe House has a score of: " + houseScore + " You have a score of: " + yourScore);
        if ((yourScore > houseScore || houseScore > 21) && yourScore <= 21){
            System.out.println("\nYou Have Won, Congratulations!!!");
            
        }
        else{
            System.out.println("\nThe House has won. Better luck next time");
        }
        System.out.println("Thank You for playing. Hope to see you again soon");
    }

}