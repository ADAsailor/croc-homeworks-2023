package ru.croc.daria.aladina.objects;

/**
 * Машина.
 *
 * @author Daria Aladina
 */
public class Car {
    /** Номер машины. */
    private final String carNumber;

    /**
     * Автоматически инициализирует объект класса Car во время его создания.
     *
     * @param carNumber номер машины
     */
    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    /** Номер машины.
     *
     * @return номер машины
     */
    public String getCarNumber() {
        return carNumber;
    }

}
