package GraphSearch;

import java.util.ArrayList;
import java.util.List;

public class FindSubSets {

    public List<String> subSet(String set) {

        List outputList = new ArrayList();
        StringBuilder solutionPrefix = new StringBuilder();

        subSet(set, 0, outputList, solutionPrefix);

        return outputList;
    }

    private void subSet(String inputString, int index, List outputList, StringBuilder solutionPrefix) {
        //Base case
        if (inputString.length() == index) {
            outputList.add(solutionPrefix.toString());
            System.out.println(solutionPrefix);
            return;
        }

        //Path 1: Add Elements
        solutionPrefix.append(inputString.charAt(index));
        subSet(inputString, index + 1, outputList, solutionPrefix);
        solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);

        //Path 2: Add Empty ""
        subSet(inputString, index + 1, outputList, solutionPrefix);
    }


    public static void main(String[] args) {
        FindSubSets findSubSets = new FindSubSets();
        String testSet = "abc";
        List testOutput = findSubSets.subSet(testSet);
        System.out.println(testOutput.toString());
    }
}
