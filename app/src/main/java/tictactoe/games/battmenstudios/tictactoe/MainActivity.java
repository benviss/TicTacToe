package tictactoe.games.battmenstudios.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Arrays;

import tictactoe.games.battmenstudios.tictactoe.Models.Board;
import tictactoe.games.battmenstudios.tictactoe.Models.GameBrain;
import tictactoe.games.battmenstudios.tictactoe.Models.Tile;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = "Tic-Tac-Toe";
    private int[] CLICKABLES = {R.id.butt_onePlayer, R.id.butt_twoPlayer, R.id.butt_settings, R.id.butt_howToPlay, R.id.butt_startGame};
    private int[] SCREENS = {R.id.screen_main, R.id.screen_twoPlayerSettings, R.id.screen_game};
    ArrayList<Integer> tileIds = new ArrayList<>(Arrays.asList(R.id.r0c0,R.id.r0c1,R.id.r0c2,R.id.r0c3,R.id.r1c0,R.id.r1c1,R.id.r1c2,R.id.r1c3,R.id.r2c0,R.id.r2c1,R.id.r2c2,R.id.r2c3,R.id.r3c0,R.id.r3c1,R.id.r3c2,R.id.r3c3));

    public boolean playerOneTurn = true;
    private boolean twoPlayers;

    Board board;
    private ArrayList<Tile> tiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        switchToScreen(R.id.screen_main);

        for (int button : CLICKABLES) {
            findViewById(button).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butt_onePlayer:
                break;
            case R.id.butt_twoPlayer:
                twoPlayers = true;
                switchToScreen(R.id.screen_twoPlayerSettings);
                break;
            case R.id.butt_settings:
                break;
            case R.id.butt_howToPlay:
                GameBrain gameBrain = new GameBrain();
                ArrayList<int[]> test = gameBrain.getWinCombos(6);
                break;
            case R.id.butt_startGame:
                switchToScreen(R.id.screen_game);
                startGame();
                for (Tile tile : tiles) {
                    findViewById(tile.getViewId()).setOnClickListener(this);
                    findViewById(tile.getViewId()).setVisibility(View.VISIBLE);
                }
                break;
        }
        if (tileIds.contains(view.getId())) {
            tileClicked(view);
        }
    }

    /*Game Logic*/
    public void startGame() {
        if (twoPlayers) {
            board = new Board(4);
        }
        tiles = board.getTiles();
    }

    private void switchToScreen(int screenId) {
        //make the requested screen visible; hide all others
        for (int id : SCREENS) {
            findViewById(id).setVisibility(screenId == id ? View.VISIBLE : View.GONE);
        }
//        mCurScreen = screenId;
    }

    public void tileClicked(View view) {
        if (playerOneTurn) {
            view.setBackgroundColor(Color.CYAN);
        } else {
            view.setBackgroundColor(Color.RED);
        }
        view.setClickable(false);
        playerOneTurn = !playerOneTurn;
    }


}
