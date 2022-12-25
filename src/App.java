import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        char [][] gameBoard = {{' ', '|', ' ', '|', ' '}, {'-', '|', '-', '|', '-'}, {' ', '|', ' ', '|', ' '}, {'-', '|', '-', '|', '-'}, {' ', '|', ' ', '|', ' '}};

        // gets user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number 1-9:");
        int position = scan.nextInt();

        // places piece for player
        placePiece(gameBoard, position, "player");

        Random randomNum = new Random();
        int computerPosition = randomNum.nextInt(9) + 1;

        // places piece for computer
        placePiece(gameBoard, computerPosition, "computer");
        // displays game board
        printGameBoard(gameBoard);
        
    }

    public static void printGameBoard(char[][] gameBoard) {
        // creates 2d array
        for(char[] row: gameBoard) {
            for(char c: row) {
                System.out.print(c);
            }
        System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int position, String user) {
        // sets the position of each peace based on input
        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
        } else if (user.equals("computer")) {
            symbol = 'O';
        }

        switch(position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = 'X';
                break;
            case 8:
                gameBoard[4][2] = 'X';
                break;
            case 9:
                gameBoard[4][4] = 'X';
                break;
    }
    }
}