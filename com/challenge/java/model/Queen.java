package com.challenge.java.model;

import com.challenge.java.utility.Constants;

/**
 * Representation of a Queen piece.
 * 
 * A Queen moves any number of vacant squares in a horizontal, vertical, or diagonal direction.
 * 
 */
public class Queen extends Piece {
	
	public Queen() {
		super(0, 0);
	}
	
	public Queen(int row, int col) {
		super(row, col);
	}
	
	@Override
	public String toString() {
		return Constants.QUEEN_SYMBOL;
	}

	public Boolean isTreatening(Piece p){
		// The piece is being threatened by the Queen if the piece stays in any square in a horizontal, vertical, or diagonal direction.
		if(  this.getRow() == p.getRow() // Horizontal
				|| this.getCol() == p.getCol() // Vertical      
				|| (Math.abs(this.getRow() - p.getRow()) == Math.abs(this.getCol() - p.getCol())) // Diagonal 
				)
			return new Boolean(true);
		
		return new Boolean(false);
	}

}
