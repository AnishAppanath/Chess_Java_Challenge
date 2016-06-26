package com.challenge.java.model;

import com.challenge.java.utility.Constants;

/**
 * Factory pattern 
 * 
 */
public class PieceFactory {
		
		/**
		 * Get an object of type piece in the default position [0,0]
		 * 
		 * @param pieceType
		 * @return
		 */
	   public static Piece getPiece(String pieceType){
		   if(Constants.KING_SYMBOL.equals(pieceType)){
	 			return new King();
	 		} else if(Constants.ROOK_SYMBOL.equals(pieceType)){
	 			return new Rook();
	 		} if(Constants.KNIGHT_SYMBOL.equals(pieceType)){
	 			return new Knight();
	 		} else if(Constants.QUEEN_SYMBOL.equals(pieceType)){
	 			return new Queen();
	 		} else if(Constants.BISHOP_SYMBOL.equals(pieceType)){
	 			return new Bishop();
	 		} else return null;
	   }
	      
	    /**
	     * Get an object of type piece in the default position  
	     *   
	     * @param pieceType
	     * @param row
	     * @param col
	     * @return
	     */
	   public static Piece getPiece(String pieceType, int row, int col){
	      	if(Constants.KING_SYMBOL.equals(pieceType)){
	 			return new King(row, col);
	 		} else if(Constants.ROOK_SYMBOL.equals(pieceType)){
	 			return new Rook(row, col);
	 		} if(Constants.KNIGHT_SYMBOL.equals(pieceType)){
	 			return new Knight(row, col);
	 		} else if(Constants.QUEEN_SYMBOL.equals(pieceType)){
	 			return new Queen(row, col);
	 		} else if(Constants.BISHOP_SYMBOL.equals(pieceType)){
	 			return new Bishop(row, col);
	 		} else return null;

	  }
		      
}
