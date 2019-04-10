package pl.kasia.faras;

import java.util.Objects;

public class Player {

    private int numberOfMoves;
    private int numberOfSign;
    private char sign;

    public Player(int numberOfSign, char sign) {
        this.numberOfMoves = 0;
        this.numberOfSign = numberOfSign;
        this.sign = sign;
    }

    public int getNumberOfSign() {
        return numberOfSign;
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    public void addMove() {
        this.numberOfMoves += 1;
    }

    public char getSign() {
        return sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return numberOfSign == player.numberOfSign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfSign);
    }
}
