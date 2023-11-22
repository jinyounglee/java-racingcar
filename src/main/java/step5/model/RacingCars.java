package step5.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final String WINNER_DELIMITER = ",";

    private final List<Car> cars;

    private List<Car> winners = new ArrayList<>();

    public RacingCars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        for (Car car : cars) {
            winners = findWinner(car);
        }
        return winners;
    }

    public String getWinnersName() {
        return winners.stream().map(Car::getName).collect(Collectors.joining(WINNER_DELIMITER));
    }

    private List<Car> findWinner(Car car) {

        if (winners.isEmpty()) {
            winners.add(car);
            return winners;
        }

        Car legacyWinner = winners.get(0);

        if (legacyWinner.getCarPosition() == car.getCarPosition()) {
            winners.add(car);
            return winners;
        }

        if (legacyWinner.getCarPosition() < car.getCarPosition()) {
            winners.clear();
            winners.add(car);
        }

        return winners;
    }

}
