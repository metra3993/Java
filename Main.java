import java.util.Scanner; // Добавляем класс Scanner из пакета java.util

public class Main { // Объявление класса Main

    public static void main(String[] args) { // Основной метод программы
        Scanner scanner = new Scanner(System.in); // Добавление объекта Scanner для считывания ввода пользователя с консоли

        System.out.println("Калькулятор расстояния между двумя точками на земной поверхности."); // Вывод сообщения

        System.out.println("Введите координаты первой точки:"); // Ввод координат первой точки
        double w1 = readCoordinate(scanner, "Широта"); // Вызов метода для широты первой точки
        double d1 = readCoordinate(scanner, "Долгота"); // Вызов метода для долготы первой точки

        System.out.println("Введите координаты второй точки:"); // Ввол координат второй точки
        double w2 = readCoordinate(scanner, "Широта"); // Вызов метода для широты второй точки
        double d2 = readCoordinate(scanner, "Долгота"); // Вызов метода для долготы второй точки

        double distance = calculateDistance(w1, d1, w2, d2); // Вызов метода для вычисления расстояния между точками

        System.out.println("Расстояние между точками: " + distance + " км"); // Вывод расстояния между точками

        scanner.close(); // Закрытие объекта Scanner
    }

    // Метод для считывания координаты с консоли
    private static double readCoordinate(Scanner scanner, String coordinateName) {
        System.out.print(coordinateName + ": "); // Вывод приглашения к вводу координаты
        return scanner.nextDouble(); // Возвращение считанного значения
    }

    // Метод для вычисления расстояния между двумя точками на поверхности Земли
    private static double calculateDistance(double w1, double d1, double w2, double d2) {
        final double EARTH_RADIUS = 6371.0; // Объявление и инициализация константы для радиуса Земли в километрах

        // Преобразование широт и долгот в радианы
        double latitudeDistance = Math.toRadians(w2 - w1);
        double longitudeDistance = Math.toRadians(d2 - d1);

        // Вычисление расстояния
        double a = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2)
                + Math.cos(Math.toRadians(w1)) * Math.cos(Math.toRadians(w2))
                * Math.sin(longitudeDistance / 2) * Math.sin(longitudeDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)); // Вычисление части формулы

        return EARTH_RADIUS * c; // Возвращение рассчитанного расстояния
    }
}
