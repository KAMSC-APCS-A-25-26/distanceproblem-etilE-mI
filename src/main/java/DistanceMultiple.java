/*
 * TODO: APCS-A Distance Program
 *
 * Write a program that:
 *  1. Asks the user how many inputs (pairs of points) they want to enter.
 *  2. For each input, prompt them to enter two points in the format:
 *         (x1,y1)(x2,y2)
 *     Example: (2,3)(7,3)
 *
 *  3. Use Scanner with a custom delimiter:
 *     This should ignore parentheses, commas, and spaces so only numbers remain.
 *
 *  4. Extract x1, y1, x2, y2 as doubles.
 *
 *  5. Compute the distance between the two points:
 *
 *  6. Print the results
 * 
 *  7. Repeat until all inputs have been processed.
 *
 * Example Inputs:
 *  How many inputs? 3
 *  Enter input 1 (like (x1,y1)(x2,y2)): (2,3)(7,3)
 *  Enter input 2 (like (x1,y1)(x2,y2)): (4,5)(8,8)
 *  Enter input 3 (like (x1,y1)(x2,y2)): (-1,-2)(0,7)
 *
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DistanceMultiple
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sequoia Brown\nAPCS-A\nLewis 2.8 Distance Program");
        System.out.println();
        System.out.println();

        // Prompt the user for the number of runs
        System.out.print("Enter number of runs: ");
        int runs = scanner.nextInt();
        System.out.println();
        scanner.nextLine();

        Pattern numberPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        for (int i = 1; i <= runs; i++)
        {
            System.out.print("Enter both points (x1,y1)(x2,y2): ");
            String input = scanner.nextLine().trim();

            Matcher matcher = numberPattern.matcher(input);
            double[] coords = new double[4];
            int idx = 0;

            while (matcher.find() && idx < 4) {
                coords[idx] = Double.parseDouble(matcher.group());
                idx++;
            }

            double x1 = coords[0];
            double y1 = coords[1];
            double x2 = coords[2];
            double y2 = coords[3];

            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            System.out.println("Distance between points: " + distance);
            System.out.println();
            System.out.println();
        }
        scanner.close();
    }
}