package org.example;
import org.apache.commons.lang3.RandomStringUtils;
public class CourierGenerator {
    public static Courier getRandomCourier() {
        final String courierLogin = RandomStringUtils.randomAlphabetic(7);
        final String courierPassword = RandomStringUtils.randomAlphabetic(7);
        final String courierFirstName = RandomStringUtils.randomAlphabetic(7);
        return new Courier(courierLogin, courierPassword, courierFirstName);
    }

    public static Object getWithPasswordOnly() {
        return new Courier("","1234","");
    }

    public static Object getWithLoginOnly() {
        return new Courier("ninja","","");
    }

    public static Object getWithPasswordNull() {
        return new Courier("ninja",null,"saske");
    }

    public static Object getWithPasswordEmpty() {
        return new Courier("cate"," ","saske");
    }

    public static Object getWithIdenticalCourier() {
        return new Courier("ninja","546","saske");
    }

    public static Object getWithExistingLogin() {
        return new Courier("ninja","123","sasha");
    }
}
