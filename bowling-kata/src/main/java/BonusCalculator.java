import java.util.ArrayList;
import java.util.List;

public class BonusCalculator {
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
        return new BonusFrame(frame.firstRoll(), frame.secondRoll(), 0, 0);
    }

    private static BonusFrame getStrikeBonusFrame(Frames frames, Frame frame, int rollNumber) {
        if (frame.isLastFrame()) {
            return new BonusFrame(frame.firstRoll(), frame.secondRoll(), frame.lastRoll(), 0);
        }

        Frame nextFrame = frames.get(rollNumber + 1);
        int bonus = 0;
        if (nextFrame.isStrike()) {
            if (nextFrame.isLastFrame()) {
                bonus += nextFrame.secondRoll();
            } else {
                bonus += frames.get(rollNumber + 2).firstRoll();
            }
        } else {
            bonus += nextFrame.secondRoll();
        }

        return new BonusFrame(frame.firstRoll(), frame.secondRoll(), 0, nextFrame.firstRoll() + bonus);
    }

    private static BonusFrame getSpareBonusFrame(Frames frames, Frame frame, int rollNumber) {
        if (frame.isLastFrame()) {
            return new BonusFrame(frame.firstRoll(), frame.secondRoll(), frame.lastRoll(), 0);
        }

        return new BonusFrame(
            frame.firstRoll(),
            frame.secondRoll(),
            0,
            frames.get(rollNumber + 1).firstRoll()
        );
    }
}
