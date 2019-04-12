package pl.kasia.faras;

import org.junit.Assert;
import org.junit.Test;

public class ConditionsTest {

    Game game = new Game(4);
    Game game2 = new Game(3);

    @Test
    public void whoWin_GameboardWidth4_checkRowWin() {

        game.getGameboard().set(4,120);
        game.getGameboard().set(5,120);
        game.getGameboard().set(6,120);
        game.getGameboard().set(7,120);
        Utils.printGameList(game.getGameboard());

        Assert.assertEquals(Conditions.whoWin(game), game.getPlayerX());
    }
    @Test
    public void whoWin_GameboardWidth4_checkColumnWin() {

        game.getGameboard().set(3,120);
        game.getGameboard().set(7,120);
        game.getGameboard().set(11,120);
        game.getGameboard().set(15,120);
        Utils.printGameList(game.getGameboard());

        Assert.assertEquals(Conditions.whoWin(game), game.getPlayerX());
    }

    @Test
    public void whoWin_GameboardWidth3_checkSlant1Win() {

        game2.getGameboard().set(0,111);
        game2.getGameboard().set(4,111);
        game2.getGameboard().set(8,111);
        Utils.printGameList(game2.getGameboard());

        Assert.assertEquals(Conditions.whoWin(game2), game2.getPlayerO());
    }

    @Test
    public void whoWin_GameboardWidth4_checkSlant2Win() {

        game.getGameboard().set(3,111);
        game.getGameboard().set(6,111);
        game.getGameboard().set(9,111);
        game.getGameboard().set(12,111);
        Utils.printGameList(game.getGameboard());

        Assert.assertEquals(Conditions.whoWin(game), game.getPlayerO());
    }

    @Test
    public void end() {
    }
}