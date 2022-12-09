import java.util.ArrayList;

public class KMP_algo {
    public ArrayList<Integer>  KMP(String input, String Pattern) {
        int[] longest_prefix_suffix = new int[Pattern.length()];
        int i = 1;
        int j = 0;
        ArrayList<Integer> position = new ArrayList<>();
        longest_prefix_suffix[0] = 0;
        while (i < Pattern.length()) {
            if (Pattern.charAt(i) == Pattern.charAt(j)) {
                j++;
                longest_prefix_suffix[i] = j;
                i++;


            } else {
                if (j != 0) {
                    j = longest_prefix_suffix[j - 1];
                } else {
                    longest_prefix_suffix[i] = j;
                    i++;

                }

            }
        }

        i = 0;
        j = 0;
        while (i < input.length()) {


            if (j < Pattern.length() && input.charAt(i) == Pattern.charAt(j)) {

                i++;
                j++;

            } else if (j == Pattern.length()) {
                position.add(i - j);
                j = 0;
            } else {
                if (j != 0) {
                    j = longest_prefix_suffix[j - 1];
                } else {
                    i++;
                }

            }
        }
        return position;
    }



}
