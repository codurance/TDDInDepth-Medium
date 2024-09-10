public class BowlingGame {

    private int score = 0;

    public int score() {
        return score;
    }

    public void roll(int pins) {
        score += pins;
    }
}
