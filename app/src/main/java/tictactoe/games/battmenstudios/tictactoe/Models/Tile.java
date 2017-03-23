package tictactoe.games.battmenstudios.tictactoe.Models;

/**
 * Created by Ben Vissotzky on 3/23/2017.
 */

public class Tile {
    public int viewId;
    public int id;

    public Tile(int viewId, int id) {
        this.viewId = viewId;
        this.id = id;
    }

    public int getViewId() {
        return viewId;
    }
}
