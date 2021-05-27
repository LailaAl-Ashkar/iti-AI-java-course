package Day2.LabExercise1;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Lab Exercise 1: Collections
        Map<Integer, ArrayList<String>> citiesMap = new HashMap<>();

        CityDAO cityDAO = new CityDAO();
        CountryDAO countryDAO = new CountryDAO();

        ArrayList<City> cities = cityDAO.ReadCitiesFormCSV("src/main/resources/cities.csv");
        Collections.sort(cities, Comparator.comparing(City::getPopulation));
        ArrayList<Country> countries = countryDAO.ReadCountriesFormCSV("src/main/resources/countries.csv");

        //Add list of cities to their countries
        for (int countryIdx = 0; countryIdx < countries.size(); countryIdx++) {
            for (int cityIdx = 0; cityIdx < cities.size(); cityIdx++) {
                if (cities.get(cityIdx).getCode() == countries.get(countryIdx).getId())
                    countries.get(countryIdx).addCityToCountry(cities.get(cityIdx));
            }
        }

        //Print list of cities in each country
//            for(Country country : countries) {
//                ArrayList<City> citiesL = country.getListOfCities();
//                for (City city : citiesL)
//                    System.out.print(city.getCityName() + "  ");
//                System.out.println();
//            }

        for(City city : cities) {
            if (citiesMap.get(city.getCode()) == null)
                citiesMap.put(city.getCode(), new ArrayList<>());
            citiesMap.get(city.getCode()).add(city.getCityName());
        }
        System.out.println("Print List of cities sorted according to population sorted from lowest to highest");
        citiesMap.forEach((k,v) -> System.out.println("Code: " + k + ", List of cities: " + v));

        System.out.println("\n");
    }
}
