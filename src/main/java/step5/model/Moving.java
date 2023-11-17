package step5.model;

import java.util.Objects;

public class Moving {
    private int position;

    public Moving(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("0 보다 작은 수 만큼 이동 할 수 없습니다.");
        }
        this.position = position;
    }

    public Moving move() {
        position += 1;
        return this;
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
        return Objects.hash(position);
    }
}
