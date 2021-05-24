package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResults matches(WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::matchWinning)
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningResults::new));
    }

    public List<Lotto> getValues() {
        return new ArrayList<>(lottos);
    }

    public List<Lotto> getAutos() {
        return lottos.stream()
                .filter(Lotto::isAuto)
                .collect(Collectors.toList());
    }

    public List<Lotto> getManuals() {
        return lottos.stream()
                .filter(Lotto::isManual)
                .collect(Collectors.toList());
    }
}