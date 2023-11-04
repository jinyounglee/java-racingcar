package study.step2;

public class PositiveNumber {

    public final static PositiveNumber ZERO = new PositiveNumber(0);

    private final Integer number;

    public PositiveNumber(Integer number) {
        if (number < 0) {
            throw new RuntimeException("음수는 들어갈 수 없습니다.");
        }
        this.number = number;
    }

    public PositiveNumber add(PositiveNumber positiveNumber) {
        return new PositiveNumber(this.number + positiveNumber.number);
    }

    public Integer getNumber() {
        return this.number;
    }
}
