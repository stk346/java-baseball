package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameEndFlag = false;

        while (!gameEndFlag) {
            GameController gameController = new GameController();
            String isRestart = gameController.playGame();

            if (isRestart.equals("2")) {
                gameEndFlag = true;
            }
        }
        System.out.println("게임을 종료합니다.");
    }
}
