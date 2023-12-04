package step3.model;

import java.util.*;

public class Lotto {

    private final Set<LottoNumber> lotto;

    public Lotto(){
        lotto = new HashSet<>();
        createLotto();
    }

    public Lotto(Set<LottoNumber> lotto) {
        this.lotto = lotto;
        createLotto();
    }

    private void createLotto(){
        while (lotto.size() < 6){
            lotto.add(new LottoNumber());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}
