package Day2.LabExercise1;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    public ArrayList<Country> readCountriesFormCSV;
    File countryFile;

    public CountryDAO() {
        this.readCountriesFormCSV = new ArrayList<Country>();
    }

    public ArrayList<Country> ReadCountriesFormCSV(String fileName) {
        countryFile = new File(fileName);
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(countryFile.toPath());
        } catch (Exception e) {
            System.out.println("An issue happened while reading Countries file: " + e);
        }
        for (int lineIdx = 1; lineIdx < lines.size(); lineIdx++) {
            String line = lines.get(lineIdx);
            String[] data = line.split(",");
            readCountriesFormCSV.add(createCountry(data));
        }
        return readCountriesFormCSV;
    }

    public Country createCountry(String[] metadata) {
        Country Country = new Country(Integer.parseInt(metadata[0]), metadata[1]);
        return Country;
    }
}
