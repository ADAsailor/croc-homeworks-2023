package ru.croc.daria.aladina;
import ru.croc.daria.aladina.objects.*;

/**
 * Класс содержащий метод main.
 *
 * @author Daria Aladina
 */
public class Main {
    public static void main(String[] args) {

        // Создадим объект "парковка"
        // Инициализация въездов
        Entrance[] entrances = new Entrance[3];
        entrances[0] = new Entrance(1, "Общий въезд №1");
        entrances[1] = new Entrance(2, "Служебный въезд");
        entrances[2] = new Entrance(3, "Общий въезд №2");
        // Инициализация выездов
        Exit[] exits = new Exit[3];
        exits[0] = new Exit(1, "Общий выезд №1");
        exits[1] = new Exit(2, "Служебный выезд");
        exits[2] = new Exit(3, "Общий въезд №2");
        // Инициализация самого объекта "парковка" вместимостью 5 парковочных мест
        Parking parking = new Parking(entrances, exits, 5);
        // Создание объекта "парковка" завершено

        // Машины, желающие заехать на парковку
        Car[] cars = new Car[9];
        cars[0] = new Car("а123ес");
        cars[1] = new Car("б232ог");
        cars[2] = new Car("в345вр");
        cars[3] = new Car("г456мо");
        cars[4] = new Car("д534фх");
        cars[5] = new Car("е650ци");
        cars[6] = new Car("ё798хы");
        cars[7] = new Car("ж807эз");
        cars[8] = new Car("з905рв");

        parking.possibilityOfEntry(); // проверка возможности заезда на парковку
        System.out.println("Количество свободных мест: " + parking.freeParkingSpace()+"\n");

        // Попытка вызвать метод выезда с парковки в момент, когда парковка полностью пуста
        parking.exit(cars[0],exits[0]); // на парковки нет машин, выезд невозможен

        // Пытаются въехать три машины
        parking.enter(cars[0], "11:20", entrances[0]); // успешный въезд
        parking.enter(cars[1], "11:25", entrances[2]); // успешный въезд
        parking.enter(cars[2], "12:00", entrances[0]); // успешный въезд

        System.out.println("\nСписок машин, проехавших через соответствующие въезды: ");
        parking.entranceCarList(entrances);
        System.out.println("Количество свободных мест: " + parking.freeParkingSpace());

        // Одна из машин пытается выехать с парковки
        parking.exit(cars[0], exits[1]); // успешный выезд

        System.out.println("\nСписки машин, проехавших через соответствующие выезды: ");
        parking.exitCarList(exits);
        System.out.println("Количество свободных мест: " + parking.freeParkingSpace());

        System.out.println("\nСписок неудачных попыток въезда: ");
        parking.unsuccessfulEntryAttemptList();

        // Пытаются въехать ещё четыре машины
        parking.enter(cars[3], "13:10", entrances[1]); // успешный въезд
        parking.enter(cars[4], "13:45", entrances[2]); // успешный въезд
        parking.enter(cars[5], "14:03", entrances[0]); // успешный въезд
        parking.enter(cars[6], "16:00", entrances[0]); // к этому моменту все места на парковке заняты

        System.out.println("Количество свободных мест: " + parking.freeParkingSpace());
        System.out.println("\nСписок неудачных попыток въезда: ");
        parking.unsuccessfulEntryAttemptList();

        System.out.println("\nСписки машин, проехавших через соответствующие въезды: ");
        parking.entranceCarList(entrances);
        System.out.println("Количество свободных мест: " + parking.freeParkingSpace()+"\n");

        // Пытается въехать ещё одна машина
        parking.possibilityOfEntry(); // проверка возможности заезда на парковку
        parking.enter(cars[7], "16:50", entrances[1]); // к этому моменту все места на парковке заняты

        System.out.println("\nСписки машин, проехавших через соответствующие въезды: ");
        parking.entranceCarList(entrances);
        System.out.println("Количество свободных мест: " + parking.freeParkingSpace());

        System.out.println("\nСписок неудачных попыток въезда: ");
        parking.unsuccessfulEntryAttemptList();

        // Три машины пытаются выехать с парковки
        parking.exit(cars[4], exits[2]); // успешный выезд
        parking.exit(cars[6], exits[0]); // этого авто нет на парковке (был неудачный въезд)
        parking.exit(cars[8], exits[1]); // этого авто нет на парковке (даже не пыталась въехать ранее)

        System.out.println("\nСписки машин, проехавших через соответствующие выезды: ");
        parking.exitCarList(exits);
        System.out.println("Количество свободных мест: " + parking.freeParkingSpace());

        // Четыре машины, находящиеся на парковке, пытаются выехать
        parking.exit(cars[3], exits[1]); // успешный выезд
        parking.exit(cars[5], exits[1]); // успешный выезд
        parking.exit(cars[1], exits[0]); // успешный выезд
        parking.exit(cars[2], exits[2]); // успешный выезд

        System.out.println("\nСписки машин, проехавших через соответствующие въезды: ");
        parking.entranceCarList(entrances);

        System.out.println("\nСписки машин, проехавших через соответствующие выезды: ");
        parking.exitCarList(exits);
        System.out.println("Количество свободных мест: " + parking.freeParkingSpace());
        // У списков номеров машин для въездов и выездов общее количество машин и их номера совпадают.
        // Программа работает корректно :)

        // Парковка свободна!

    }
}
