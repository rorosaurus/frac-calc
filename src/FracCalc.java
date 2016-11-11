import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to FracCalc!");
        String prompt = "Enter an equation to calculate, or type \"test\" to run tests, or \"quit\" to quit.";
        System.out.println(prompt);
        String input = scanner.nextLine();

        while(!input.equals("quit")) {

            if (input.equals("test")) runTests();
            else {
                System.out.println("Your answer is: " + produceAnswer(input));
                System.out.println(prompt);
            }

            input = scanner.nextLine();
        }
        System.out.println("Goodbye.");
    }

    public static String produceAnswer(String input) {

        return input;
    }

    public static void runTests() {
        System.out.println("Running tests...");

        // test error conditions
        test("1/0 + 1", "ERROR: Cannot divide by zero."); // test divide by zero
        test("1 ++ 2", "ERROR: Input is in an invalid format."); // test invalid formatting

        // test valid scenarios
        test("3/4 * -5/6", "-5/8"); // test negative fractions
        test("3/2 + 2/2", "2_1/2"); // test reduceable fractions
        test("3 + 4", "7"); // test whole numbers
        test("1_3/4 / 2_3/4", "7/176"); // test mixed fractions

        System.out.println("All tests have been run.  Do you see any failures?");
    }

    public static boolean test(String input, String expectedOutput) {
        boolean pass = true;
        String programOutput = produceAnswer(input);

        if (!programOutput.equals(expectedOutput)) {
            System.out.println("Testing input string: " + input);
            System.out.println("Expecting output: " + expectedOutput);
            System.out.println("Actual output: " + programOutput);
            System.out.println("TEST FAILED!");
            pass = false;
        }
        return pass;
    }
}
