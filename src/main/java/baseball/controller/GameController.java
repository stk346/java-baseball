package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.RandomNumberGenerator;

import java.util.List;

public class GameController {
    BaseballGame baseballGame;
    List<Character> answer;

    public GameController(List<Character> answer) {
        baseballGame = new BaseballGame(answer);
        this.answer = answer;
    }

    public GameController() {
        this.answer = new RandomNumberGenerator().generateRandNum();
    }

    public void getResults(List<Character> userInput) {
        String results = "";
        int strikeCnt = baseballGame.countStrike(userInput);
        int ballCnt = baseballGame.countBall(userInput);

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

    public boolean playGame(List<Character> userInput) {
        boolean isThreeStrike = false;

        while (!isThreeStrike) {
            getResults(userInput);
            if (baseballGame.countStrike(userInput) == 3) {
                isThreeStrike = true;
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return isThreeStrike;
    }
}
