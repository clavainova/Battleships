import java.util.Random;

public class playingBoard
{
    //"create" the board by filling the array
    public static void createBoard(int[][] board)
    {
        for(int i = 0 ; i < 5 ; i++ ) //i is row
        {
            for(int j = 0 ; j < 5 ; j++ ) //j is column
            {
                board[i][j] = -1;
            }
        }
    }

    //print the board
    public static void showBoard(int[][] board)
    {
        System.out.println("\t1 \t2 \t3 \t4 \t5");
        System.out.println();

        for(int i = 0 ; i < 5 ; i++ )
        {
            System.out.print((i + 1) + ""); //i is rows
            for(int j = 0 ; j < 5 ; j++ )
            {
                if(board[i][j] == -1) //j is columns
                {
                    System.out.print("\t"+"~"); //if it has not yet been hit print the sea (~)
                }
                else if(board[i][j] == 0)
                {
                    System.out.print("\t"+"O"); //if it has been attacked but not hit print O
                }
                else if(board[i][j] == 1)
                {
                    System.out.print("\t"+"X"); //if it has been attacked and hit print X
                }
            }
            System.out.println();
        }
    }

    //place the ships
    public static void placeShips(int[][] ships)
    {
        Random random = new Random(); //generate random locations for ships

        for(int ship = 0 ; ship < 3 ; ship++) //place the three ships
        {
            ships[ship][0]=random.nextInt(5); //set bounds for coordinates so that they don't go outside the array
            ships[ship][1]=random.nextInt(5);

            //check that the move hasn't already been made
            //if it was then choose a new random location
            for(int last=0 ; last < ship ; last++)
            {
                if( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) )
                    do
                    {
                        ships[ship][0] = random.nextInt(5);
                        ships[ship][1] = random.nextInt(5);
                    }
                    while( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) );
            }

        }
    }

}
