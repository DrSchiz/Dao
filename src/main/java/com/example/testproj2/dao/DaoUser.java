package com.example.testproj2.dao;

import com.example.testproj2.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoUser{
    private static int userCount;
    private final List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++userCount, "5rubley", "sergeyts04@yandex.ru", "Сергей"));
        users.add(new User(++userCount, "osereps", "osereps@yandex.ru", "Александр"));
    }

    private static int schoolCount;
    private final List<School> schools;

    {
        schools = new ArrayList<>();

        schools.add(new School(++schoolCount, "2087", "Ул. Пушкина, Д. Колотушника", 214));
    }

    private static int equipmentCount;
    private final List<Equipment> equipments;

    {
        equipments = new ArrayList<>();

        equipments.add(new Equipment(++equipmentCount, "Станок", "Заводское оборудование", 5));
        equipments.add(new Equipment(++equipmentCount, "Топор", "Дровокол", 1));
    }

    private static int countryCount;
    private final List<Country> countries;

    {
        countries = new ArrayList<>();

        countries.add(new Country(++countryCount, "Россия", 5977, "Путин"));
        countries.add(new Country(++countryCount, "Беларусь", 0, "Лукашенко"));
    }

    private static int carCount;
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++carCount, "Тойота", "5977", false));
        cars.add(new Car(++carCount, "Лада нива", "9123", true));
    }

    public List<User> index() {
        return users;
    }

    public User show(int Id) {
        return users.stream().filter(user -> user.getId() == Id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++userCount);
        users.add(user);
    }

    public void update(int Id, User updatedUser) {
        User newUser = show(Id);
        newUser.setLogin(updatedUser.getLogin());
        newUser.setEmail(updatedUser.getEmail());
        newUser.setName(updatedUser.getName());
    }

    public void delete(int Id) {
        users.removeIf(user -> user.getId() == Id);
    }
}
