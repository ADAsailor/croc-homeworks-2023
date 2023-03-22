package ru.croc.daria.aladina.objects;

import java.util.Arrays;

/**
 * Парковка.
 *
 * @author Daria Aladina
 */
public class Parking {
    /**
     * Въезды на парковку.
     */
    private final Entrance[] entrances;
    /**
     * Выезды с прковки.
     */
    private final Exit[] exits;
    /**
     * Общее количество мест на парковке.
     */
    private final int totalNumberOfSeats;

    /**
     * Попытки въездов на парковку.
     */
    private EntryAttempt[] entryAttemptList = new EntryAttempt[0];


    /**
     * Автоматически инициализирует объект класса Parking во время его создания.
     *
     * @param entrances          въезды
     * @param exits              выезды
     * @param totalNumberOfSeats общее количество мест на парковке
     */
    public Parking(Entrance[] entrances, Exit[] exits, int totalNumberOfSeats) {
        this.entrances = entrances;
        this.exits = exits;
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    /**
     * Въезды.
     *
     * @return въезды
     */
    public Entrance[] getEntrances() {
        return entrances;
    }

    /**
     * Выезды.
     *
     * @return выезды
     */
    public Exit[] getExits() {
        return exits;
    }

    /**
     * Позволяет узнать список неудачных попыток въезда на парковку, с указанием номера машины и времени.
     * <p>
     * Если неудачных попыток въезда не было, то выводит в консоль сообщение "Неудачные попытки въезда отсутствуют.".
     * Иначе нуаечатает полный список неудачных попыток с указанием номера машины и времени попытки.
     */
    public void unsuccessfulEntryAttemptList() {
        boolean flag = false;
        for (int i = 0; i < entryAttemptList.length; i++) {
            if (!entryAttemptList[i].getStatus()) {
                System.out.println("[номер машины: " + entryAttemptList[i].getCar().getCarNumber() + ", время неудачного въезда - " + entryAttemptList[i].getAttemptTime() + "]");
                flag = true;
            }
        }
        if (!flag)
            System.out.print("Неудачные попытки въезда отсутствуют.");
        System.out.println();
    }

    /**
     * Добавляет попытку въезда в массив попыток въезда на парковку.
     *
     * @param entryAttempt попытка въезда
     */
    public void addToEntryAttemptList(EntryAttempt entryAttempt) {
        if (entryAttemptList.length != 0) {
            entryAttemptList = Arrays.copyOf(entryAttemptList, entryAttemptList.length + 1);
            entryAttemptList[entryAttemptList.length - 1] = entryAttempt;
        } else entryAttemptList = new EntryAttempt[]{entryAttempt};
    }

    /**
     * Проверяет возможность въезда на парковку (есть ли свободные места?).
     *
     * @return true если въезд возможен, иначе false
     */
    public boolean checkingThePossibilityOfEntry() {
        if (freeParkingSpace() == 0)
            return false;
        return true;
    }

    /**
     * Позволяет узнать сможет автомобиль заехать на парковку или нет.
     * Выводит соответствующие сообщения.
     * <p>
     * Напечатает в консоль сообщение: "Въезд на парковку возможен!", если въезд возможен
     * Напечатает в консоль сообщение: "Въезд на парковку невозможен.", если въезд невозможен
     */
    public void possibilityOfEntry() {
        if (checkingThePossibilityOfEntry())
            System.out.println("Въезд на парковку возможен!");
        else System.out.println("Въезд на парковку невозможен.");
    }

    /**
     * Проверяет выезжала ли машина с указанным номером с парковки.
     *
     * @param carNumber номер машины
     * @return true если выезд был, иначе false
     */
    public boolean checkingTheCarExit(String carNumber) {
        for (int i = 0; i < exits.length; i++) {
            for (int j = 0; j < exits[i].getExitCarList().length; j++)
                if (carNumber == exits[i].getExitCarList()[j].getCarNumber())
                    return true;
        }
        return false;
    }

    /**
     * Выводит количество свободных мест на парковке.
     *
     * @return количество свободных мест на парковке
     */
    public int freeParkingSpace() {
        int count = totalNumberOfSeats;
        if (entryAttemptList.length == 0)
            return count;
        for (int i = 0; i < entryAttemptList.length; i++) {
            if (entryAttemptList[i].getStatus() && !checkingTheCarExit(entryAttemptList[i].getCar().getCarNumber())) {
                count--;
            }
        }
        return count;
    }

    /**
     * Въезд автомобиля с номером XXX в определённый момент времени и через определенный въезд.
     *
     * @param car         машина
     * @param attemptTime время въезда
     * @param entrance    въезд
     */
    public void enter(Car car, String attemptTime, Entrance entrance) {
        if (checkingThePossibilityOfEntry()) {
            EntryAttempt entryAttempt = new EntryAttempt(car, attemptTime, entrance, true);
            addToEntryAttemptList(entryAttempt);
            entrance.addToEntranceCarList(car);
        } else {
            EntryAttempt entryAttempt = new EntryAttempt(car, attemptTime, entrance, false);
            addToEntryAttemptList(entryAttempt);
            //System.out.println("Въезд невозможен. Нет свободных мест");
        }
    }

    /**
     * Выезд автомобиля с номером XXX через определенный выезд.
     *
     * @param car  машина
     * @param exit выезд
     */
    public void exit(Car car, Exit exit) {
        boolean flag = true;
        if (freeParkingSpace() != totalNumberOfSeats) {
            for (int i = 0; i < entryAttemptList.length; i++) {
                if (entryAttemptList[i].getCar().getCarNumber() == car.getCarNumber() && entryAttemptList[i].getStatus()) {
                    exit.addToExitCarList(car);
                    flag = false;
                }
            }
            if (flag)
                System.out.println("Машины нет на парковке. Выезд невозможен.");
        } else System.out.println("Парковка пуста. Выезд невозможен.");
    }

    /**
     * Предоставляет список машин, проехавших через определённый въезд.
     *
     * @param entrances въезды
     */
    public void entranceCarList(Entrance[] entrances) {
        for (int i = 0; i < entrances.length; i++) {
            System.out.print(entrances[i].getEntranceNumber() + " : ");
            entrances[i].entranceCarListToString();
        }
    }

    /**
     * Предоставляет список машин, проехавших через определённый выезд.
     *
     * @param exits выезд
     */
    public void exitCarList(Exit[] exits) {
        for (int i = 0; i < exits.length; i++) {
            System.out.print(exits[i].getExitNumber() + " : ");
            exits[i].exitCarListToString();
        }
    }
}
