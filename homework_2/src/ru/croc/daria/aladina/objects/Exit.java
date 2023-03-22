package ru.croc.daria.aladina.objects;

import java.util.Arrays;

/**
 * Пункт выезда.
 *
 * @author Daria Aladina
 */
public class Exit {
    /** Номер выезда. */
    private final int exitNumber;
    /** Описание выезда. */
    private final String exitDescription;

    /** Список машин, которые выехали из данного выезда. */
    private Car[] exitCarList = new Car[0];

    /**
     * Автоматически инициализирует объект класса Exit во время его создания.
     *
     * @param exitNumber номер выезда
     * @param exitDescription описание выезда
     */
    public Exit (int exitNumber, String exitDescription) {
        this.exitNumber = exitNumber;
        this.exitDescription = exitDescription;
    }

    /** Номер выезда.
     *
     * @return номер выезда
     */
    public int getExitNumber() {
        return exitNumber;
    }

    /** Описание выезда.
     *
     * @return описание выезда
     */
    public String getExitDescription() {
        return exitDescription;
    }

    /**
     * Список машин, которые выехали из данного выезда.
     *
     * @return список машин, которые выехали из данного выезда
     */
    public Car[] getExitCarList() {
        return exitCarList;
    }

    /**
     * Помогает вывести список машин, проехавших через любой существующий выезд.
     * Форматирует вывод списка.
     */
    public void exitCarListToString() {
        if (exitCarList.length != 0) {
            for (int i = 0; i < exitCarList.length-1; i++)
                System.out.print(exitCarList[i].getCarNumber() + ", ");
            System.out.print(exitCarList[exitCarList.length-1].getCarNumber()+".");
        } else  System.out.print("Машины не выезжали.");
        System.out.println();
    }

    /**
     * Добавление определённого автомобиля в список машин, которые выехали из данного выезда.
     *
     * @param car машина
     */
    public void addToExitCarList(Car car) {
        if (exitCarList.length != 0) {
            exitCarList = Arrays.copyOf(exitCarList, exitCarList.length + 1);
            exitCarList[exitCarList.length - 1] = car;
        } else exitCarList = new Car[]{car};
    }
}
