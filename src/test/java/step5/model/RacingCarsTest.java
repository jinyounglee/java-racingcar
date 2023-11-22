package step5.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class RacingCarsTest {

    private Car makeCar(String name, Moving moving) {
        return new Car(name, moving);
    }

    @Test
    @DisplayName("포지션이 많은 사람들이 승자가 된다.")
    void find_winners() {
        final RacingCars racingCars = new RacingCars(List.of(
                makeCar("영수", new Moving(5, null))
                , makeCar("진수", new Moving(5, null))
                , makeCar("민수", new Moving(7, null))
        ));

        Assertions.assertThat(racingCars.findWinners().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("승자들 이름을 가져온다")
    void find_winnersName() {
        final RacingCars racingCars = new RacingCars(List.of(
                makeCar("영수", new Moving(5, null))
                , makeCar("진수", new Moving(7, null))
                , makeCar("민수", new Moving(7, null))
        ));

        racingCars.findWinners();

        Assertions.assertThat(racingCars.getWinnersName()).isEqualTo("진수,민수");
    }
}