package hw14.adapter.Games;

import hw14.adapter.Players.Player;

public class Football implements Game {
    private Player footPlayer;

    @Override
    public void startGame() {
        footPlayer.play();
    }
}
