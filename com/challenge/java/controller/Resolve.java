package com.challenge.java.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.challenge.java.model.Board;
import com.challenge.java.model.Piece;
import com.challenge.java.model.PieceFactory;

public class Resolve {
	
	public static final PieceFactory pieceFactory = new PieceFactory();

	/**
	 * 
	 * @param board 		- Board details
	 * @param boards 		- All solution boards
	 * @param lastPieces	- Last position for each kind of piece in the board 
	 */
	public void resolve(Board board, HashMap<String, Board> boards, HashMap<String, Piece> lastPieces, boolean printBoards){
		
		ArrayList<String> remainingPieces = board.getRemainingPieces();
		
		// Take the first available piece
		String piece = remainingPieces.remove(0);

		// Last piece on the board of this kind
		Piece lastPiece = lastPieces.get(piece);

		int lastPieceRow = 0;
		int lastPieceColumn = 0;
		
		if (lastPiece != null){
			// Prune duplicate solutions.
			lastPieceRow = lastPiece.getRow();
			lastPieceColumn = lastPiece.getCol()+1;
		}
		
		for(int row=lastPieceRow; row<board.getRows(); row++){
			for(int col=lastPieceColumn; col<board.getColumns(); col++){
				// If it isn't empty skip the iteration
				if(board.getBoard()[row][col] != null)
					continue;
				
				Piece pieceToPut = pieceFactory.getPiece(piece,row, col);
				
				// Check if it is possible to put the piece into the board safely
				if(!pieceToPut.isPossible(board))
					continue;

				// Add piece piece to the board as partial solution
				board.addPiece(pieceToPut);
				
				lastPieces.put(pieceToPut.toString(), pieceToPut);
				
				if(remainingPieces.isEmpty()){
					// If there is not more pieces is a final solution
					// Avoid duplicate results using a unique key (the board itself)
					boards.put(board.toString(), board);
					if (printBoards)
						board.printBoard();
				
				}else{
					// Partial solution. Resolve a smaller problem
					resolve(board, boards,lastPieces,printBoards); 
				}
				
				// Backtracking: Remove the piece of the board
				board.removePiece(pieceToPut);			
			}
			// Reset column
			lastPieceColumn=0;
		}
		
		
		// Backtracking: Return the piece
		remainingPieces.add(0, piece);
		lastPieces.put(piece, null);
	}
		
}
