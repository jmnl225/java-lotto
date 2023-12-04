package step3.view;

import java.util.Scanner;

public class ResultView {

    private final Scanner scanner;

    public ResultView() {
        this.scanner = new Scanner(System.in);
    }

    public void printLottoCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public void printWinningStatics(){
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("--------------");
    }

    public void printResult(String returnRate){
        System.out.println("총 수익률은 "+returnRate+"입니다.");
    }
}
