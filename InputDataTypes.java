import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class InputDataTypes
{   
    public static void main(String[] args)
    {
        JFrame f;    
        f=new JFrame();
        JOptionPane.showMessageDialog(f, "Hi, you are required to input 8 primitive data types.");
        String st = JOptionPane.showInputDialog(f, "Enter a Byte Data Type Value");
        byte b = Byte.parseByte(st);
        st = JOptionPane.showInputDialog(f, "Enter a Short Data Type Value");
        short sh = Short.parseShort(st);
        st = JOptionPane.showInputDialog(f, "Enter a Integer Data Type Value");
        int i = Integer.parseInt(st);
        st = JOptionPane.showInputDialog(f, "Enter a Long Data Type Value");
        long l = Long.parseLong(st);
        st = JOptionPane.showInputDialog(f, "Enter a Char Data Type Value");
        char c = st.charAt(0);
        st = JOptionPane.showInputDialog(f, "Enter a Float Data Type Value");
        float fl = Float.parseFloat(st);
        st = JOptionPane.showInputDialog(f, "Enter a Double Data Type Value");
        double d = Double.parseDouble(st);
        st = JOptionPane.showInputDialog(f, "Enter a Boolean Data Type Value");
        JOptionPane.showMessageDialog(f, "Byte Value Entered:" + b + "\nShort Value Entered:" + sh + "\nInteger Value Entered:" + i + "\nLong Value Entered:" + l + "\nChar Value Entered:" + c + "\nFloat Value Entered:" + fl + "\nDouble Value Entered:" + d + "\nBoolean Value Entered:" + st);
        /*Scanner s = new Scanner(System.in);
        String inpot=JOptionPane.showInputDialog(f,"Enter a " + arr[0]);    
        int b = Integer.parseInt(inpot);
        System.out.println("Entered Byte Data Type Value is: "+ b);
        int car = s.nextInt();
        if(car == 4)*/
            System.exit(0);
    }
}