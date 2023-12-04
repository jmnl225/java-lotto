package step3;

import org.junit.jupiter.api.Test;
import step3.model.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @Test
    void 생성자테스트() {
        LottoNumber number = new LottoNumber(1);
        assertThat(new LottoNumber(1)).isEqualTo(number);
    }

    @Test
    void 생성자범위초과테스트() {
        assertThrows(RuntimeException.class, () -> {
            new LottoNumber(46);
        });
    }
}