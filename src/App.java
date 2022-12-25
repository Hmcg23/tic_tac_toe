import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    // global variables
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> computerPositions = new ArrayList<Integer>();
    
    public static void main(String[] args) throws Exception {
        char [][] gameBoard = {{' ', '|', ' ', '|', ' '}, {'-', '|', '-', '|', '-'}, {' ', '|', ' ', '|', ' '}, {'-', '|', '-', '|', '-'}, {' ', '|', ' ', '|', ' '}};


        while(true) {
            // gets user input
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a number 1-9:");
            int playerPosition = scan.nextInt();
            while (playerPositions.contains(playerPosition) || computerPositions.contains(playerPosition)) {
                System.out.println("position taken, please try again.");
                playerPosition = scan.nextInt();
            }

            // places piece for player
            placePiece(gameBoard, playerPosition, "player");

            Random randomNum = new Random();
            int computerPosition = randomNum.nextInt(9) + 1;
            while (playerPositions.contains(computerPosition) || computerPositions.contains(computerPosition)) {
                playerPosition = scan.nextInt();
            }

            String result = checkWinner();
            
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }

            // places piece for computer
            placePiece(gameBoard, computerPosition, "computer");
            // displays game board
            printGameBoard(gameBoard);

            result = checkWinner();
            
            if(result.length() > 0) {
                System.out.println(result);
                break;
            }

            // checks for winner and displays result
        }


        
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
            playerPositions.add(position);
        } else if (user.equals("computer")) {
            symbol = 'O';
            computerPositions.add(position);
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
 
    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List middleCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List diagonaLeftToRight = Arrays.asList(1, 5, 9);
        List diagonalRightToLeft = Arrays.asList(3, 5, 7);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftCol);
        winningConditions.add(middleCol);
        winningConditions.add(rightCol);
        winningConditions.add(diagonaLeftToRight);
        winningConditions.add(diagonalRightToLeft);

        for (List l: winningConditions) {
            if (playerPositions.containsAll(l)) {
                return "You won!";
            } else if (computerPositions.containsAll(l)) {
                return "The computer won!";
            }
        }

        if (playerPositions.size() + computerPositions.size() == 9) {
            return "It's a tie!";
        }

        return "";

    }
}