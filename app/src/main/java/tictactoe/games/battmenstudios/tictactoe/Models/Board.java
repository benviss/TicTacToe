package tictactoe.games.battmenstudios.tictactoe.Models;


import java.util.ArrayList;

import tictactoe.games.battmenstudios.tictactoe.R;

/**
 * Created by Ben Vissotzky on 3/23/2017.
 */

public class Board {
    public int players;
    public int boardSize;
    private int[] size3GameBoard = {R.id.r0c0,R.id.r0c1,R.id.r0c2,R.id.r1c0,R.id.r1c1,R.id.r1c2,R.id.r2c0,R.id.r2c1,R.id.r2c2};
    private int[] size4GameBoard = {R.id.r0c0,R.id.r0c1,R.id.r0c2,R.id.r0c3,R.id.r1c0,R.id.r1c1,R.id.r1c2,R.id.r1c3,R.id.r2c0,R.id.r2c1,R.id.r2c2,R.id.r2c3,R.id.r3c0,R.id.r3c1,R.id.r3c2,R.id.r3c3};
    private ArrayList<Tile> tiles = new ArrayList<>();

    /*Three different constructors to handle different Game Modes*/
    //Two Players
    public Board(int boardSize) {
        this.boardSize = boardSize;
        createBoard(boardSize);
    }

    //One Player
    public Board(int players, int boardSize, int aiOneDifficulty) {
        this.players = players;
        this.boardSize = boardSize;

    }

    //Two AI
    public Board(int players, int boardSize, int aiOneDifficulty, int aiTwoDifficulty) {
        this.players = players;
        this.boardSize = boardSize;

    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    private void createBoard(int boardSize) {
        switch (boardSize) {
            case 3:
                for (int i = 0; i < size3GameBoard.length; i++) {
                    Tile tile = new Tile(size3GameBoard[i], i);
                    tiles.add(tile);
                }
                break;
            case 4:
                for (int i = 0; i < size4GameBoard.length; i++) {
                    Tile tile = new Tile(size4GameBoard[i], i);
                    tiles.add(tile);
                }
                break;
        }
    }
}
