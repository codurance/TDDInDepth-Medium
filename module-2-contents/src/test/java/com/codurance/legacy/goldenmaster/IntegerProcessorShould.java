package com.codurance.legacy.goldenmaster;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class IntegerProcessorShould {
    @Test
    public void processIntegerNumbers() {
        IntegerProcessor processor = new IntegerProcessor();

        // Test inputs that cover various scenarios
        List<List<Integer>> testCases = Arrays.asList(
            Arrays.asList(1, 2, 3),                    // Simple positive numbers
            Arrays.asList(-1, -2, -3),                 // Simple negative numbers
            Arrays.asList(0, 0, 0),                    // All zeros
            Arrays.asList(101, 200),                   // Numbers greater than 100
            Arrays.asList(-101, -200),                 // Numbers less than -100
            Arrays.asList(50, -50, 0, 150, -150),      // Mixed numbers
            Arrays.asList()                            // Empty list
        );

        // Capture the output for each input
        StringBuilder results = new StringBuilder();
        for (List<Integer> testCase : testCases) {
            results.append("Input: ").append(testCase).append("\n");
            results.append("Output: ").append(processor.process(testCase)).append("\n\n");
        }

        // Verify with Approvals
        Approvals.verify(results.toString());
    }
}
