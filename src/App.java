public class App {
    public static void main(String[] args) throws Exception {
        char [][] gameBoard = {{' ', '|', ' ', '|', ' '}, {'-', '|', '-', '|', '-'}, {' ', '|', '', '|', ' '}, {'-', '|', '-', '|', '-'}, {' ', '|', ' ', '|', ' '}};

        for(char[] row: gameBoard) {
            for(char c: row) {
                System.out.print(c);
            }
        System.out.println();
        }
        
    }
}