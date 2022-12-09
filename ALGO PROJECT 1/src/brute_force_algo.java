import java.util.ArrayList;

public class brute_force_algo {
    public ArrayList<Integer> Brute_force(String input, String pattern)
    {
        ArrayList<Integer>position = new ArrayList<>();
        for(int i = 0; i<input.length()-pattern.length();i++)
        {
            String substring  =  input.substring(i,i+pattern.length());
            if(substring.compareTo(pattern)==0)
            {
                position.add(i);
            }
        }
        return position;

    }
}
