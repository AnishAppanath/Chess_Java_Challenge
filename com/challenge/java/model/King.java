package com.challenge.java.model;

import com.challenge.java.utility.Constants;

/**
 * Representation of a King piece.
 * 
 * A King moves exactly one square horizontally, vertically, or diagonally.
 * 
 */
public class King extends Piece {
	
	public King() {
		super(0, 0);
	}
	
	public King(int row, int col) {
		super(row, col);
	}
	
	@Override
	public String toString() {
		return Constants.KING_SYMBOL;
	}

	public Boolean isTreatening(Piece p){
		
		// The piece is being threatened by the King if the piece stays in exactly one square horizontally, vertically, or diagonally
		if(Math.abs(this.getRow() - p.getRow()) < 2 && Math.abs(this.getCol() - p.getCol()) < 2  )// Limit a 3x3 area 
			return new Boolean(true);
		
		return new Boolean(false);
	}

}
