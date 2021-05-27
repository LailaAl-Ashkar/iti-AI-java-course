package Day2.LabExercise2;

public class Main {
    public static void main(String[] args) {
        // Lambda Expression and Method Reference: Lab Exercise 1
        String first_str = "The first string";
        String second_str = "This is the longer string";

        String longer = StringUtils.betterString(first_str, second_str, (s1, s2) -> s1.length() > s2.length());
        String first = StringUtils.betterString(first_str, second_str, (s1, s2) -> true);

        System.out.println("Longer String is: " + longer);
        System.out.println("First String is: " + first);

        System.out.println();

        // Lambda Expression and Method Reference: Lab Exercise 2
        String alphaStr = "OnlyAlphabets";
        String notAlphaStr = "letters 2205 + Alphabets";

        System.out.println(StringUtils.isLetter(alphaStr)? "Contains only alphabets" : "Contains other characters");
        System.out.println(StringUtils.isLetter(notAlphaStr)? "Contains only alphabets" : "Contains other characters");

    }
}
