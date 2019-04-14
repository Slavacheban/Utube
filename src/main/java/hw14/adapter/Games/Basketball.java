package hw14.adapter.Games;

import hw14.adapter.Players.Player;

public class Basketball implements Game {
    private Player baskPlayer;

    @Override
    public void startGame() {
        baskPlayer.play();
    }
}
