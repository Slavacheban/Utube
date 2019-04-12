package HW14.adapter.Games;

import HW14.adapter.Players.Player;

public class Football implements Game {
    private Player footPlayer;

    @Override
    public void startGame() {
        footPlayer.play();
    }
}
