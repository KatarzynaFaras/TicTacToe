package pl.kasia.faras;

import java.util.List;

public class Conditions {

    public static Player whoWin(Game game) {
        List<Integer> list = game.getGameboard();
        int width = (int) Math.sqrt(list.size());
        int counter;
        //warunek poziomo
        for (int g = 0; g < list.size(); g += width) {
            counter = 0;
            for (int h = 0; h < width - 1; h++) {
                counter = list.get(g + h).equals(list.get(g + h + 1)) ? counter + 0 : counter + 1;
            }
            if (counter == 0) {
                return list.get(g).equals(game.getPlayerX().getNumberOfSign()) ? game.getPlayerX() : game.getPlayerO();
            }
        }
        //warunek 1 skos
        counter = 0;
        for (int j = 0; j < list.size(); j += width) {
            for (int i = 1; i < width; i++) {
                counter = list.get(0).equals(list.get(width * i + i)) ? counter + 0 : counter + 1;
            }
        }
        if (counter == 0) {
            return list.get(0).equals(game.getPlayerX().getNumberOfSign()) ? game.getPlayerX() : game.getPlayerO();
        }
        //warymek na piony
        for (int k = 0; k < width; k++) {
            counter = 0;
            for (int l = width; l < list.size(); l += width) {
                counter = list.get(k).equals(list.get(k + l)) ? counter + 0 : counter + 1;
            }
            if (counter == 0) {
                return list.get(k).equals(game.getPlayerX().getNumberOfSign()) ? game.getPlayerX() : game.getPlayerO();
            }
        }
        //warumek na 2 skos
        counter = 0;
        for (int m = width - 1; m < width * 2; m += m) {
            counter = list.get(m).equals(list.get(m + width - 1)) ? counter + 0 : counter + 1;
        }
        if (counter == 0) {
            return list.get(width - 1).equals(game.getPlayerX().getNumberOfSign()) ? game.getPlayerX() : game.getPlayerO();
        }
        return null;
    }
}


