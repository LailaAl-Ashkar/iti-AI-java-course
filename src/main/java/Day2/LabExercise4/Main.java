package Day2.LabExercise4;

import java.util.List;
import java.util.stream.Collectors;

import Day1.Pyramid;
import Day1.PyramidCSVDAO;

public class Main {

    public static void main(String[] args) {
        String PATH = "src/main/resources/pyramids.csv";
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.ReadPyramidsFormCSV(PATH);

        List<Double> heights = pyramids.stream().filter(pyramid -> pyramid.getHeight()>0).
                map(Pyramid::getHeight).sorted().collect(Collectors.toList());

        System.out.printf("Median of heights = %.2f%n", quartiles(heights));

        System.out.printf("Lower quartile = %.2f%n", quartiles(heights.subList(0, heights.size()/2)));

        System.out.printf("Upper quartile = %.2f%n", quartiles(heights.subList(heights.size()/2, heights.size())));

        double sumOfHeights = 0;
        for (double height : heights)
            sumOfHeights += height;
        System.out.printf("Average of heights: %.2f%n", sumOfHeights/heights.size());

    }

    public static Double quartiles(List<Double> heights){
        return (heights.size() % 2 == 0) ?
                ((heights.get(heights.size() / 2) + heights.get((heights.size() / 2) - 1)) / 2)
                : heights.get((heights.size() - 1) / 2);
    }


}
