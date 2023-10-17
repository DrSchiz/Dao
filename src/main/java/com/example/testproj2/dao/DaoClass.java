package com.example.testproj2.dao;

import com.example.testproj2.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoClass<T> implements DaoInterface{
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

        schools.add(new School(++schoolCount, "2087", "Ул. Пушкина, Д. Колотушника", 213));
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
    public enum classes { User, School, Equipment, Country, Car }

    @Override
    public void save(Object tClass) {
        if (tClass.getClass().getSimpleName().equals("User")) {
            User user = (User) tClass;
            user.setId(++userCount);
            users.add(user);
        }
        if (tClass.getClass().getSimpleName().equals("School")) {
            School school = (School) tClass;
            school.setId(++schoolCount);
            schools.add(school);
        }
        if (tClass.getClass().getSimpleName().equals("Equipment")) {
            Equipment equipment = (Equipment) tClass;
            equipment.setId(++equipmentCount);
            equipments.add(equipment);
        }
        if (tClass.getClass().getSimpleName().equals("Country")) {
            Country country = (Country) tClass;
            country.setId(++countryCount);
            countries.add(country);
        }
        if (tClass.getClass().getSimpleName().equals("Car")) {
            Car car = (Car) tClass;
            car.setId(++carCount);
            cars.add(car);
        }
    }

    @Override
    public void update(Object tClass, int Id) {
        if (tClass.getClass().getSimpleName().equals("User")) {
            User user = (User) tClass;
            User newUser = (User) show(classes.User, Id);
            newUser.setLogin(user.getLogin());
            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
        }
        if (tClass.getClass().getSimpleName().equals("School")) {
            School school = (School) tClass;
            School newSchool = (School) show(classes.School, Id);
            newSchool.setAdress(school.getAdress());
            newSchool.setAmountStudents(school.getAmountStudents());
            newSchool.setName(school.getName());
        }
        if (tClass.getClass().getSimpleName().equals("Equipment")) {
            Equipment equipment = (Equipment) tClass;
            Equipment newEquipment = (Equipment) show(classes.Equipment, Id);
            newEquipment.setSize(equipment.getSize());
            newEquipment.setType(equipment.getType());
            newEquipment.setName(equipment.getName());
        }
        if (tClass.getClass().getSimpleName().equals("Country")) {
            Country country = (Country) tClass;
            Country newCountry = (Country) show(classes.Country, Id);
            newCountry.setLeader(country.getLeader());
            newCountry.setAmountOfNuclearWeapons(country.getAmountOfNuclearWeapons());
            newCountry.setName(country.getName());
        }
        if (tClass.getClass().getSimpleName().equals("Car")) {
            Car car = (Car) tClass;
            Car newCar = (Car) show(classes.Car, Id);
            newCar.setModel(car.getModel());
            newCar.setNumber(car.getNumber());
            newCar.setSold(car.isSold());
        }
    }

    @Override
    public void delete(Object tClass, int Id) {
        if (tClass.equals(classes.User)) {
            users.removeIf(user -> user.getId() == Id);
        }
        if (tClass.equals(classes.School)) {
            schools.removeIf(school -> school.getId() == Id);
        }
        if (tClass.equals(classes.Equipment)) {
            equipments.removeIf(equipment -> equipment.getId() == Id);
        }
        if (tClass.equals(classes.Country)) {
            countries.removeIf(country -> country.getId() == Id);
        }
        if (tClass.equals(classes.Car)) {
            cars.removeIf(car -> car.getId() == Id);
        }
    }

    @Override
    public List<T> index(Object tClass) {
        if (tClass.equals(classes.User)) {
            return (List<T>) users;
        }
        if (tClass.equals(classes.School)) {
            return (List<T>) schools;
        }
        if (tClass.equals(classes.Equipment)) {
            return (List<T>) equipments;
        }
        if (tClass.equals(classes.Country)) {
            return (List<T>) countries;
        }
        if (tClass.equals(classes.Car)) {
            return (List<T>) cars;
        }
        return null;
    }

    @Override
    public Object show(classes classes, int Id) {
        switch (classes) {
            case User -> {
                return users.stream().filter(user -> user.getId() == Id).findAny().orElse(null);
            }
            case School -> {
                return schools.stream().filter(user -> user.getId() == Id).findAny().orElse(null);
            }
            case Equipment -> {
                return equipments.stream().filter(user -> user.getId() == Id).findAny().orElse(null);
            }
            case Country -> {
                return countries.stream().filter(user -> user.getId() == Id).findAny().orElse(null);
            }
            case Car -> {
                return cars.stream().filter(user -> user.getId() == Id).findAny().orElse(null);
            }
        }
        return null;
    }

//    public List<User> index() {
//        return users;
//    }

//    public User show(int Id) {
//        return users.stream().filter(user -> user.getId() == Id).findAny().orElse(null);
//    }
//
//    public void save(User user) {
//        user.setId(++userCount);
//        users.add(user);
//    }
//
//    public void update(int Id, User updatedUser) {
//        User newUser = show(Id);
//        newUser.setLogin(updatedUser.getLogin());
//        newUser.setEmail(updatedUser.getEmail());
//        newUser.setName(updatedUser.getName());
//    }
//
//    public void delete(int Id) {
//        users.removeIf(user -> user.getId() == Id);
//    }
}
