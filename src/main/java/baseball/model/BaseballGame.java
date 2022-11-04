package baseball.model;

import java.util.HashMap;
import java.util.List;

public class BaseballGame {
    private HashMap<String, Integer> answer = new HashMap<>();

    public BaseballGame(List<String> answer) {
        for (int idx=0; idx<answer.size(); idx++) {
            this.answer.putIfAbsent(answer.get(idx), idx);
        }
    }

    public BaseballGame() {
        generateAnswer();
    }

    private void generateAnswer() {
        List<String> answerList = new RandomNumberGenerator().generateRandNum();
        for (int idx = 0; idx < answerList.size(); idx++) {
            this.answer.putIfAbsent(answerList.get(idx), idx);
        }
        System.out.println("정답 : " + answerList.toString()); // 테스트용 정답 보이기
    }

    public boolean isSameNumber(String userBall) {
        boolean isExistSameNumber = false;
        if (this.answer.getOrDefault(userBall, -1) >= 0) {
            isExistSameNumber = true;
        }
        return isExistSameNumber;
    }

    public int countStrike(List<String> userInput) {
        int strikeCnt = 0;
        for (int idx=0; idx<userInput.size(); idx++) {
            if (isSameNumber(userInput.get(idx)) && answer.get(userInput.get(idx)) == idx) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public int countBall(List<String> userInput) {
        int ballCnt = 0;
        for (int idx=0; idx<userInput.size(); idx++) {
            if (isSameNumber(userInput.get(idx)) && answer.get(userInput.get(idx)) != idx) {
                ballCnt++;
            }
        }
        return ballCnt;
    }

    public void getResults(List<String> userInput) {
        String results = "";
        int strikeCnt = countStrike(userInput);
        int ballCnt = countBall(userInput);

        if (ballCnt > 0) {
            results += ballCnt + "볼 " ;
        }
        if (strikeCnt > 0) {
            results += strikeCnt + "스트라이크";
        }
        if (strikeCnt == 0 & ballCnt == 0) {
            results += "낫싱";
        }
        System.out.println(results);
    }
}

