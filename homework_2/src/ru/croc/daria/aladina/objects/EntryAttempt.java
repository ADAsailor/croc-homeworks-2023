package ru.croc.daria.aladina.objects;

/**
 * Попытка въезда.
 *
 * @author Daria Aladina
 */
public class EntryAttempt {
    /** Машина. */
    private final Car car;
    /** Время попытки въезда. */
    private final String attemptTime;
    /** Въезд. */
    private final Entrance entrance;
    /** Статус попытки въезда. */
    private final boolean status;

    /**
     * Автоматически инициализирует объект класса EntryAttempt во время его создания.
     *
     * @param car машина
     * @param attemptTime время попытки въезда
     * @param entrance въезд
     * @param status статус попытки въезда
     */
    public EntryAttempt(Car car, String attemptTime, Entrance entrance, boolean status) {
        this.car = car;
        this.attemptTime = attemptTime;
        this.entrance = entrance;
        this.status = status;
    }

    /** Машина.
     *
     * @return машина
     */
    public Car getCar() {
        return car;
    }

    /** Время попытки въезда.
     *
     * @return время попытки въезда
     */
    public String getAttemptTime() {
        return attemptTime;
    }

    /** Въезд.
     *
     * @return въезд
     */
    public Entrance getEntrance() {
        return entrance;
    }

    /**
     * Статус попытки въезда.
     *
     * @return статус попытки въезда
     */
    public boolean getStatus() {
        return status;
    }
}
