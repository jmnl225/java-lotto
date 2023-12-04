package step3.model;

import java.util.Objects;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    public BonusNumber() {
        this.bonusNumber = new LottoNumber();
    }

    public BonusNumber(String number){
        this.bonusNumber = new LottoNumber(number);
    }

    public BonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }


    @Override
    public String toString() {
        return "BonusNumber{" +
                "bonusNumber=" + bonusNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
