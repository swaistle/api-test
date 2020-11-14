package bpdts.pages;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomCityGenerator {

    public static String randomCity() {
        List<String> cities = new LinkedList<String>();
        //English characters, one result
        cities.add("Kax");
        //English characters, multiple results
        cities.add("London");
        //No result
        cities.add("Newcastle");
        //Special characters
        cities.add("Al Bayḑā’");
        cities.add("Shi’ao");
        cities.add("Bonneuil-sur-Marne");
        cities.add("Caldas da Felgueira");
        cities.add("Dubova (Driloni)");
        //Longest string
        cities.add("Morcellemont Saint André");
        //Non-english characters
        cities.add("Krzyżowice");
        cities.add("Älvsjö");
        cities.add("Vairão");
        cities.add("Phú Lộc");
        cities.add("Saint-Égrève");
        cities.add("Aţ Ţaybah");
        cities.add("Chợ Mới");
        cities.add("Trần Văn Thời");
        cities.add("Gœsdorf");
        cities.add("كاف الجاع");

        Random random = new Random();
        int randomNumber = random.nextInt(cities.size());
        String result = cities.get(randomNumber);
        return result;
    }
}
