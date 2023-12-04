package step3.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int rounds) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < rounds; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public void printLottos(){
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
