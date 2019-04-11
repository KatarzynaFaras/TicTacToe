package pl.kasia.faras;

import java.util.List;

import static pl.kasia.faras.Conditions.whoWin;
import static pl.kasia.faras.Utils.*;

public class App {
    public static void main(String[] args) {

        int continueGame;
        do {
            System.out.println("Podaj szerokość pola do gry od 3 do 6: ");
            Game game = new Game(downloadNumberFromPlayer(3, 6));
            System.out.println("Kto zaczyna? \n\n" +
                    " 1 - krzyżyki \n" +
                    " 2 - kółka\n");
            int whoFirst = downloadNumberFromPlayer(1, 2);

            Player player;
            Player winner;

            if (whoFirst == 1) {
                System.out.println("Zaczynamy grę, krzyżyki pierwsze :) \n");
                player = game.getPlayerX();
            } else {
                System.out.println("Zaczynamy grę, kółka pierwsze :) \n");
                player = game.getPlayerO();
            }

            List<Integer> pole = game.getGameboard();

            do {
                printGameList(pole);
                System.out.println("Podaj pozycje dla znaku: " + player.getSign());
                int move = downloadNumberFromPlayer(1, pole.size());

                if ((pole.get(move - 1).equals(120)) || (pole.get(move - 1).equals(111))) {
                    System.out.println("Ta pozycja zostala juz zajeta");
                } else {
                    pole.set(move - 1, player.getNumberOfSign());
                    player.addMove();
                    player = game.switchPlayer(player);
                }
            }
            while (!end(game));

            winner = whoWin(game);
            printGameList(pole);

            if (game.getPlayerX().equals(winner)) {
                System.out.println("Wygrywają krzyżyki! \n\n");
            } else if (game.getPlayerO().equals(winner)) {
                System.out.println("Wygrywają kółka! \n\n");
            } else {
                System.out.println("Remis!");
            }
            System.out.println("1 - Gramy dalej.\n" +
                    "2 - Koniec gry.");
            continueGame = downloadNumberFromPlayer(1, 2);
        } while (continueGame == 1);
        System.out.println("Dzięki za grę! Do zobaczenia!");
    }
}