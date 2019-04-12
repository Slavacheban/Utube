package HW14.adapter;

import HW14.adapter.Games.Football;
import HW14.adapter.Players.BasketBallPlayer;

public class FootBaskAdapter extends Football {
    private BasketBallPlayer player;

    @Override
    public void startGame() {
        player.play();
        System.out.println("Bun now I'm Playing Football");
    }
}
