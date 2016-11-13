import java.util.Random;
import java.util.Scanner;

/**
 * CS180 - Lab 06
 *
 * Brief desc
 *
 * @author Brandon Nguyen, nguye299@purdue.edu, G06
 *
 * @version 9/30/2016
 */
 public class Game {
   private final static int ROCK = 1;
   private final static int PAPER = 2;
   private final static int SCISSORS = 3;
   private final static int EXIT = 4;

   private int checkWinner(int move1, int move2) {
     // Finds the winner in the game based on the input moves
     // Returns 0 in case of a tie, 1 if the first move beats the second
     // and 2 if the second move beats the first one

     int result = 0;

     // Tie
     if (move1 == move2) {
       result = 0;
     } else if ((move1 == 1 && move2 == 3) || (move1 == 2 && move2 == 1) || (move1 == 3 && move2 == 2)) {
       result = 1;
     } else {
       result = 2;;
     }

     return result;
   }

   private int simulateComputerMove() {
     // Simulates the random choice of the computer and returns the chosen move.
     Random rand = new Random();

     int move = rand.nextInt(4);

     if (move == 0) {
       move = 1;
     }

     return move;
   }

   public void runGame() {
     // Contains the Game driver
     Scanner sc = new Scanner(System.in);

     int usersChoice = 0;
     int computerChoice;
     int result;

     System.out.println("Welcome");

    do {
      System.out.println("Please enter an option: ");
      System.out.println("1. Rock");
      System.out.println("2. Paper");
      System.out.println("3. Scissors");
      System.out.println("4. Exit");

      if (sc.nextInt() == 1) {
        System.out.println("You played rock!");
        usersChoice = 1;
      } else if (sc.nextInt() == 2) {
        System.out.println("You played paper!");
        usersChoice = 2;
      } else if (sc.nextInt() == 3) {
        System.out.println("You played scissors!");
        usersChoice = 3;
      }

      computerChoice = simulateComputerMove();

      if (computerChoice == 1) {
        System.out.println("The computer played rock!");
      } else if (computerChoice == 2) {
        System.out.println("The computer played paper!");
      } else if (computerChoice == 3) {
        System.out.println("The computer played scissors");
      }

      result = checkWinner(usersChoice, computerChoice);

      if (result == 1) {
        System.out.println("You win!");
      } else if (result == 2) {
        System.out.println("Computer wins!");
      } else if (result == 0) {
        System.out.println("Draw!");
      }

    } while (!(sc.nextInt() == 4));

     System.out.println("Thanks for playing!");

   }

   public static void main(String[] args) {
     Game g = new Game();
     g.runGame();

   }
 }
