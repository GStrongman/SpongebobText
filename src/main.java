import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Very simple program to read console input and capitalise each
 * second character, then print the result out and save the result
 * to the user's clipboard.
 */

public class main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char a[] = new char[text.length()];
        for (int i = 0; i < text.length(); i++){
            a[i] = text.charAt(i);
            if (i % 2 != 0){
               a[i] = Character.toUpperCase(a[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(a);
        text = sb.toString();

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(text);
        clipboard.setContents(transferable, null);

        System.out.print(a);
    }
}
