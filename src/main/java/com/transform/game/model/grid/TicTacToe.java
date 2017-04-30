package com.transform.game.model.grid;

import java.util.AbstractMap;

/**
 * Created by Rajesh on 27-Apr-17.
 */
public class TicTacToe extends Game {

    private char currentPlayerMark;

    public TicTacToe(String player, String counterPlayer) {
        super();
        currentPlayerMark = PLAYER_MARK;
        players.put(player, PLAYER_MARK);
        players.put(counterPlayer, COUNTER_PLAYER_MARK);
        this.player = player;
        this.counterPlayer = counterPlayer;
        initGrid();
    }

    private void initGrid() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = EMPTY_MARK;
            }
        }
    }

    // Print the current grid (may be replaced by GUI implementation later)
    @Override
    public String getPrintBoard() {
        StringBuilder boardDiagram = new StringBuilder();
        boardDiagram.append("-------------\n");
        for (int i = 0; i < 3; i++) {
            boardDiagram.append(OUTER_DELIMITER);
            for (int j = 0; j < 3; j++) {
                boardDiagram.append(grid[i][j] + INNER_DELIMITER);
            }
            boardDiagram.append("\n");
            boardDiagram.append("-------------\n");
        }
        return boardDiagram.toString();
    }

    @Override
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(grid[i][0], grid[i][1], grid[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(grid[0][i], grid[1][i], grid[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(grid[0][0], grid[1][1], grid[2][2]) == true) || (checkRowCol(grid[0][2], grid[1][1], grid[2][0]) == true));
    }
    
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != EMPTY_MARK) && (c1 == c2) && (c2 == c3));
    }

    @Override
    public String whosTurn() {
        return players.entrySet().stream().filter(x -> x.getValue().equals(currentPlayerMark)).findAny().orElse( new AbstractMap.SimpleEntry<String,Character>(String.valueOf(EMPTY_MARK),'_')).getKey();
    }

    @Override
    public boolean placeMark(int row, int col, String player) {
        return false;
    }
    
    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == EMPTY_MARK) {
                    isFull = false;
                }
            }
        }
        return isFull;
    }
    
    public void changePlayer() {
        if (currentPlayerMark == PLAYER_MARK) {
            currentPlayerMark = COUNTER_PLAYER_MARK;
        } else {
            currentPlayerMark = PLAYER_MARK;
        }
    }
}