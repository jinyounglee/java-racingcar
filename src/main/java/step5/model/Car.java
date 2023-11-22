package step5.model;

public class Car {

    private final String name;
    private Moving moving;

    public Car(String name) {
        this(name, null);
    }

    public Car(String name, Moving moving) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 필수 값입니다.");
        }
        this.name = name;
        this.moving = moving;
    }

    public String getName() {
        return name;
    }

    public int getCarPosition() {
        return moving.currentPosition();
    }
}
