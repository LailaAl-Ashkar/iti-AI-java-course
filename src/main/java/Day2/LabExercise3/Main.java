package Day2.LabExercise3;

import Day2.LabExercise1.*;
import org.checkerframework.checker.nullness.Opt;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        Main main = new Main();
        CityDAO cityDAO = new CityDAO();
        CountryDAO countryDAO = new CountryDAO();

        ArrayList<City> cities = cityDAO.ReadCitiesFormCSV("src/main/resources/cities.csv");
        Collections.sort(cities, Comparator.comparing(City::getPopulation));
        ArrayList<Country> countries = countryDAO.ReadCountriesFormCSV("src/main/resources/countries.csv");

        System.out.println("Highest population city by country: " + main.highestPopulationCityByCountry(cities));
        System.out.println();
        System.out.println("Highest population city by continent" + main.highestPopulationCityByContinent(cities));
        System.out.println();
        System.out.println("Highest population capital" + main.highestPopulationCapital(cities));
    }

    public Map<Integer, Optional<City>> highestPopulationCityByCountry(ArrayList<City> cities){
        return cities.stream()
                .collect(Collectors.groupingBy(City::getCode,
                        Collectors.maxBy(Comparator.comparingDouble(pop -> pop.getPopulation()))));
    }

    public Map<String, Optional<City>> highestPopulationCityByContinent(ArrayList<City> cities){
        return cities.stream().collect(Collectors.groupingBy(City::getContinent,
                Collectors.maxBy(Comparator.comparingDouble(pop -> pop.getPopulation()))));
    }

    public Optional<String> highestPopulationCapital(ArrayList<City> cities){
        return cities.stream().filter(city -> city.isCapital())
                .max(Comparator.comparingDouble(city -> city.getPopulation())).map(City::getCityName);
    }
}
