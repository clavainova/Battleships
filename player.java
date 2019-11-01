import java.util.Scanner;

public class player
{
    //store input
    public static int[] attack()
    {
        Scanner input = new Scanner(System.in);
        int[] aRowCol = new int[2]; 

        System.out.print("Row: ");
        aRowCol[0] = input.nextInt() - 1;

        System.out.print("Column: ");
        aRowCol[1] = input.nextInt() - 1;
        
        if(aRowCol[0] == 99 || aRowCol[1] == 99) //if when testing I want to terminate to save time I can type in "100" and the program will end, without returning an error message
        {
            System.exit(0);
        }
        
        return aRowCol;
    }
    //check if the location has hit
    public static boolean hit(int row, int col, int[][] ships)
    {
        for(int ship = 0; ship < ships.length; ship++)
        {
            if((row == ships[ship][0]) && (col == ships[ship][1]))
            {
                System.out.printf("You hit a ship located in (" + (row + 1) + ", " + (col + 1) + ")\n");
                return true;
            }  
        }
        return false;
    }

    public static boolean valid(int testValue)
    {
        return true;
    }

    public static int validRange(int testValue)
    {
        if((testValue < 0) || (testValue > 5))
        {
            return 666;
        }
        return 0;
    }
}