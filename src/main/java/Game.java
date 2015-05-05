public class Game {

    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int ball = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(ball)) {
                score += 10 + scoreForSpareNextBall(ball);
                ball += 2;
            } else if (isStrike(ball)) {
                score += 10 + scoreForStrikeNextTwoBalls(ball);
                ball += 1;
            } else {
                score += scoreForThisFrame(ball);
                ball += 2;
            }
        }
        return score;
    }

    private int scoreForThisFrame(int i) {
        return rolls[i] + rolls[i + 1];
    }

    private boolean isStrike(int i) {
        return rolls[i] == 10;
    }

    private int scoreForStrikeNextTwoBalls(int i) {
        return rolls[i + 1] + rolls[i + 2];
    }

    private int scoreForSpareNextBall(int i) {
        return rolls[i + 2];
    }

    private boolean isSpare(int i) {
        return rolls[i] + rolls[i + 1] == 10;
    }
}
