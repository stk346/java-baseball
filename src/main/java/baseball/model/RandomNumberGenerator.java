package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generateRandNum() {
        List<Integer> randNumList;
        List<Integer> baseNumList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        randNumList = Randoms.shuffle(baseNumList.subList(0, 3));
        return randNumList;
    }

    public void randNumAPITest() {
        List<Integer> baseNumList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("pickNumberInList 메서드 : " + Randoms.pickNumberInList(List.of(1, 9)));
        System.out.println("pickNumberInRange 메서드 : " + Randoms.pickNumberInRange(1, 9));
        System.out.println("pickNumberInRange 메서드 : " + Randoms.shuffle(baseNumList));
    }

}
