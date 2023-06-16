import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Getting given arguments on command and handle it.
        String boardPath = args[0];
        String movePath = args[1];
        Scanner sc = new Scanner(new File(boardPath));
        Scanner sc1 = new Scanner(new File(movePath));
        FileWriter fileWriter = new FileWriter("output.txt");

        //Variables
        int score=0;
        boolean fall = false;
        int ballRow=0;
        int ballCol=0;
        String moveList = "";
        String board1 = "";
        String[] rows;
        int numRows;
        int numCols;
        char[][] board;
        char[] moves;
        String moves1;
        String[] movesArr;

        //Creating moves and board
        moves1 = sc1.nextLine();
        movesArr = moves1.split(" ");
        moves = new char[movesArr.length];
        for (int i = 0; i < movesArr.length; i++) {
            moves[i] = movesArr[i].charAt(0);
        }

        while(sc.hasNextLine()){
            board1 = board1 + sc.nextLine();
            board1+="\n";
        }


        fileWriter.write("Game board:\n");
        fileWriter.write(board1);

        //finding rows and cols of board
        rows = board1.split("\n");
        numRows = rows.length;
        numCols = rows[0].split(" ").length;

        //starting game
        board = new char[numRows][numCols];
        boardProcess(numRows,numCols,board,rows);
        findPosition(numRows,numCols,board,ballRow,ballCol,fall,moveList,moves,score,fileWriter);

        fileWriter.close();
    }

    public static void move(boolean fall,int ballRow,int ballCol,String moveList,char[][] board,char[] moves,int numCols,int numRows,int score, FileWriter fileWriter) throws Exception{
        int newRow = ballRow;
        int newCol = ballCol;
        //Starting loop of the game
        for(int i=0; i<moves.length; i++){
            String move = String.valueOf(moves[i]);
            if (fall == false){ //check if ball fall or not
                moveList += move +" ";
            }
            switch (move){ // playing the moves in order to moveList
                case "R":
                    newCol++;
                    if(newCol >= numCols){
                        newCol = 0;
                    }
                    break;

                case "L":
                    newCol--;
                    if(newCol<0){
                        newCol = numCols-1;
                    }
                    break;

                case "U":
                    newRow--;
                    if(newRow<0){
                        newRow = numRows-1;
                    }
                    break;

                case "D":
                    newRow++;
                    if(newRow >= numRows){
                        newRow=0;
                    }
                    break;
            }
            if (i==0){
                String letter = String.valueOf(board[newRow][newCol]);
                board[ballRow][ballCol] = letter.charAt(0);
            }

            String newCell =String.valueOf(board[newRow][newCol]);

            if (newCell.equals("H")){

                String space = " ";
                String hole = "H";
                board[ballRow][ballCol] = space.charAt(0);
                board[newRow][newCol]= hole.charAt(0);
                fall = true;
                break;
            } else if (newCell.equals("W")) {
                switch (move){
                    case "R":
                        newCol-=2;
                        if(newCol<0){
                            newCol = numCols-1;
                        }
                        break;

                    case "L":
                        newCol+=2;
                        if(newCol >= numCols){
                            newCol=1;
                        }
                        break;

                    case "U":
                        newRow+=2;
                        if(newRow >= numRows){
                            newRow=0;
                        }
                        break;

                    case "D":
                        newRow-=2;
                        if(newRow<0){
                            newRow = numRows-2;
                        }
                        break;
                }

                if (String.valueOf(board[newRow][newCol]).equals("R")) {
                    String letter = "X";
                    board[ballRow][ballCol] = letter.charAt(0);
                    score+=10;
                } else if (String.valueOf(board[newRow][newCol]).equals("Y")) {
                    String letter = "X";
                    board[ballRow][ballCol] = letter.charAt(0);
                    score+=5;
                } else if (String.valueOf(board[newRow][newCol]).equals("B")) {
                    String letter = "X";
                    board[ballRow][ballCol] = letter.charAt(0);
                    score-=5;
                }else if (String.valueOf(board[newRow][newCol]).equals("X")) {
                    String letter = "X";
                    board[ballRow][ballCol] = letter.charAt(0);
                }else if (String.valueOf(board[newRow][newCol]).equals("D")) {
                    String letter = "D";
                    board[ballRow][ballCol] = letter.charAt(0);
                }else if (String.valueOf(board[newRow][newCol]).equals("L")) {
                    String letter = "L";
                    board[ballRow][ballCol] = letter.charAt(0);
                }else if (String.valueOf(board[newRow][newCol]).equals("G")) {
                    String letter = "G";
                    board[ballRow][ballCol] = letter.charAt(0);
                }else if (String.valueOf(board[newRow][newCol]).equals("P")) {
                    String letter = "P";
                    board[ballRow][ballCol] = letter.charAt(0);
                }else if (String.valueOf(board[newRow][newCol]).equals("O")) {
                    String letter = "O";
                    board[ballRow][ballCol] = letter.charAt(0);
                }else if (String.valueOf(board[newRow][newCol]).equals("F")) {
                    String letter = "F";
                    board[ballRow][ballCol] = letter.charAt(0);
                }else if (String.valueOf(board[newRow][newCol]).equals("N")) {
                    String letter = "N";
                    board[ballRow][ballCol] = letter.charAt(0);
                }

            } else if (newCell.equals("R")) {
                String letter = "X";
                board[ballRow][ballCol] = letter.charAt(0);
                score+=10;
            } else if (newCell.equals("Y")) {
                String letter = "X";
                board[ballRow][ballCol] = letter.charAt(0);
                score+=5;
            } else if (newCell.equals("B")) {
                String letter = "X";
                board[ballRow][ballCol] = letter.charAt(0);
                score-=5;
            }else if (newCell.equals("D")){
                String letter = "D";
                board[ballRow][ballCol] = letter.charAt(0);
            }else if(newCell.equals("X")){
                String letter = "X";
                board[ballRow][ballCol] = letter.charAt(0);
            } else if(newCell.equals("L")) {
                String letter = "L";
                board[ballRow][ballCol] = letter.charAt(0);
            }else if(newCell.equals("G")) {
                String letter = "G";
                board[ballRow][ballCol] = letter.charAt(0);
            }else if(newCell.equals("P")) {
                String letter = "P";
                board[ballRow][ballCol] = letter.charAt(0);
            }else if(newCell.equals("O")) {
                String letter = "O";
                board[ballRow][ballCol] = letter.charAt(0);
            }else if(newCell.equals("F")) {
                String letter = "F";
                board[ballRow][ballCol] = letter.charAt(0);
            }else if(newCell.equals("N")) {
                String letter = "N";
                board[ballRow][ballCol] = letter.charAt(0);
            }
            ballRow = newRow;
            ballCol = newCol;
        }
        if (String.valueOf(board[ballRow][ballCol]).equals("H")){
            String space = " ";
            String hole = "H";
            board[ballRow][ballCol] = space.charAt(0);
            board[newRow][newCol]= hole.charAt(0);
            fall = true;
        }
        else {
            String letter = "*";
            board[ballRow][ballCol] = letter.charAt(0);
        }
        fileWriter.write("\nYour movement is:\n");
        fileWriter.write(moveList);
        fileWriter.write("\n\nYour output is:\n");
        String space = " ";
        board[ballRow][ballCol] = space.charAt(0);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                fileWriter.write(board[i][j] + " ");
            }
            fileWriter.write("\n");

        }
        if(fall == true){
            fileWriter.write("\nGame Over!\n");
            fileWriter.write("Score: "+score);
            fileWriter.close();
        }
        else {
            fileWriter.write("\nScore: "+score);
        }
    }

    public static void boardProcess(int numRows,int numCols,char[][] board,String[] rows){

        for (int i = 0; i < numRows; i++) {
            String[] cols = rows[i].split(" ");
            for (int j = 0; j < numCols; j++) {
                board[i][j] = cols[j].charAt(0);
            }
        }
    }

    public static void findPosition(int numRows,int numCols,char[][] board,int ballRow, int ballCol,boolean fall,String moveList,char[] moves,int score,FileWriter fileWriter) throws Exception {
        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols; j++){
                String value=String.valueOf(board[i][j]);
                if(value.equals("*")){
                    ballRow = i;
                    ballCol = j;
                    break;
                }
            }
        }
        move(fall,ballRow,ballCol,moveList,board,moves,numCols,numRows,score,fileWriter);
    }
}












