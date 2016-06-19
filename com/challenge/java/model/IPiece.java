package com.challenge.java.model;

/**
 * Abstract class for all board pieces
 * 
 */
public interface  IPiece {


	/**
	 * Checks if the piece p is being threatened by this piece.
	 * 	
	 * @param p
	 *
	 * @return True if the piece is threatened
	 */
	abstract Boolean isTreatening(Piece p);


}
