package com.challenge.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.challenge.java.model.Board;
import com.challenge.java.model.Piece;
import com.challenge.java.utility.Constants;

public class Chess {

	public static void main(String[] args) {

		Board board = null;

		// Default inputs
		int rows = 7;
		int cols = 7;
		int kings = 2;
		int queens = 2;
		int bishops = 1;
		int knights = 1;
		int rooks = 1;


		Scanner in = new Scanner(System.in);
		System.out.println(Constants.DEFAULT_INPUT);
		System.out.println(Constants.EMPTY);
		System.out.println(Constants.OPTION_ONE);
		System.out.println(Constants.OPTION_TWO);
		System.out.println(Constants.OPTION_THREE);
		System.out.println(Constants.OPTION_FOUR);
		System.out.print(Constants.SELECT);
		int  opt = validateInput(in, Constants.SELECT, Constants.EMPTY);   

		while (opt < 1 || opt > 4){
			System.out.print(Constants.ERROR);
			opt = validateInput(in, Constants.SELECT, Constants.EMPTY); 
		}

		// Custom board - input rows and columns
		// Input the number of each pieces
		if(opt == 3 || opt == 4){
			System.out.println(Constants.BOARD_SIZE);
			System.out.print(Constants.ROWS);
			rows = validateInput(in, Constants.ROWS, Constants.EMPTY);
			System.out.print(Constants.COLUMNS);
			cols = validateInput(in, Constants.COLUMNS, Constants.EMPTY);
			System.out.println();
			System.out.println(Constants.OCCURENCES);
			System.out.print(Constants.KING);
			kings = validateInput(in, Constants.KING, Constants.KING_WORDS);
			System.out.print(Constants.QUEEN);
			queens = validateInput(in, Constants.QUEEN, Constants.QUEEN_WORDS);
			System.out.print(Constants.BISHOP);
			bishops = validateInput(in,Constants.BISHOP, Constants.BISHOP_WORDS);
			System.out.print(Constants.KNIGHT);
			knights = validateInput(in, Constants.KNIGHT, Constants.KNIGHT_WORDS);
			System.out.print(Constants.ROOK);
			rooks = validateInput(in, Constants.ROOK, Constants.ROOK_WORDS);
		}

		boolean printBoards = false;
		if(opt == 2 || opt == 4){
			printBoards = true;
		}

		System.out.println();
		System.out.println();

		board = fillboard(rows, cols, kings, queens, bishops, knights, rooks);

		HashMap<String, Board> boards = new HashMap<String, Board>(); 
		long start = System.currentTimeMillis();

		Resolve resolve = new Resolve();

		resolve.resolve(board, boards, new HashMap<String, Piece>(), printBoards);

		long end = System.currentTimeMillis();

		long totalTime = end - start;

		System.out.println(Constants.TOTAL_BOARDS + boards.size());

		if (totalTime > 60000){
			System.out.println(Constants.TOTAL_TIME + TimeUnit.MILLISECONDS.toMinutes(totalTime) + Constants.MINUTES + (TimeUnit.MILLISECONDS.toSeconds(totalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime))) + Constants.SECONDS);
		} else if (totalTime > 1000){
			System.out.println(Constants.TOTAL_TIME + TimeUnit.MILLISECONDS.toSeconds(totalTime) + Constants.SECONDS);
		} else {
			System.out.println(Constants.TOTAL_TIME + (totalTime) + Constants.MILLISECONDS);
		}

	}


	/**
	 * Fill the board with input pieces
	 */
	private static Board fillboard(int rows, int cols, int kings, int queens,
			int bishops, int knights, int rooks) {

		Board board = new Board(rows, cols);

		ArrayList<String> remainingPieces = board.getRemainingPieces();

		for (int i = 0; i < queens; i++) {
			remainingPieces.add(Constants.QUEEN_SYMBOL);
		}			
		for (int i = 0; i < bishops; i++) {
			remainingPieces.add(Constants.BISHOP_SYMBOL);
		}			
		for (int i = 0; i < rooks; i++) {
			remainingPieces.add(Constants.ROOK_SYMBOL);
		}			
		for (int i = 0; i < knights; i++) {
			remainingPieces.add(Constants.KNIGHT_SYMBOL);
		}			
		for (int i = 0; i < kings; i++) {
			remainingPieces.add(Constants.KING_SYMBOL);
		}

		return board;

	}


	/**
	 * Read an int from the input. 
	 */
	private static int validateInput(Scanner in, String inputStr, String piece) {
		int input;
		try {
			input = in.nextInt();
			if ((piece == Constants.KING_WORDS || piece == Constants.QUEEN_WORDS) && input > 2){
				System.out.print(Constants.CHESS_RULE + piece + Constants.GREATER_THAN_TWO + Constants.CORRECT_VALUE + inputStr);
				return validateInput(in,inputStr,piece);
			}else if ((piece == Constants.ROOK_WORDS || piece == Constants.KNIGHT_WORDS || piece == Constants.BISHOP_WORDS) && input > 4){
				System.out.print(Constants.CHESS_RULE + piece + Constants.GREATER_THAN_FOUR + Constants.CORRECT_VALUE + inputStr);
				return validateInput(in,inputStr,piece);
			}
		} catch (Exception e) {
			System.out.print(Constants.INCORRECT_VALUE + inputStr );
			in.next();
			return validateInput(in,inputStr,piece);
		}
		return input;
	}

}

