package Day3;

import joinery.DataFrame;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joinery {

    String PATH = "src/main/resources/titanic.csv";
    public static void main(String[] args){

        Joinery joinery = new Joinery();
        try {

            DataFrame<Object> titanicData = DataFrame.readCsv(joinery.PATH);
            System.out.println(titanicData.describe());

            //Add new random numbers column
            System.out.println("Adding new Random Numbers column");
            DataFrame dataWithRandomNumbers = joinery.addRandomNumbersColumnToData(titanicData);
            System.out.println(dataWithRandomNumbers.describe());
            //dataWithRandomNumbers.iterrows().forEachRemaining(System.out::println);

            System.out.println("\n");

            //Add new index column
            System.out.println("Adding new index column");
            DataFrame dataWithIndex = joinery.addIndexColumnToData(titanicData);
            System.out.println(dataWithIndex.describe());
            //dataWithIndex.iterrows().forEachRemaining(System.out::println);

            System.out.println("\n");

            // Load data in DataFrame and perform data exploration
            System.out.println("Survived Data");
            DataFrame<Object> survivedDataFrame = dataWithIndex
                    .retain("index", "name", "pclass", "survived")
                    .groupBy("pclass")
                    .describe();

            System.out.println(survivedDataFrame.describe());
            //survivedDataFrame.iterrows().forEachRemaining(System.out::println);

            System.out.println("\n");

            System.out.println("Person Data");
            DataFrame<Object> personDataFrame = dataWithIndex
                    .retain("index", "name", "pclass", "sex", "age")
                    .groupBy("sex")
                    .describe();
            System.out.println(personDataFrame.describe());
            //personDataFrame.iterrows().forEachRemaining(System.out::println);

            System.out.println("\n");

            System.out.println("Joined Data");
            DataFrame joiningDataFrames = survivedDataFrame
                    .joinOn(personDataFrame, DataFrame.JoinType.INNER,"index");
            System.out.println(joiningDataFrames.describe());



        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public  DataFrame addRandomNumbersColumnToData(DataFrame data){
        int dataSize = data.length();
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i=0; i<dataSize; i++)
            randomNumbers.add(new Random().nextInt(1000));
        data.add("Fake Random Numbers", randomNumbers);
        return data;
    }

    public  DataFrame addIndexColumnToData(DataFrame data){
        int dataSize = data.length();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i=1; i<=dataSize; i++)
            index.add(i);
        data.add("index", index);
        return data;
    }
}
