import lotto.domain.Lotto;
import lotto.view.Input;
import lotto.view.Output;

import java.math.BigDecimal;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        BigDecimal amount = Input.inputAmount();
        List<Lotto> numberList = Output.print(amount);
        List<Integer> winnerNumberList = Input.inputWinnerNumberList();
        Integer bonusBallNumber = Input.inputBonusBallNumber();

        List<Lotto> lottoList = Output.getRank(numberList, winnerNumberList, bonusBallNumber);
        Output.getResult(lottoList);
    }
}