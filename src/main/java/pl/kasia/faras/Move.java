package pl.kasia.faras;

import java.util.Random;

public class Move {

    public static void move() {

    }
    public static void humanMove(Player player, Game game) {
        //first move
        int center = game.getGameboard().size() / 2;
        //jeżeli to pierwszy ruch komputera
        if (player.getNumberOfMoves() == 0) {
            //i jezeli cyfra na pozycji srodkowej jest zajeta
            if (game.getGameboard().get(center) != center + 1) {
                //to wstaw na pozycje srodkową nr znaku gracza
                game.getGameboard().set(center, player.getNumberOfSign());
                //w przeciwnym razie losuj z przedzialu cyfr od 1 do wielkosci listy
            } else {
                Random random = new Random();
                int shot = random.nextInt(4) + 1;
                if (shot == 1) {
                    //na 0
                    game.getGameboard().set(0, player.getNumberOfSign());
                } else if (shot == 2) {
                    //width -1
                    game.getGameboard().set(2, player.getNumberOfSign());
                } else if (shot == 3) {
                    //width *2
                    game.getGameboard().set(6, player.getNumberOfSign());
                } else if (shot == 4) {
                    //size -1
                    game.getGameboard().set(8, player.getNumberOfSign());
                }
            }
        }
    }
}
