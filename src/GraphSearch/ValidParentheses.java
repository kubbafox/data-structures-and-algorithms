package GraphSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * GivenU N pairs of parentheses “()”, return a list with all the valid permutations.
 * <p>
 * Assumptions
 * <p>
 * N >= 0
 * Examples
 * <p>
 * N = 1, all valid permutations are ["()"]
 * N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * N = 0, all valid permutations are [""]
 */

public class ValidParentheses {

    public List<String> validParentheses(int n) {

        List<String> result = new ArrayList<>();
        StringBuilder solutionPrefix = new StringBuilder();

        if (n < 0) {
            return null;
        } else if (n == 0) {
            result.add("");
            return result;
        } else {
            searchValidParentheses(n, 0, 0, solutionPrefix, result);
            return result;
        }
    }

    /**
     * Inputs:
     * n - total number of pairs of inputs "()"
     * left - The numbers of total left parentheses "(" added so far
     * right - The numbers of total right parentheses ")" added so far
     * solutionPrefix - The result in current recursion
     * result - A list to save all results
     */

    private void searchValidParentheses(int n, int left, int right, StringBuilder solutionPrefix, List<String> result) {
        //Base case
        if (left == n && right == n) {
            result.add(solutionPrefix.toString());
            return;
        }

        //Add "("
        if (left < n) {
            solutionPrefix.append("(");
            searchValidParentheses(n, left + 1, right, solutionPrefix, result);
            solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
        }

        //Add "("
        if (right < left) {
            solutionPrefix.append(")");
            searchValidParentheses(n, left, right + 1, solutionPrefix, result);
            solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
        }

    }

    public static void main (String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.validParentheses(3));
    }

}
