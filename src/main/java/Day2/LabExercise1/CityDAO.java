package Day2.LabExercise1;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {
    public ArrayList<City> readCitiesFormCSV;
    File citiesFile;

    public CityDAO() {
        this.readCitiesFormCSV = new ArrayList<City>();
    }

    public ArrayList<City> ReadCitiesFormCSV(String fileName) {
        citiesFile = new File(fileName);
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(citiesFile.toPath());
        } catch (Exception e) {
            System.out.println("An issue happened while reading Cities file: " + e);
        }
        for (int lineIdx = 1; lineIdx < lines.size(); lineIdx++) {
            String line = lines.get(lineIdx);
            String[] data = line.split(",");
            readCitiesFormCSV.add(createCity(data));
        }
        return readCitiesFormCSV;
    }

    public City createCity(String[] metadata) {
        City City = new City(Integer.parseInt(metadata[0]), metadata[1], metadata[2], Double.parseDouble(metadata[3]),
                Double.parseDouble(metadata[4]));
        return City;
    }
}
