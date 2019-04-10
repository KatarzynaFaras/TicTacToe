package pl.kasia.faras;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> gameboard;
    Player playerX = new Player(120,'x');
    Player playerO = new Player(111, 'o');

    public Game(int width) {
        this.gameboard = fillGameList(width*width);
    }

    public List<Integer> fillGameList(int size) {
        List pole = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            pole.add(i, i + 1);
        }
        return pole;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public List<Integer> getGameboard() {
        return gameboard;
    }

    public Player switchPlayer(Player player) {
        return player.equals(this.getPlayerX()) ? this.getPlayerO() : this.getPlayerX();
    }
}