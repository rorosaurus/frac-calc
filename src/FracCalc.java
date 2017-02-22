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
                String answer = produceAnswer(input);

                System.out.println(answer);
                System.out.println(prompt);
            }

            input = scanner.nextLine();
        }
        System.out.println("Goodbye!");
    }

    public static String produceAnswer(String input) {
        // first separate the input into tokens separated by spaces
        String[] inputs = input.split(" ");

        // next check for error conditions
        boolean inputValid = true;
        if (inputs.length < 3  || inputs.length % 2 == 0) { // do we have the right amount of tokens?
            inputValid = false;
        }

        for (int i = 0; i < inputs.length; i++) { // are those tokens what we expect them to be?
            if (i % 2 == 0) {
                inputValid = inputValid && isValidFrac(inputs[i]);
            }
            else inputValid = inputValid && isValidOperator(inputs[i]);
        }

        if (!inputValid) { // if anything was invalid, return an error
            return "ERROR: Input is in an invalid format.";
        }

        // last do the computation (remember to check for divide by zero!)
        // todo: check for div by zero
        return ""; // todo: update return
    }

    public static String reduceFrac(String frac) {
        return ""; // todo: implement
    }

    public static boolean isValidFrac(String frac) {
        return true; // todo: implement
    }

    public static boolean isValidOperator(String op) {
        return op.equals("*") || op.equals("/") || op.equals("+") || op.equals("-");
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
