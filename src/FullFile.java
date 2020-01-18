import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

/**
 * Very simple program to read file and capitalise each
 * second character, then print the result out and save the result
 * to a new file and the clipboard.
 */

public class FullFile {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(new File("in.txt"));
            StringBuilder sb = new StringBuilder();

            while(sc.hasNextLine()){
                //read in text and process
                String text = sc.nextLine().toLowerCase();
                char[] a = new char[text.length()];
                for (int i = 0; i < text.length(); i++){
                    a[i] = text.charAt(i);
                    if (i % 2 != 0){
                        a[i] = Character.toUpperCase(a[i]);
                    }
                }
                //add text to the string builder
                sb.append(a);
            }
            sc.close();
            String result = sb.toString();
            System.out.println(result);

            //copy text to clipboard and print to console
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable transferable = new StringSelection(result);
            clipboard.setContents(transferable, null);

            //write text to file
            PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
            writer.println(sb);
            writer.close();
        }
        catch(Exception e){
            System.out.println("Oopsie! " + e);
        }
    }
}
