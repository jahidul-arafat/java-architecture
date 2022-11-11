package org.codeclinic.problems.prb3_NQueen.models;

/**
 * This solution having O(NSquare) time complexity
 * due to the isSafeToPlaceQueen() methods using insider for loop called from another for loop in solveNQueenUtil
 */
public class NQueen {
    private final Integer nQueen;
    private Integer[][] board; // initialize the board with -1

    // constructor
    public NQueen(Integer nQueen) {
        this.nQueen = nQueen;
        this.board = new Integer[this.nQueen][this.nQueen];

        // set the board
        // board-1, all zero initialized
        for (int i = 0; i < this.nQueen; i++) {
            for (int j = 0; j < this.nQueen; j++) {
                this.board[i][j]=0;
            }
        }

        //
    }

    // setter


    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }

    /* the board, initialized with all zeros
         0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0

         */
    public void printBoard(){
        for (int i = 0; i < this.nQueen; i++) {
            for (int j = 0; j < this.nQueen; j++) {
                System.out.print(" "+this.board[i][j]+" ");
            }
            System.out.println();
        }
    }

    // A recursive utility function to solve N Queen Problem
    /*
    1) Start in the leftmost column
    2) If all queens are placed
        return true
    3) Try all rows in the current column.
       Do following for every tried row.
        a) If the queen can be placed safely in this row
           then mark this [row, column] as part of the
           solution and recursively check if placing
           queen here leads to a solution.
        b) If placing the queen in [row, column] leads to
           a solution then return true.
        c) If placing queen doesn't lead to a solution then
           unmark this [row, column] (Backtrack) and go to
           step (a) to try other rows.
    4) If all rows have been tried and nothing worked,
       return false to trigger backtracking.
     */

    public boolean isSafeToPlaceQueen(int row, int col){
        // left horizonal check
        // check the row on the left side
        // check if the left side having a queen(1) already
        // if so, then return false; means queen can't be placed in this [row][col]
        for (int c = 0; c < col; c++) {
            if (this.board[row][c]==1) // means, a queen already there
                return false; // means, queen cant be placed here
        }

        // Check upper and lower diagonal of the left side
        /*
            00  01  02  03  04
            10  11  12  13  14
            20  21  22  23  24
            30  31  32  33  34
            40  41  42  43  44

            Upper Diagonal of [22] -> [11], [00]    // i--, j-- ; i>=0, j>=0
            Lower Diagonal of [22] -> [31], [40]          // i++; j--; i<nQueen, j>=0
         */
        // Left Upper Diagonal
        for (int r = row, c=col; r>=0 && c>=0; r--, c--) {
            if (this.board[r][c]==1)    // if any LEFT upper diagonal already having the Queen, you cant place queen
                return false;

        }

        // Left Lower Diagonal
        for (int r = row, c=col; r<this.nQueen && c>=0; r++, c--) {
            if (this.board[r][c]==1)    // if any LEFT lower diagonal already having the Queen, you cant place queen
                return false;

        }


        return true;
    }
    /**
     *
     * @param currentCol
     * @return
     */
    public boolean solveNQueenUtil(Integer currentCol){
        // base case
        if (currentCol>=this.nQueen) // means all queens has been successfully placed in the board
                                    // means, we have traversed all then columns in the board
            return true;

        // consider the first column and try placing the queen in all the rows one-by-one
        // A column can have only one queen
        // A row can have only one queen
        // no two queens can be place diagonally
        for (int currentRow = 0; currentRow < this.nQueen; currentRow++) {
            // check if the queen is safe to be placed in the row of this column
            // if safe, then place the queen in this [column][row]
            if (isSafeToPlaceQueen(currentRow,currentCol)){
                this.board[currentRow][currentCol]=1; // place the queen

                // recursive call the nexts to see, if placing a queen here can lead to a solution
                // if yes, means lead to a solutio, keep the queen here
                if (solveNQueenUtil(currentCol+1))
                    return true;
                // else, if placing queen here cant lead to a solution, backtrack; means remove the queen from here
                this.board[currentRow][currentCol]=0;
            }

        }
        return false;
    }

    public boolean solveNQueen(){
        if (solveNQueenUtil(0)==false){
            System.out.println("Solution doesn't exist");
            return false;
        }
        printBoard();
        return true;
    }



}
