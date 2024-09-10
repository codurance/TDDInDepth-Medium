public class BonusCalculator {
    public int getBonus(Frames frames) {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            if (frames.size() <= i) {
                continue;
            }
            Frame frame = frames.get(i);
            if (frame.isStrike()) {
                score += frames.get(i + 1).firstRoll();
                score += frames.get(i + 1).secondRoll();
            }

            if (frame.isSpare()) {
                score += frames.get(i + 1).firstRoll();
            }
        }

        return score;
    }
}
