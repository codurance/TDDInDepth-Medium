public class BonusCalculator {
    public int getBonus(Frames frames) {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            Frame frame = frames.get(i);
            if (frame.isSpare()) {
                score += frames.get(i + 1).firstRoll();
            }
        }

        return score;
    }
}
