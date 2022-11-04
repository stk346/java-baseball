package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {

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

        String isRestart = raiseErrorWhenInputIsNot1Or2();
        return isRestart;
    }

    private List<String> getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        raiseErrorWhenInputLengthOver3(userInput);
        List<String> inputList = convertUserInputToList(userInput);

        return inputList;
    }

    private List<String> convertUserInputToList(String userInput) {
        List<String> convertedList = new ArrayList<>();
        for (int idx = 0; idx < userInput.length(); idx++) {
            char separatedInput = userInput.charAt(idx);
            raiseErrorWhenInputIsNotDigitOrZero(separatedInput);
            convertedList.add(String.valueOf(userInput.charAt(idx)));
        }
        return convertedList;
    }

    private void raiseErrorWhenInputIsNotDigitOrZero(char separatedInput) throws IllegalArgumentException {
        if (!Character.isDigit(separatedInput)) {
            System.out.println("숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (separatedInput == '0') {
            System.out.println("1과 9사이의 숫자만 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private void raiseErrorWhenInputLengthOver3(String userInput) throws IllegalArgumentException {
        if (userInput.length() > 3) {
            System.out.println("입력은 세자리 숫자만 허용됩니다.");
            throw new IllegalArgumentException();
        }
    }

    private String raiseErrorWhenInputIsNot1Or2() throws IllegalArgumentException {
        String userInput = Console.readLine();

        try {
            if (!(userInput.equals("1") || userInput.equals("2"))) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("1과 2만 입력할 수 있습니다.");
            return raiseErrorWhenInputIsNot1Or2();
        }
        return userInput;
    }
}
