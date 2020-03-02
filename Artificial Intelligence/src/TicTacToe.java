/*Md Abu Joni
* Reg NO- 1606072
* Assignment1
*/

import java.util.*;

public class TicTacToe {

    public static void main(String[] args) {
        Board b = new Board();
        Point p = new Point(0, 0);
        Random rand = new Random();
        b.displayBoard();

        System.out.println("Who makes first move? (1)AI (2)User: ");
        int choice = b.scan.nextInt();

        if(choice == 1){ //AI making choices
            p.x = rand.nextInt(3);
            p.y = rand.nextInt(3);
            b.placeAMove(p, 1);
            b.displayBoard();
        }
        
        while (!b.isGameOver()) {
            
            System.out.println("Your move: line (1, 2, or 3) column (1, 2, or 3)");
            Point userMove = new Point(b.scan.nextInt()-1, b.scan.nextInt()-1); //array position of the game point


	    while (b.getState(userMove)!=0) {
	    	System.out.println("Invalid move. Make your move again: ");
	    	userMove.x=b.scan.nextInt()-1;
	    	userMove.y=b.scan.nextInt()-1;
	    }
            b.placeAMove(userMove, 2);  
            b.displayBoard();
            
            if (b.isGameOver()) {
                break;
            } 
                       
            //minimax search of class AI.
            do {
                b.ai.AI(0,1);

	    } while (b.getState(b.AIMove)!=0);
            b.placeAMove(b.AIMove, 1);
            b.displayBoard();
        }


        if (b.hasXWon()) {
            System.out.println("Unfortunately, you lost!");
        } else if (b.hasOWon()) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a draw!");
        }

    }
    
}