import java.util.ArrayList;
import java.util.Arrays;

public class Delimiters {
    /**
     * The open and close delimiters.
     */
    private String openDel;
    private String closeDel;

    /**
     * Constructs a Delimiters object where open is the open delimiter and close is the
     * close delimiter.
     * Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    /**
     * Returns an ArrayList of delimiters from the array tokens, as described in part (a).
     */
    public ArrayList<String> getDelimitersList(String[] tokens) {
        ArrayList<String> dels = new ArrayList<>();
        for (String token : tokens) {
            if (token.equals(openDel) || token.equals(closeDel))
                dels.add(token);
        }
        return dels;
    }

    /**
     * Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     * Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters) {
        int open = 0;
        int close = 0;
        for (String del : delimiters) {
            if (del.equals(openDel))
                open++;
            if (del.equals(closeDel))
                close++;
            if (close > open)
                return false;
        }
        return open == close;
    }

    public static void main(String[] args) {
        Delimiters example1 = new Delimiters("(", ")");
        String[] tokens1 = {"(", "x + y", ")", " * 5"};
        System.out.println(example1.getDelimitersList(tokens1));

        Delimiters example2 = new Delimiters("<q>", "</q>");
        String[] tokens2 = {"<q>", "yy", "</q>", "zz", "</q>"};
        System.out.println(example2.getDelimitersList(tokens2));

        Delimiters exampleB = new Delimiters("<sup>", "</sup>");

        String[] tokensB1 = {"<sup>", "<sup>", "</sup>", "<sup>", "</sup>", "</sup>"};
        System.out.println(exampleB.isBalanced(new ArrayList<>(Arrays.asList(tokensB1)))); // -> true

        String[] tokensB2 = {"<sup>", "</sup>", "</sup>", "<sup>"};
        System.out.println(exampleB.isBalanced(new ArrayList<>(Arrays.asList(tokensB2)))); // -> false

        String[] tokensB3 = {"</sup>"};
        System.out.println(exampleB.isBalanced(new ArrayList<>(Arrays.asList(tokensB3)))); // -> false

        String[] tokensB4 = {"<sup>", "<sup>", "</sup>"};
        System.out.println(exampleB.isBalanced(new ArrayList<>(Arrays.asList(tokensB4)))); // -> false
    }

    // There may be instance variables, constructors, and methods that are not shown.
}