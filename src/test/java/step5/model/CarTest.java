package step5.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가진다.")
    void car_has_name() {
        String carName = "이름";
        Car car = new Car(carName);
        Assertions.assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("자동차가 빈 이름을 가지면 Exception을 던진다.")
    void hasNoName_throwException() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Car(null);
                })
                .withMessageMatching("이름은 필수 값입니다.");
    }

}