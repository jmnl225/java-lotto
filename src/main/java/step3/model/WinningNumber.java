package step3.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private List<LottoNumber> winningNumber;

    public WinningNumber(String winningNumber) {
        String[] winningNumbers = winningNumber.split(",");
        List<LottoNumber> result = new ArrayList<>();
        for (String number : winningNumbers) {
            result.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        this.winningNumber = result;
    }


}
