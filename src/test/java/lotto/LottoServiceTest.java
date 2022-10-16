package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        this.lottoService = new LottoService();
    }

    @DisplayName("Money를 넘기면 1000원짜리 로또를 몇개 구입했는지 반환한다.")
    @Test
    void lotto_purchase_count() {
        assertThat(lottoService.purchaseNumber(new Money(3000))).isEqualTo(3);
    }

    @DisplayName("당첨번호와 일치하는 갯수 배열을 반환한다.")
    @Test
    void check_lotto() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(LottoNumberSet.createLottoNumberSet(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoNumberSet.createLottoNumberSet(2, 3, 4, 5, 6, 7)),
                new Lotto(LottoNumberSet.createLottoNumberSet(2, 3, 4, 5, 6, 9)),
                new Lotto(LottoNumberSet.createLottoNumberSet(3, 4, 5, 6, 7, 8)),
                new Lotto(LottoNumberSet.createLottoNumberSet(4, 5, 6, 7, 8, 9)),
                new Lotto(LottoNumberSet.createLottoNumberSet(5, 6, 7, 8, 9, 10)),
                new Lotto(LottoNumberSet.createLottoNumberSet(6, 7, 8, 9, 10, 11)),
                new Lotto(LottoNumberSet.createLottoNumberSet(7, 8, 9, 10, 11, 12))
        );
        LottoWinner winner = new LottoWinner(LottoNumberSet.createLottoNumberSet(1, 2, 3, 4, 5, 6), new LottoNumber(7));

        assertThat(lottoService.checkLotto(lottoList, winner))
                .isEqualTo(Map.of(0, 3, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1));
    }

    @DisplayName("로또 수익률을 반환한다.")
    @Test
    void yield() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(LottoNumberSet.createLottoNumberSet(4, 5, 6, 7, 8, 9)),
                new Lotto(LottoNumberSet.createLottoNumberSet(5, 6, 7, 8, 9, 10)),
                new Lotto(LottoNumberSet.createLottoNumberSet(6, 7, 8, 9, 10, 11)),
                new Lotto(LottoNumberSet.createLottoNumberSet(7, 8, 9, 10, 11, 12))
        );
        LottoWinner winner = new LottoWinner(LottoNumberSet.createLottoNumberSet(1, 2, 3, 4, 5, 6), new LottoNumber(7));


        assertThat(lottoService.yield(lottoList, winner, new Money(10000))).isEqualTo(0.5);
    }
}