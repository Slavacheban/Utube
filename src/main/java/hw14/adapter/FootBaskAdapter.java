package hw14.adapter;

import hw14.adapter.Games.Football;
import hw14.adapter.Players.BasketBallPlayer;

public class FootBaskAdapter extends Football {
    private BasketBallPlayer player;

    @Override
    public void startGame() {
        player.play();
        System.out.println("Bun now I'm Playing Football");
    }
}
