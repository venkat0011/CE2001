import java.util.ArrayList;

public class Jump2_Algo
{
    private int comparison = 0;
    public  ArrayList<Integer> Jump_2_Algo(String input, String pattern)
    {
        char[] input_array = input.toCharArray();
        char[] pattern_array = pattern.toCharArray();
        int[][] Index = new int[5][input.length()];

        int t_index = 0;
        int a_index = 0;
        int g_index = 0;
        int c_index = 0;
        int u_index = 0;

        // to preprocess the input sting into into its individual character elements
        for (int i = 0; i < input.length(); i++) {
            switch (input_array[i])
            {
                case 'A':
                    Index[0][a_index] = i;
                    a_index++;
                    break;
                case 'C':
                    Index[1][c_index] = i;
                    c_index++;
                    break;
                case 'G':
                    Index[2][g_index] = i;
                    g_index++;
                    break;
                case 'T':
                    Index[3][t_index] = i;
                    t_index++;
                    break;
                case 'U':
                    Index[4][t_index] = i;
                    u_index ++;
                    break;
            }
        }

        // now we will start to see if there is a comparison

        int i = 0;
        int j = 0;

        ArrayList<Integer> position = new ArrayList<>();
        char firstletter = pattern_array[0];
        int first_letter = 0;

        switch (firstletter)
        {
            case 'A':
                first_letter = 0;
                break;
            case 'C':
                first_letter = 1;
                break;
            case 'G':
                first_letter = 2;
                break;
            case 'T':
                first_letter = 3;
                break;
            case 'U':
                first_letter = 4;
                break;

        }
        int startIndex = Index[first_letter][0];
        if (pattern_array.length == 1) {
            for (int a : Index[first_letter]) {
                position.add(a);
            }
        } else {
            while ((input_array.length - startIndex) > pattern_array.length)
            // we will be looking from the first appearance of the first letter in the pattern
            // and once the remaining part of it is lesser than the pattern length we should break it off
            {
                while (j < pattern_array.length - 1) {
                    if (input_array[startIndex + j] != pattern_array[j] || input_array[startIndex + j + 1] != pattern_array[j + 1]) {
                        comparison += 2; // we are still comparing the key in the input to the key in patterm
                        // once it is not equal we should go to the next occurance of the first index so need to break it off
                        break;
                    } else {
                        if (j == pattern_array.length - 2) // if it was able to make it all the way to here without breaking then it is the same as the pattern
                        {
                            position.add(startIndex);
                        }
                        j++; // if the consecutive character are the same, then we increase j to , see the next 2 character
                    }
                }
                j = 0;
                startIndex = Index[first_letter][i++];
            }
        }

        return position;
    }
    public  int get_comparison()
    {
        return comparison;
    }
}
