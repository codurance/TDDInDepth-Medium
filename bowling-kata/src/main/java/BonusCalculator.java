public class BonusCalculator {
    public int getBonus(Frames frames) {
        int score = 0;
        for (int i = 0; i < 10; i++) {
            if (frames.size() <= i) {
                continue;
            }
            Frame frame = frames.get(i);
            if (frame.isStrike()) {
                Frame nextFrame = frames.get(i + 1);
                score += nextFrame.firstRoll();
                if (nextFrame.isStrike()) {
                    score += frames.get(i + 2).firstRoll();
                }
                score += nextFrame.secondRoll();
            }

            if (frame.isSpare()) {
                score += frames.get(i + 1).firstRoll();
            }
        }

        return score;
    }
}
