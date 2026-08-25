import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
public static int invalidLines = 0;
    public static void main(String[] args) {
        String inputFile = "scores.txt";
        String outputFile = "report.txt";
        
 
        ArrayList<Integer> scores = readScores(inputFile);
    
        double average = calculateAverage(scores);
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        
        if (scores.isEmpty()) {
            low = 0;
            high = 0;
        }
        for (int score : scores) {
      
            if (score > high) {
                high  = score;
            }
            if(score < low ) {
                low = score;
            }
        }

        writeReport(scores, average, high, low, outputFile);
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            ArrayList<Integer> scores = new ArrayList<>();;
       
            String line;
    
            
            while ((line = reader.readLine()) != null) {
                try {
                    if (line.trim().isEmpty()) {
                        invalidLines++;
                        System.err.println("Empty line found.");
                        continue; 
                        
                    }
                    int score = Integer.parseInt(line.trim());
                    if (score >= 0 && score <= 100) {
                        scores.add(score);
                    }
                    else {
                        System.err.println("Score out of range (0-100) {line} " + line);
                        invalidLines++;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("===Lines Skipped with reasons === ");
                    System.err.println("Number Format Error: " + line);
                    invalidLines++;
                    continue;
                } 
            }
            return scores;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            invalidLines++;
            return new ArrayList<>();
        }
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("=== Grade Analysis Report ===");
            System.out.println("\n === Grade Analysis Report ===");
            writer.println("Total Scores Processed: " + scores.size());
            System.out.println("Total Scores Processed: " + scores.size());
            writer.println("Number of invalid lines: " + invalidLines);
            System.out.println("Number of invalid lines: " + invalidLines);
            writer.println("\n====Grade Statistics====");
            System.out.println("\n====Grade Statistics====");
            writer.write(String.format("Average score: %.2f%n", avg));
            System.out.println(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            System.out.println(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low));
            System.out.println(String.format("Lowest score: %d%n", low));
            writer.println("\n=======Grade Distribution=============");
            System.out.println("\n========Grade Distribution============");
            int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        if (scores.isEmpty()) {
            System.out.println("There is no valid scores in the data provided.");
        } else {
            for (int score : scores) {
                if (score >= 90) {
                    countA++;
                } else if (score >= 80) {
                    countB++;
                } else if (score >= 70) {
                    countC++;
                } else if (score >= 60) {
                    countD++;
                } else {
                    countF++;
                }
            }
        }
        writer.println(String.format("A (90-100):   %d", countA));
        System.out.println(String.format("A (90-100):   %d", countA));
        writer.println(String.format("B (80-89):    %d", countB));
        System.out.println(String.format("B (80-89):    %d", countB));
        writer.println(String.format("C (70-79):    %d", countC));
        System.out.println(String.format("C (70-79):    %d", countC));
        writer.println(String.format("D (60-69):    %d", countD));
        System.out.println(String.format("D (60-69):    %d", countD));
        writer.println(String.format("F (Below 60) : %d", countF));
        System.out.println(String.format("F (Below 60): %d", countF));
        



        } catch (IOException e) {
            System.err.println("Error writing report: " + e.getMessage());
        }
    }
} 