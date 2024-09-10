import java.util.ArrayList;
import java.util.List;

public class BonusCalculator {
    public int getBonus(Frames frames) {
        return getBonusFrames(frames)
            .stream()
            .map(BonusFrame::bonus)
            .reduce(Integer::sum)
            .orElse(0);
    }

    public List<BonusFrame> getBonusFrames(Frames frames) {
        List<BonusFrame> bonusFrames = new ArrayList<>();
        int rollNumber = 0;
        for (Frame frame : frames.all()) {
            BonusFrame bonusFrame = getBonusFrame(frame);

            if (frame.isSpare()) {
                bonusFrame = getSpareBonusFrame(frames, frame, rollNumber);
            }

            if (frame.isStrike()) {
                bonusFrame = getStrikeBonusFrame(frames, frame, rollNumber);
            }

            bonusFrames.add(bonusFrame);

            rollNumber++;
        }

        return bonusFrames;
    }

    private static BonusFrame getBonusFrame(Frame frame) {
        BonusFrame bonusFrame = new BonusFrame(frame.firstRoll(), frame.secondRoll(), 0, 0);
        return bonusFrame;
    }

    private static BonusFrame getStrikeBonusFrame(Frames frames, Frame frame, int rollNumber) {
        Frame nextFrame = frames.get(rollNumber + 1);
        int bonus = nextFrame.firstRoll();
        if (nextFrame.isStrike()) {
            bonus += frames.get(rollNumber + 2).firstRoll();
        }
        bonus += nextFrame.secondRoll();

        return new BonusFrame(frame.firstRoll(), frame.secondRoll(), frame.lastRoll(), bonus);
    }

    private static BonusFrame getSpareBonusFrame(Frames frames, Frame frame, int rollNumber) {
        if (rollNumber == 9) {
            return new BonusFrame(frame.firstRoll(), frame.secondRoll(), frame.lastRoll(), 0);
        }

        return new BonusFrame(frame.firstRoll(), frame.secondRoll(), frame.lastRoll(), frames.get(rollNumber + 1).firstRoll());
    }
}
