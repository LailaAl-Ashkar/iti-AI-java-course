package Day2.LabExercise1;

import java.util.ArrayList;

public class Country {

    private int id;
    private String countryName;
    private ArrayList<City> listOfCities;

    public Country(int id, String countryName) {
        this.id = id;
        this.countryName = countryName;
        this.listOfCities = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<City> getListOfCities() {
        return listOfCities;
    }

    public void setListOfCities(ArrayList<City> listOfCities) {
        this.listOfCities = listOfCities;
    }

    public void addCityToCountry(City city){
        listOfCities.add(city);
    }
}
