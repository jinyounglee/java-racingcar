package step5.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MovingTest {

    @Test
    @DisplayName("움직이면 거리가 1칸 이동한다.")
    void move() {
        Moving moving = new Moving(0, new MovableNumberGenerator());
        assertThat(moving.move().currentPosition()).isEqualTo(new Moving(1, new MovableNumberGenerator()).currentPosition());
    }

    @Test
    @DisplayName("0 미만의 거리를 이동하려고 하면 예외를 발생한다.")
    void minus_throwException() {
        assertThatThrownBy(() -> new Moving(-1, new MovableNumberGenerator())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 보다 작은 수 만큼 이동 할 수 없습니다.");

    }
}