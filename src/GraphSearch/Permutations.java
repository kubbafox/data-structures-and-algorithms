package GraphSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string with no duplicate characters, return a list with all permutations of the characters.
 * <p>
 * Examples
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 */

public class Permutations {

    public List<String> permutations(String set) {

        List<String> permutationList = new ArrayList<>();

        //Null, Empty and Black Check
        if (set == null) {
            return permutationList;
        } else if (set.isEmpty()){
            permutationList.add("");
            return permutationList;
        } else {
            searchPermutations();

            return permutationList;

        }

    }

    public void searchPermutations() {
        

    }


}
