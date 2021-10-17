import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class TTT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TTT
{
    public static void main (String args [])
    { 
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!\n");
        //play against computer
        System.out.println("Would you like to play against computer?");
        String response = new String ("");
        //bool for playing against computer
        boolean computer = false;
        //int to decide the turn order
        int play_order = 1;
        response = userInput.next();
        boolean hints = false;
        if (response.equalsIgnoreCase("yes"))
        {
            computer = true;
            System.out.println("Do you want to play first?");
            response = userInput.next();
            if (response.equalsIgnoreCase("no"))
            {
                play_order = 0;
            }
        }
        else 
        {
            System.out.println(response + ", huh. Play against yourself then.");
        }

        System.out.println("Show hints?");
        response = userInput.next();
        if (response.equalsIgnoreCase("yes"))
        {
            hints = true;
            System.out.println("\nHints will now be displayed.\n");
        }
        else
        {
            System.out.println("\nHints will not be displayed.\n");
        }

        //Example Board
        System.out.println("This is the board, Input a square value to play.");
        int [][] board_ex = new int [3][3];
        for (int r = 0; r < board_ex.length; r++)
        {
            for (int c = 0; c < board_ex[0].length;c++)   
            {
                board_ex[r][c] = (int)(c+ 1 + r*3);
                System.out.print(board_ex[r][c] + " ");
                if ( c < (board_ex[0].length -1))
                {
                    System.out.print("| ");
                }
                else if ( r < (board_ex.length -1))
                {
                    System.out.println("\n---------");
                }
            }

        }

        System.out.println("\n\n");;

        //Board with strings, for real
        String [][] board = new String [3][3];

        for (int r = 0; r < board.length; r++)
        {
            for (int c = 0; c < board[0].length;c++)   
            {
                board[r][c] = "_";
            }
        }
        System.out.println("Input a square to begin. Input 0 to show the example board.");
        //start the game

        //bools for checking wins and predicting ties
        boolean win = false;
        boolean xcouldwin = false;
        boolean ocouldwin = false;
        //missed turns counter
        int missedturns = 0;
        // used for predicting ties
        int wins = 0;
        //computer's input, defaults to 5 for best result
        int comp_choice = 5;
        //player's input
        int square = 0;

        int input_row = 0;
        int input_column = 0;

        String player = new String ("X");

        // start counting turns (18 to count for maximum of 9 missed turns)
        for (int turn = 0; turn < 18; turn++)
        {
            System.out.println("\n\nTurn "+ (turn+1) + ":");

            if (turn % 2 == play_order && computer == true)
            {
                square = comp_choice;
                System.out.println( "The computer plays in space " + square);
            }
            else
            {   System.out.print("\nInput a square to play in \n");
                square = userInput.nextInt();
            }

            //reprint example board
            if (square == 0)
            {
                for (int r = 0; r < board_ex.length; r++)
                {
                    for (int c = 0; c < board_ex[0].length;c++)   
                    {
                        board_ex[r][c] = (int)(c+ 1 + r*3);
                        System.out.print(board_ex[r][c] + " ");
                        if ( c < (board_ex[0].length -1))
                        {
                            System.out.print("| ");
                        }
                        else if ( r < (board_ex.length -1))
                        {
                            System.out.println("\n---------");
                        }
                    }
                    System.out.println();
                }
                square = userInput.nextInt();
            }

            // convert number into index/////////////////
            input_row = (int)(square/3.1);
            input_column = (int)((square-1)%3) ;

            //////////////////////////////

            //select X or O
            if (turn%2 ==0)
            {
                player = "X";
            }
            else
            {
                player = "O";
            }

            //Check for occupied square and play
            if (board[input_row][input_column] == "_")
            {

                board[input_row][input_column] = player ;

            }
            else
            {
                System.out.println("Whoops, that space is already taken.\nLooks like you lost your turn."); 
                missedturns++;
            }

            //Show the current state of the board
            for (int r = 0; r < board.length; r++)
            {
                for (int c = 0; c < board[0].length;c++)   
                {
                    System.out.print("_" + board[r][c] + "_");
                    if ( c < (board[0].length -1))
                    {
                        System.out.print("|");
                    }
                    else if ( r < (board.length -1))
                    {
                        System.out.println(" ");
                    }
                }

            }
            System.out.println(" ");
            //Check for a win:

            //horizontal victory
            for (int i=0; i<board.length;i++)
            {
                if (board[i][0]==board[i][1] && board [i][0] == board[i][2] && board[i][0] != "_")
                {
                    System.out.println(player + " wins the game!");
                    win = true;
                }
            }
            //vertical victory
            for (int i=0; i<board.length;i++)
            {
                if (board[0][i]==board[1][i] && board [0][i] == board[2][i] && board[0][i] != "_")
                {
                    System.out.println(player + " wins the game!");
                    win = true;
                }
            }
            //diagonal victory
            if (board[1][1]==board[0][0] && board [1][1] == board[2][2] && board[1][1] != "_")
            {
                System.out.println(player + " wins the game!");
                win = true;
            }
            if (board[1][1]==board[0][2] && board [1][1] == board[2][0] && board[1][1] != "_")
            {
                System.out.println(player + " wins the game!");
                win = true;
            }

            if (win == true)
            {
                System.out.println("Game over");
                break;
            }

            /// Checking for ties and compute next moves
            for (int r = 0; r < board.length; r++)
            {
                for (int c = 0; c < board[0].length;c++)   
                {
                    //locate empty square
                    if (board[r][c] == "_")
                    {
                        //set to x
                        board [r][c] = "X";
                        //see if x wins

                        //horizontal victory
                        for (int i=0; i<board.length;i++)
                        {
                            if (board[i][0]==board[i][1] && board [i][0] == board[i][2] && board[i][0] != "_")
                            {
                                xcouldwin = true;
                            }
                        }
                        //vertical victory
                        for (int i=0; i<board.length;i++)
                        {
                            if (board[0][i]==board[1][i] && board [0][i] == board[2][i] && board[0][i] != "_")
                            {

                                xcouldwin = true;
                            }
                        }
                        //diagonal victory
                        if (board[1][1]==board[0][0] && board [1][1] == board[2][2] && board[1][1] != "_")
                        {

                            xcouldwin = true;
                        }
                        if (board[1][1]==board[0][2] && board [1][1] == board[2][0] && board[1][1] != "_")
                        {

                            xcouldwin = true;
                        }

                        //set to O
                        board [r][c] = "O";
                        //see if O wins
                        //horizontal victory
                        for (int i=0; i<board.length;i++)
                        {
                            if (board[i][0]==board[i][1] && board [i][0] == board[i][2] && board[i][0] != "_")
                            {
                                ocouldwin = true;
                            }
                        }
                        //vertical victory
                        for (int i=0; i<board.length;i++)
                        {
                            if (board[0][i]==board[1][i] && board [0][i] == board[2][i] && board[0][i] != "_")
                            {

                                ocouldwin = true;
                            }
                        }
                        //diagonal victory
                        if (board[1][1]==board[0][0] && board [1][1] == board[2][2] && board[1][1] != "_")
                        {

                            ocouldwin = true;
                        }
                        if (board[1][1]==board[0][2] && board [1][1] == board[2][0] && board[1][1] != "_")
                        {

                            ocouldwin = true;
                        }

                        // check if winnable, computer plays the square

                        if (xcouldwin == true)
                        {
                            if(hints)
                            {
                                System.out.println("X could win next turn in space [" + r +"] [" + c + "]");
                            }
                            comp_choice = (int)(Math.floor(r))*3 + c + 1;
                            xcouldwin = false;
                            wins ++;
                        }
                        if (ocouldwin == true)
                        {
                            if (hints)
                            {
                                System.out.println("O could win next turn in space [" + r +"] [" + c + "]");
                            }
                            comp_choice = (int)(Math.floor(r))*3 + c + 1;
                            ocouldwin = false;

                            wins ++;
                        }

                        //restore original value and state
                        board[r][c] = "_";
                        xcouldwin = false;
                        ocouldwin = false;

                    }
                }
            }
            //System.out.println("wins = " + wins + ", turn :" + turn);

            //at turn 8 just play the last square please( a weird bug)

            if( turn == 7+missedturns && wins == 0)
            {
                for (int i=1; i <10 ;i++)
                { 
                    if ( board[(int)((i)/3.1)][((i)-1)%3] == "_")
                    {
                        comp_choice = i;

                    }
                }
            }

            //computer chooses corner square

            else if(turn != 1 && wins == 0)
            {
                for (int i = 0; i<5; i++)
                {
                    //check all corner squares, plays 9 first
                    if ( board[(int)((i*2+1)/3.1)][((i*2+1)-1)%3] == "_")
                    {
                        comp_choice = i*2+1;
                        if ((int)(Math.random()*2) == 0)
                        {
                            break;
                        }
                    }

                }

            }

            //System.out.println("Computer will play in space " + comp_choice);

            //checks for ties
            boolean tie = false;
            if (turn > (6+missedturns) && turn <8+missedturns && wins ==0)
            {
                System.out.println("\nIt's a Cat's Game!\nKeep playing?");
                response = userInput.next();

                if (response.equalsIgnoreCase("yes"))
                {
                    System.out.println("Let's keep going");
                    tie = true;
                }
                else
                {
                    win = true;
                }
            }

            //computeb all squares filled
            boolean complete = true;
            for (int r = 0; r < board.length; r++)
            {
                for (int c = 0; c < board[0].length;c++)   
                {
                    if (board[r][c] == "_")
                    {
                        complete = false;
                    }
                }

            }

            if (complete)
            {
                win = true;
            }

            //game over
            if (win == true )
            {
                if(tie)
                {
                    System.out.println("It's a tie.");
                }
                System.out.println("\nGame over\n" + "missed turns:" + missedturns + "\nGood game!");
                
                break;
            }
            wins = 0;
            if (turn == 18)
            {
                System.out.println("That's enough, game over.");
            }
            
        }

    }  
}

