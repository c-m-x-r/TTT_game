import java.util.Scanner;
/**
 * Write a description of class TTT here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TTT
{
    public static void main(String [] args)
    {
        String reset="yes";
        int win = 0;
        while (true)
        {
            System.out.println("Welcome to Tic Tac Toe");
            Scanner userInput = new Scanner(System.in);
            String [] [] ttt = new String [3][3];
            int turn=1;
            int row;
            int col;
            win=0;
            for(int r=0; r < ttt.length; r++)
            {
                for (int c = 0; c<ttt[0].length; c++)
                {
                    ttt[r][c]=( " " );
                }
            }
            while (turn < 10)
            {
                //every odd turn the game plays an x
                //every even turn the game plays an o
                System.out.println("which row do you want to play in?");
                row= userInput.nextInt();

                System.out.println("which column do you want to play in?");
                col= userInput.nextInt();

                while( row>2 || col>2 || row<0 || col<0)
                {
                    System.out.println("that space does not exist. choose another one:");
                    System.out.println("which row do you want to play in?");
                    row= userInput.nextInt();

                    System.out.println("which column do you want to play in?");
                    col= userInput.nextInt();
                }

                while(!(ttt[row][col]==" "))
                {
                    System.out.println("That space is occupied, choose another space:") ;
                    System.out.println("which row do you want to play in?");
                    row= userInput.nextInt();

                    System.out.println("which column do you want to play in?");
                    col= userInput.nextInt();
                }

                if(turn%2==1)
                { 
                    ttt[row][col]="X";
                }
                else
                {
                    ttt[row][col]="O";
                }

                //lets print the board
                System.out.println( ttt[0][0] +"| "+ ttt[0][1] +" |" + ttt[0][2]);
                System.out.println("--------");
                System.out.println( ttt[1][0] +"| "+ ttt[1][1] +" |" + ttt[1][2]);
                System.out.println("--------");
                System.out.println( ttt[2][0] +"| "+ ttt[2][1] +" |" + ttt[2][2]);

                System.out.println(" " );
                System.out.println(" " );

                turn++;
                

                if( ttt[0][0]=="X"&& ttt[0][1]=="X" && ttt[0][2]=="X")
                {
                    System.out.print( ttt[0][0] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[1][0]=="X"&& ttt[1][1]== "X" && ttt[1][2] == "X")
                {
                    System.out.print( ttt[1][0] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[2][0]=="X"&& ttt[2][1]=="X" && ttt[2][2] =="X")
                {
                    System.out.print( ttt[2][0] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[0][0]=="X"&&ttt[1][0]=="X"  && ttt[2][0]=="X")
                {
                    System.out.print( ttt[0][0] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[0][1]=="X"&& ttt[1][1]=="X" && ttt[2][1]=="X")
                {
                    System.out.print( ttt[1][1] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[0][2]=="X"&& ttt[1][2]=="X" && ttt[2][2]=="X")
                {
                    System.out.print( ttt[2][1] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[0][0]=="X"&& ttt[1][1]=="X" && ttt[2][2]=="X")
                {
                    System.out.print( ttt[1][1] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[2][0]=="X"&& ttt[1][1]=="X" && ttt[0][2]=="X")
                {
                    System.out.print( ttt[1][1] + " wins the game");
                    win=1;
                    break;
                }
                if( ttt[0][0]=="O"&& ttt[0][1]=="O" && ttt[0][2]=="O")
                {
                    System.out.print( ttt[0][0] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[1][0]=="O"&& ttt[1][1]== "O" && ttt[1][2] == "O")
                {
                    System.out.print( ttt[1][0] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[2][0]=="O"&& ttt[2][1]=="O" && ttt[2][2] =="O")
                {
                    System.out.print( ttt[2][0] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[0][0]=="O"&&ttt[1][0]=="O"  && ttt[2][0]=="O")
                {
                    System.out.print( ttt[0][0] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[0][1]=="O"&& ttt[1][1]=="O" && ttt[2][1]=="O")
                {
                    System.out.print( ttt[1][1] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[0][2]=="O"&& ttt[1][2]=="O" && ttt[2][2]=="O")
                {
                    System.out.print( ttt[2][1] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[0][0]=="O"&& ttt[1][1]=="O" && ttt[2][2]=="O")
                {
                    System.out.print( ttt[1][1] + " wins the game");
                    win=1;
                    break;
                }
                else if (ttt[2][0]=="O"&& ttt[1][1]=="O" && ttt[0][2]=="O")
                {
                    System.out.print( ttt[1][1] + " wins the game");
                    win=1;
                    break;
                }



            }
            if (win==0)
                {
                 System.out.println("it's a tie");
                }
            System.out.println() ;
            System.out.println("good game");

            System.out.println("Want to play again?");
            reset=userInput.next();
            
            System.out.println("lets play again then");
            System.out.println(" ");
        }
    }
}
