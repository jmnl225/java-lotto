package step3.controller;

import step3.model.BonusNumber;
import step3.model.Lottos;
import step3.model.WinningNumber;
import step3.view.InputView;
import step3.view.ResultView;

public class Controller {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args){
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        int price = 0;
        int round = 0;

        price = inputView.inputPrice();
        round = price/LOTTO_PRICE;
        resultView.printLottoCount(round);

        Lottos lottos = new Lottos(round);
        lottos.printLottos();

        WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber());
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());

    }
}
