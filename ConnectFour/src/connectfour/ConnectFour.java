/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.Scanner;

/**
 *
 * @author yordanosmogos
 */
public class ConnectFour {

    public static void main(String[] args) {
        // DON'T MODIFY THE MAIN METHOD UNLESS FOR DEBUGGING
        //MAKE SURE YOU GET RID OF YOUR MODIFICATIONS HERE BEFORE SUBMISSION

        String[][] board = createEmptyBoard();

        Scanner input = new Scanner(System.in);

        boolean bl = true;

        printPattern(board);

        while (bl) {

            int player1 = 1, player2 = 2, userInput;

            System.out.println("Please drop a RED disk at the column between 0 and 6:");
            userInput = input.nextInt();
            dropDisk(board, userInput, player1);
            printPattern(board);

            System.out.println("Please drop a YELLOW disk at the column between 0 and 6:");
            userInput = input.nextInt();
            dropDisk(board, userInput, player2);
            printPattern(board);

            String win = checkWinner(board);
            /*
        Write code to announce  if there is  winner and end the game
             */
            if (win != null) {
                if (win == "R") {
                    System.out.println("The Red player won.");
                } else if (win == "Y") {
                    System.out.println("The Yellow player won.");
                }
                bl = false;
            }

        } // end of while loop

    } // end of main

    public static String[][] createEmptyBoard() {
        /* This method prints the first empty pattern for the game
       DON'T MODIFY THIS METHOD
         */

        String[][] f = new String[7][15];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {

                if (j % 2 == 0) {
                    f[i][j] = "|";
                } else {
                    f[i][j] = " ";
                }
                if (i == 6) {
                    f[i][j] = "-";
                }
            }
        }
        return f;
    }
       

     // end of createEmptyBoard 

    public static void printPattern(String[][] b) {
        //Write your code here to print an updated pattern
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }

    } // end of printPattern

    public static void dropDisk(String[][] b, int positin, int player) {

        /*Write your code to drop the disk at the position the user entered 
       depending on which player*/
        if (player == 1) {
            int x = (2 * positin + 1);
            for (int i = 5; i >= 0; i--) {
                if (b[i][x] == " ") {
                    b[i][x] = "R";
                    break;
                }
            }
        } else {
            int x = 2 * positin + 1;
            for (int i = 5; i >= 0; i--) {
                if (b[i][x] == " ") {
                    b[i][x] = "Y";
                    break;
                }
            }
        }
    } // end of dropDisk

    public static String checkWinner(String[][] b) {
        /*Write your code to check if there is a winner. If there is, then
       return the charaster of the winners color( withe R or Y)
         */
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j += 2) {
                if ((b[i][j + 1] != " ") && (b[i][j + 3] != " ") && (b[i][j + 5] != " ")
                        && (b[i][j + 7] != " ")
                        && ((b[i][j + 1] == b[i][j + 3]) && (b[i][j + 3] == b[i][j + 5])
                        && (b[i][j + 5] == b[i][j + 7]))) {
                    return b[i][j + 1];
                }
            }
        }

        for (int i = 1; i < 15; i += 2) {
            for (int j = 0; j < 3; j++) {
                if ((b[j][i] != " ") && (b[j + 1][i] != " ") && (b[j + 2][i] != " ") && (b[j + 3][i] != " ")
                        && ((b[j][i] == b[j + 1][i]) && (b[j + 1][i] == b[j + 2][i])
                        && (b[j + 2][i] == b[j + 3][i]))) {
                    return b[j][i];
                }
            }
        }
        for (int i = 0; i < 3; i++) {

            for (int j = 1; j < 9; j += 2) {

                if ((b[i][j] != " ") && (b[i + 1][j + 2] != " ") && (b[i + 2][j + 4] != " ")
                        && (b[i + 3][j + 6] != " ")
                        && ((b[i][j] == b[i + 1][j + 2]) && (b[i + 1][j + 2] == b[i + 2][j + 4])
                        && (b[i + 2][j + 4] == b[i + 3][j + 6]))) {
                    return b[i][j];
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 7; j < 15; j += 2) {
                if ((b[i][j] != " ") && (b[i + 1][j - 2] != " ") && (b[i + 2][j - 4] != " ")
                        && (b[i + 3][j - 6] != " ")
                        && ((b[i][j] == b[i + 1][j - 2]) && (b[i + 1][j - 2] == b[i + 2][j - 4])
                        && (b[i + 2][j - 4] == b[i + 3][j - 6]))) {
                    return b[i][j];
                }
            }
            

        } // end of checkWinner
   return null; } }// end of class

