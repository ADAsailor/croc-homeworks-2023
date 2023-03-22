package ru.croc.daria.aladina.objects;

import java.util.Arrays;

/**
 * Пункт въезда.
 *
 * @author Daria Aladina
 */
public class Entrance {
    /** Номер въезда. */
    private final int entranceNumber;
    /** Описание въезда. */
    private final String entranceDescription;

    /** Список машин, которые въехали в данный въезд. */
    private Car[] entranceCarList = new Car[0];

    /**
     * Автоматически инициализирует объект класса Entry во время его создания.
     *
     * @param entranceNumber номер въезда
     * @param entranceDescription описание въезда
     */
    public Entrance (int entranceNumber, String entranceDescription) {
        this.entranceNumber = entranceNumber;
        this.entranceDescription = entranceDescription;
    }

    /** Номер въезда.
     *
     * @return номер въезда
     */
    public int getEntranceNumber() {
        return entranceNumber;
    }

    /** Описание въезда.
     *
     * @return описание въезда
     */
    public String getEntranceDescription() {
        return entranceDescription;
    }

    /**
     * Помогает вывести список машин, проехавших через любой существующий въезд.
     * Форматирует вывод списка.
     */
    public void entranceCarListToString() {
        if (entranceCarList.length != 0) {
            for (int i = 0; i < entranceCarList.length-1; i++)
                System.out.print(entranceCarList[i].getCarNumber() + ", ");
            System.out.print(entranceCarList[entranceCarList.length-1].getCarNumber()+".");
        } else  System.out.print("Машины не въезжали.");
        System.out.println();
    }

    /**
     * Добавление определённого автомобиля в список машин, которые въехали в данный въезд.
     *
     * @param car машина
     */
    public void addToEntranceCarList(Car car) {
        if (entranceCarList.length != 0) {
            entranceCarList = Arrays.copyOf(entranceCarList, entranceCarList.length + 1);
            entranceCarList[entranceCarList.length - 1] = car;
        } else entranceCarList = new Car[]{car};
    }
}
