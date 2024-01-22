package org.example;

import org.example.house.houseClasses.Appartment;
import org.example.house.houseClasses.House;



// 1 уровень сложности: Используйте Stream API для решения заданий:
//1.1 Создайте класс Дом, содержащий список Квартир. Каждая квартира
// содержит список комнат. Каждая комната содержит площадь.
// Посчитайте суммарную жилую площадь дома.
//1.2 Среди всех квартир найдите квартиру, площадь которой больше
// 100 кв. м. Если такая квартира найдена, то выведите её площадь.
// В противном случае выведите сообщение, что такой квартиры нет.
//1.3 Старый дом расселяют. В новом доме жильцы должны получить квартиры
// большей площади. Создайте новый список квартир дома, увеличив площадь
// каждой комнаты на 30%.
//1.4 Дан список, каждый элемент которого – это мапа площадей комнат
// (комната - площадь). Создайте новые квартиры с комнатами заданных площадей.

public class Main {
    public static void main(String[] args) {

        House house = new House();
        System.out.println(house);

        int totalArea = house.getAppartmentList().stream()
                .flatMap(appartment -> appartment.getFlatList().stream())
                .mapToInt(Appartment.Flat::getArea)
                .sum();
        System.out.println("Total area " + totalArea);

        Integer bigAppartamentArea = house.getAppartmentList().stream()
                .filter(appartment -> appartment.getFlatList()
                        .stream()
                        .mapToInt(Appartment.Flat::getArea)
                        .sum() > 70)
                .map(appartment -> appartment.getFlatList().stream()
                        .mapToInt(Appartment.Flat::getArea)
                        .sum()).findFirst().orElse(null);

        System.out.printf("First of most biggest apparts is %s%n",
                bigAppartamentArea != null ? String.valueOf(bigAppartamentArea) : "not");

        House newHouse = house.clone();

        newHouse.getAppartmentList().forEach(oldAppartment -> {
            oldAppartment.getFlatList().forEach(oldFlat -> {
                int oldArea = oldFlat.getArea();
                oldFlat.setArea((int) (oldArea * 1.3));
            });
        });

        System.out.println("New flats: " + newHouse);

    }

}
