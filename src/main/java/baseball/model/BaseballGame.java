package baseball.model;

import java.util.HashMap;
import java.util.List;

public class BaseballGame {
    HashMap<Character, Integer> answer = new HashMap<>();

    public BaseballGame(List<Character> answer) {
        for (int idx=0; idx<answer.size(); idx++) {
            this.answer.putIfAbsent(answer.get(idx), idx);
        }
    }

    public boolean isSameNumber(char userBall) {
        boolean isExistSameNumber = false;
        if (this.answer.getOrDefault(userBall, -1) >= 0) {
            isExistSameNumber = true;
        }
        return isExistSameNumber;
    }

    public int countStrike(List<Character> userInput) {
        int strikeCnt = 0;
        for (int idx=0; idx<userInput.size(); idx++) {
            if (isSameNumber(userInput.get(idx)) && answer.get(userInput.get(idx)) == idx) {
                strikeCnt++;

            }
        }
        return strikeCnt;
    }

    public int countBall(List<Character> userInput) {
        int ballCnt = 0;
        for (int idx=0; idx<userInput.size(); idx++) {
            if (isSameNumber(userInput.get(idx)) && answer.get(userInput.get(idx)) != idx) {
                ballCnt++;
            }
        }
        return ballCnt;
    }
}

