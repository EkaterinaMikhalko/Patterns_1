package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    static Faker faker = new Faker(new Locale ("ru"));
    public static String generateDate(int shift) {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd.MM.YYYY");
        LocalDate currentDate = LocalDate.now();
        String date = currentDate.plusDays(shift).format(dateTimeFormat);
        return date;
    }

    public static String generateCity() {
        String city = faker.address().city();
        return city;
    }

    public static String generateName() {
        String name = faker.name().lastName().replace("ё", "е") + " " + faker.name().firstName().replace("ё", "е");
        return name;
    }

    public static String generatePhone() {
        return Faker.instance().numerify("+7##########");
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(), generateName(), generatePhone());
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}