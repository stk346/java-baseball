package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberGenerator {

    public List<String> generateRandNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public void randNumAPITest() {
        List<Integer> baseNumList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("pickNumberInList 메서드 : " + Randoms.pickNumberInList(List.of(1, 9)));
        System.out.println("pickNumberInRange 메서드 : " + Randoms.pickNumberInRange(1, 9));
        System.out.println("pickNumberInRange 메서드 : " + Randoms.shuffle(baseNumList));
    }

}
