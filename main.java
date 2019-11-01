public class main {
    public static void main(String[] args) {

        int row = 0; //formed later from the array, named for clarity and easy reading
        int col = 0;
        int[][] board = new int[5][5]; //an array to be the board
        int[][] ships = new int[3][2]; //an array to contain the ship locations
        int attackcount = 0; //number of attacks made
        int hits = 0; //number of ships hit
        int testValue; //row/col will become this to be checked for validity

        playingBoard board1 = new playingBoard(); //create new board
        player player1 = new player(); //create new player

        board1.createBoard(board); //set up the board
        board1.placeShips(ships); //set up the ships

        System.out.println();

        int[] RowCol = new int[2]; // stores a row and column pair
        do
        {
            board1.showBoard(board); //show the board

            RowCol = player1.attack(); //asks question for coordinates, returns what they input (form of int row, int col)
            row = RowCol[0]; //changed for clarity
            col = RowCol[1];

            //******************THE VALIDATION SECTION******************
            testValue = row;
            if(player1.validRange(testValue) == 666) //if it failed the requirements to be a coordinate the return will be 666
            {
                System.out.println("\nThat is not a valid number! Your coordinates should be between 1 and 5. You will now reenter your coordinates, hopefully valid ones this time.");
                System.out.println();
                player1.attack();
            }
            
            testValue = col; //THIS ISN'T WORKING!!!!! - how else do I set?
            if(player1.validRange(testValue) == 666) //if it failed the requirements to be a coordinate the return will be 666
            {
                System.out.println("\nThat is not a valid number! Your coordinates should be between 1 and 5. You will now reenter your coordinates, hopefully valid ones this time.");
                System.out.println();
                player1.attack();
            }
            if((board[row][col] == 0) || (board[row][col] == 1)) //if the square has already been hit
            {
                System.out.println("\nYou've already fired on that square! You will now reenter your coordinates, hopefully valid ones this time.");
                System.out.println();
                player1.attack();
            }
            //******************THE VALIDATION SECTION******************
            
            attackcount++;//add to the number of attacks (attempts - all regardless of success) made

            if(player1.hit(row, col, ships)) //if the ships are hit
            {
                hits++; //add to the count of hits        
                board[row][col] = 1; //add to the array containing the board to show the hit
            }  
            else
            {
                board[row][col] = 0; //add to the array containing the board to show the miss
            }
        }
        while(hits < 3);//three hits are needed to end the game

        System.out.println("\n\n\nThe game is over. You sunk the ships in "+ attackcount +" attacks :^)");
        board1.showBoard(board); //show the board so they can see it with all the ships eliminated
    }

}
