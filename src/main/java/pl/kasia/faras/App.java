package pl.kasia.faras;

import java.util.List;

public class App {
    public static void main(String[] args) {

        int decision;
        do {
            System.out.println("Podaj szerokość pola do gry od 3 do 6: ");
            Game game = new Game(Utils.downloadNumberFromPlayer(3, 6));

            System.out.println("Zaczynamy grę, krzyżyki pierwsze :)");
            Player player = game.getPlayerX();
            List<Integer> pole = game.getGameboard();
            Player winner;
            do {
                Utils.printGameList(pole);
                System.out.println("Podaj pozycje dla znaku: " + player.getSign());
                int shot = Utils.downloadNumberFromPlayer(1, pole.size());

                if ((pole.get(shot - 1).equals(120)) || (pole.get(shot - 1).equals(111))) {
                    System.out.println("Ta pozycja zostala juz zajeta");
                } else {
                    pole.set(shot - 1, player.getNumberOfSign());
                    player.addMove();
                    player = game.switchPlayer(player);
                }
            }
            while (!Utils.end(game));

            winner = Conditions.whoWin(game);
            Utils.printGameList(pole);

            if (game.getPlayerX().equals(winner)) {
                System.out.println("Wygrywają krzyżyki!");
            } else if (game.getPlayerO().equals(winner)) {
                System.out.println("Wygrywają kółka!");
            } else {
                System.out.println("Remis!");
            }
            System.out.println("1 - Gramy dalej.\n" +
                    "2 - Koniec gry.");
            decision = Utils.downloadNumberFromPlayer(1, 2);
        }while (decision==1);
        System.out.println("Dzięki za grę! Do zobaczenia!");
    }
}