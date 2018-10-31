package queen;

import java.util.Scanner;

public class QueenProblem 
{ 
      
    void printSolution(int board[][], int N) 
    { 
    	
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print("|" + board[i][j] 
                                 + "|"); 
            System.out.println(); 
        } 
    } 
  
    boolean isSafe(int board[][], int row, int col, int N) 
    { 
        int i;
        int j; 
  
        // Checks this row on left side 
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false; 
            }
        }
               
        // Checks upper diagonal on left side 
        for (i=row, j=col; i>=0 && j>=0; i--, j--) { 
            if (board[i][j] == 1) {
                return false; 
            }
        }
          
        // Checks lower diagonal on left side 
        for (i=row, j=col; j>=0 && i<N; i++, j--) {
            if (board[i][j] == 1) {
                return false; 
            }
        }
        // Checks lower diagonal on right side
        for (i=row, j=col; j < N && i < N; i++, j++) {
            if (board[i][j] == 1) {
                return false; 
            }
        } 
        
        // Checks upper diagonal on right side
        for (i=row, j=col; i >=0 && j < N; i--, j++) { 
            if (board[i][j] == 1) {
                return false; 
            }
        } 
        
        return true; 
    } 
    
    // Checks if all queens have been places
    boolean checkQ(int board[][], int N) {
    	
    	int q = 0; // number of queens
    	
    	for (int i = 0; i < N;i++) {
    		for(int j = 0; j < N;j++) {
    			if(board[i][j] == 1) {
    				q++;
    			}
    		}
    	}
    	
    	if (q == N) {
    		return true;
    	}
    	
    	return false;
    }
    
  
    boolean qSolver(int board[][], int col, int N) 
    { 													
        // checks if all required number of queens has been placed on the board  	
    	if (checkQ(board, N) == true) {
        	return true;
        }
          
        for (int i = 0; i < N; i++) // traverse the row
        { 
           
            if (isSafe(board, i, col, N)) 
            { 
               
                board[i][col] = 1; 
  
                
                if (qSolver(board, col + 1, N) == true) { 
                    return true; 
                }
                board[i][col] = 0; // backtracks 
            } 
        } 
   
        return false; 
    } 
  
    boolean solveQP(int N) 
    { 
    	  	
    	
    	int[][] board = new int[N][N];
    	
        if (qSolver(board, 0, N) == false) 
        { 
            System.out.print("Solution does not exist"); 
            return false; 
        } 
     
        printSolution(board, N); 
        return true; 
    } 
  
    
    public static void main(String args[]) 
    { 
    	Scanner reader = new Scanner(System.in);
    	System.out.println("Enter a number: ");
    	int N = reader.nextInt();
    	reader.close();
    	
        QueenProblem Queen = new QueenProblem(); 
        System.out.println("Solution: "); // i + 1
        Queen.solveQP(N); 
        
    } 
} 
