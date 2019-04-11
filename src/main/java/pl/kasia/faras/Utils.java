package pl.kasia.faras;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utils {

    public static int downloadNumberFromPlayer(int dolnyZakres, int gornyzakres) {
        Scanner scanner = new Scanner(System.in);
        int number;
        try {
            number = scanner.nextInt();
            if (number < dolnyZakres || number > gornyzakres) {
                System.out.println("Proszę podać liczbę z przedziału: " + dolnyZakres + "-" + gornyzakres);
                number = downloadNumberFromPlayer(dolnyZakres, gornyzakres);
            }
            return number;
        } catch (InputMismatchException ime) {
            System.out.println("Proszę podać liczbę z przedziału: " + dolnyZakres + "-" + gornyzakres);
            number = downloadNumberFromPlayer(dolnyZakres, gornyzakres);
        }
        return number;
    }

    public static void printGameList(List<Integer> gameList) {
        for (int i = 0; i < gameList.size(); i++) {
            if (gameList.get(i).equals(i + 1)) {
                System.out.printf("%6d", gameList.get(i));
            } else if (gameList.get(i).equals(120)) {
                System.out.printf("%6c", 'x');
            } else if (gameList.get(i).equals(111)) {
                System.out.printf("%6c", 'o');
            }
            if ((i + 1) % Math.sqrt(gameList.size()) == 0) {
                System.out.println();
                System.out.println();
            }
        }
    }

    public static boolean end(Game game) {
        Player winner = Conditions.whoWin(game);
        int allMoves = game.getPlayerO().getNumberOfMoves() + game.getPlayerX().getNumberOfMoves();
        if (winner != null || allMoves == game.getGameboard().size()) {
            return true;
        }
        return false;
    }
}

