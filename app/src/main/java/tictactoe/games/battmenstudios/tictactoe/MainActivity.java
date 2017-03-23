package tictactoe.games.battmenstudios.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int[] CLICKABLES = {R.id.butt_onePlayer, R.id.butt_twoPlayer, R.id.butt_settings, R.id.butt_howToPlay, R.id.butt_startGame};
    private int[] SCREENS = {R.id.screen_main, R.id.screen_twoPlayerSettings, R.id.screen_game};

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
                switchToScreen(R.id.screen_twoPlayerSettings);
                break;
            case R.id.butt_settings:
                break;
            case R.id.butt_howToPlay:
                break;
            case R.id.butt_startGame:
                switchToScreen(R.id.screen_game);
                break;
        }
    }

    private void switchToScreen(int screenId) {
        //make the requested screen visible; hide all others
        for (int id : SCREENS) {
            findViewById(id).setVisibility(screenId == id ? View.VISIBLE : View.GONE);
        }
//        mCurScreen = screenId;
    }


}
