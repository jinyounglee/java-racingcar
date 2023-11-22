package step5.model;

import java.util.Objects;

public class Moving {

    private static final int MINIMUM_MOVABLE_NUMBER = 4;

    private static final int MOVE_NUM = 1;

    private final NumberGenerator numberGenerator;
    private int position;

    public Moving(int position, NumberGenerator numberGenerator) {
        if (position < 0) {
            throw new IllegalArgumentException("0 보다 작은 수 만큼 이동 할 수 없습니다.");
        }
        this.position = position;
        this.numberGenerator = numberGenerator;
    }

    public Moving move() {
        if (isMovable(numberGenerator)) {
            position += MOVE_NUM;
        }
        return this;
    }

    private boolean isMovable(NumberGenerator numberGenerator) {
        return numberGenerator.generate() >= MINIMUM_MOVABLE_NUMBER;
    }

    private int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moving moving = (Moving) o;
        return position == moving.position;

    }

    @Override
    public int hashCode() {
        return Objects.hash(numberGenerator, position);
    }

    public int currentPosition() {
        return position;
    }
}
