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
        return false;
    }

    @Override
    public String whosTurn() {
        return players.entrySet().stream().filter(x -> x.getValue().equals(currentPlayerMark)).findAny().orElse( new AbstractMap.SimpleEntry<String,Character>(String.valueOf(EMPTY_MARK),'_')).getKey();
    }

    @Override
    public boolean placeMark(int row, int col, String player) {
        return false;
    }
}