package bpdts.utility;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomCityGenerator {

    public static String randomCity() {
        List<String> cities = new LinkedList<String>();
        cities.add("Kax");
        cities.add("Kundung");
        cities.add("Qaryat al Qābil");
        cities.add("Standerton");
        cities.add("Shuishi");
        cities.add("Budapest");
        cities.add("Danao");
        cities.add("Cimuncang");
        cities.add("Bamenda");
        cities.add("Armamar");
        cities.add("Shuibatang");
        cities.add("Los Angeles");
        cities.add("Antsohihy");
        cities.add("Lagunas");
        cities.add("Caqu");
        cities.add("Polowat");
        cities.add("Labansari");
        cities.add("كاف الجاع");
        cities.add("Sidi Yahya Ou Saad");
        cities.add("Cinagrog Girang");

        Random random = new Random();
        int randomNumber = random.nextInt(cities.size());
        String result = cities.get(randomNumber);
        return result;
    }
}
