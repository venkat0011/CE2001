import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.Scanner;
import javax.swing. *;
import javax.swing.border.Border;
import java.awt.*;

public class Application {
    public static void main(String [] args) throws FileNotFoundException {
        // now we need to work on importing the file and reading from the file
//        JFrame frame = new JFrame("ALGO PROJECT");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300,300);
//        JLabel label1 = new JLabel("please enter your text");
//        JTextField textField = new JTextField(12);
//        String output = textField.getText();
//        JPanel panel = new JPanel();
//        panel.setSize(200,200);
//        panel.add(label1);
//        JButton button1 = new JButton("Button 1");
//        JButton button2 = new JButton("Button 2");
//        panel.add(button2);
//
//        panel.add(textField);
//        frame.getContentPane().add(panel);
//        frame.setVisible(true);
//
        System.out.println("please enter the directory of the file you want to read");
        Scanner sc = new Scanner(System.in);
        String filedirectory = sc.nextLine();
        filedirectory.replace("\\","/");
        BufferedReader reader = new BufferedReader(new FileReader(filedirectory));
        String input = null;
        try {
            String dummy = reader.readLine();
            input = reader.readLine();
            while(reader.readLine()!=null)
            {
                input = input+reader.readLine();
                input = input.replace("\\","");

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(input);

        Jump2_Algo ja = new Jump2_Algo();
        System.out.println("please enter the pattern that you want to find");
        String pattern = sc.nextLine();

        KMP_algo ka = new KMP_algo();
        ArrayList<Integer>position = ka.KMP(input,pattern);

        brute_force_algo bf = new brute_force_algo();
//        ArrayList<Integer>position = bf.Brute_force(input,pattern);

//        ArrayList<Integer>position = ja.Jump_2_Algo(input,pattern);
        if(position.size()==0)
        {
            System.out.println("The pattern does not exist");
        }
        else
        {
            System.out.println("the indexes are");
            for (int a:position)
            {
                System.out.println(a);

            }
            System.out.println(position.size());
        }






    }
}
