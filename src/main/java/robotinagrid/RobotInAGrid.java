package robotinagrid;

import java.util.ArrayList;
import java.util.List;

public class RobotInAGrid {
	
	/**
	 * 
	 * Problem: Imagine a robot sitting on the upper left corner of grid with r rows
	 * and c columns. The robot can only move in two directions, right and down, but
	 * certain cells are "off limits" such that the robot cannot step on them.
	 * Design an algorithm to find a path for the robot from the top left to the
	 * bottom right.
	 *
	 */
	
	private boolean addPath(boolean[][] board, int row, int col, List<Block> path) {
		if(!board[row][col] || col<0 || row<0) {
			return false;
		}
		boolean origin = (row==0) && (col==0);
		if(addPath(board, row, col - 1, path) || addPath(board, row - 1, col, path) || origin) {
			Block newBlock = new Block(row, col);
			path.add(newBlock);
			return true;
		}
		return false;
	}
	
	public List<Block> getPath(boolean[][] board){
		if(board == null || board.length == 0) {
			return null;
		}
		List<Block> path = new ArrayList<Block>();
		if(addPath(board, board.length - 1, board[0].length - 1, path)) {
			return path;
		}
		return null;
	}

}
