package HW14.adapter.Games;

import HW14.adapter.Players.Player;

public class Basketball implements Game {
    private Player baskPlayer;

    @Override
    public void startGame() {
        baskPlayer.play();
    }
}
