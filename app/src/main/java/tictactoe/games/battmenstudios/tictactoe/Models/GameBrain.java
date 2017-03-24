package tictactoe.games.battmenstudios.tictactoe.Models;

import java.util.ArrayList;

/**
 * Created by Ben Vissotzky on 3/23/2017.
 */

public class GameBrain {
    public ArrayList<int[]> winCombos = new ArrayList<>();

    public ArrayList<int[]> getWinCombos(int boardSize) {
        int finalTile = boardSize * boardSize - 1;

        //Determine Horizontal Win Combos
        int currentRow = 1;
        for (int i = 0; i < finalTile; i++) {
            if(i == boardSize * currentRow){
                currentRow++;
            }
            if (i + 2 < boardSize * currentRow) {
                int[] winCombo = {i, i + 1, i + 2};
                winCombos.add(winCombo);
            }
        }
//        Determine Vertical Win Combos
        for (int i = 0; i < finalTile; i++) {
            if (i + (boardSize * 2) <= finalTile) {
                int[] winCombo = {i, i + boardSize, i + (boardSize * 2)};
                winCombos.add(winCombo);
            }
        }

//        Determine Left To Right Diagonal Combos
        currentRow = 1;
        for (int i = 0; i < finalTile; i++) {
            if (i == boardSize * currentRow) {
                currentRow++;
            }
            if ((i + (boardSize * 2) <= finalTile)&&(i + 2 < boardSize * currentRow)) {
                int[] winCombo = {i, i + boardSize + 1, i + (boardSize * 2) + 2};
                winCombos.add(winCombo);
            }
        }
        currentRow = 1;
        for (int i = 0; i <= finalTile; i++) {
            if (i == boardSize * currentRow) {
                currentRow++;
            }
            if ((i - (boardSize * 2) >= 0)&&(i - 2 >= boardSize * (currentRow - 1))) {
                int[] winCombo = {i, i - boardSize - 1, i - (boardSize * 2) - 2};
                winCombos.add(winCombo);
            }
        }
        return winCombos;
    }

}
