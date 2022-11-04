package baseball.controller;

import baseball.model.BaseballGame;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private List<String> convertUserInputToList(String userInput) {
        List<String> convertedList = new ArrayList<>();
        for (int idx=0; idx<userInput.length(); idx++) {
            convertedList.add(String.valueOf(userInput.charAt(idx)));
        }
        return convertedList;
    }

    private List<String> getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        List<String> inputList = convertUserInputToList(userInput);

        return inputList;
    }



    public String playGame() {
        boolean isThreeStrike = false;
        BaseballGame baseballGame = new BaseballGame();

        while (!isThreeStrike) {
            List<String> userInput = getUserInput();
            baseballGame.getResults(userInput);
            if (baseballGame.countStrike(userInput) == 3) {
                isThreeStrike = true;
                break;
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String isRestart = Console.readLine();
        return isRestart;
    }
}
