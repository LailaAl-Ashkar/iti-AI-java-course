package Day1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String PATH = "src/main/resources/pyramids.csv";
        PyramidCSVDAO pDAO = new PyramidCSVDAO();

        List<Pyramid> pyramids = pDAO.ReadPyramidsFormCSV(PATH);

        int i = 0;
        for (Pyramid pyramid : pyramids)
            System.out.println("#" + (++i) + " " + pyramid);
    }
}
