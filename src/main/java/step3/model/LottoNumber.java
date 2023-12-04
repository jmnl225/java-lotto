package step3.model;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {

    private int number;


    public LottoNumber(){
        Random random = new Random();
        this.number = random.nextInt(45)+1;
    }

    public LottoNumber(String number){
        new LottoNumber(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        if (number < 0 || number > 45){
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
