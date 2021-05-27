package Day2.LabExercise1;

public class City {
    private int code;
    private String cityName, continent;
    private double surfaceArea, population;

    public City(int code, String cityName, String continent, double surfaceArea, double population) {
        this.code = code;
        this.cityName = cityName;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }
}
