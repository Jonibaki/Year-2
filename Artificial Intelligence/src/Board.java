/*Md Abu Joni
* Reg NO- 1606072
* Assignment1
*/

import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + (x+1) + ", " + (y+1) + "]";
    }
}


//determined point and score for the game
class PointsAndScores {
    int score;
    Point point;

    PointsAndScores(int score, Point point) {
        this.score = score;
        this.point = point;
    }
}

//board of the game to perform tic tac toe moves
class Board {
    public Point AIMove;
    List<Point> availablePoints; //hold each piece of string
    Scanner scan = new Scanner(System.in); //input
    AI ai = new AI(this);
    int[][] board = new int[3][3];

    public Board() {
    }

    public boolean isGameOver() {//returns true when any of these methods become true

        return (hasXWon() || hasOWon() || getAvailablePoints().isEmpty());
    }

    public boolean hasXWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasOWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
                return true;
            }
        }
        return false;
    }

    public List<Point> getAvailablePoints() { //loop through the list for returns available space/point
        availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }
    
    public int getState(Point point){
    	return board[point.x][point.y];
    }

    public void placeAMove(Point point, int player) {

        board[point.x][point.y] = player;
    }

    public void displayBoard() {
        System.out.println();

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
 		if (board[i][j]==1)           
                    System.out.print("X ");
                else if (board[i][j]==2)
                    System.out.print("O ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }





}
//AI class that uses MINIMAX algorithm search
class AI {
    Board ai; //instance of Board class
    public  AI(Board AIboard){
        ai = AIboard;
        } //constructor that handles instance of Board class as its argument to get the full access of all the methods
    public int AI ( int depth, int player) { // constructor  with two integer types argument; where one determine the player of the game and the depth
        if (ai.hasXWon()) { //AI player returns 1
        return 1;
        }
        if (ai.hasOWon()) { //User return -1
        return -1;
        }
        if (ai.getAvailablePoints().isEmpty()){ //return 0 if there is no player
        return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;


        for (int i =0; i<ai.getAvailablePoints().size(); i++){ //set a point in an available spot in the board
            Point point = ai.getAvailablePoints().get(i);

            if (player == 1){ //AI player gets the highest possible value and prevent to stop user to get minimum value
                ai.placeAMove(point, 1);
                int currentScore = AI(depth+1, 2);
                max= Math.max(currentScore, max);

                if (depth==0){
                    System.out.println("AI score for this position "+ point + " = "+ currentScore); //display all the possible moves on the board
                    }
                if (currentScore>=0){
                    if (depth ==0){
                       ai.AIMove = point;

                    }
                }
                if (currentScore==1){
                    ai.board[point.x][point.y] = 0;
                    break;
                }
                if(i==ai.availablePoints.size()-1 && max<0){
                    if (depth==0){
                        ai.AIMove = point;
                    }
                }
            }
            else if(player==2){ //user get the minimum value to prevent AI to get maximum value
                ai.placeAMove(point, 2);
                int currentScore = AI(depth+1, 1);
                min = Math.min(currentScore, min);

                if (min==-1){
                    ai.board[point.x][point.y]=0;
                    break;
                }

            }
        ai.board[point.x][point.y]=0;

        }
        if (player ==1){
            return max;
        }else{
            return min;
        }
    }

}