import java.util.Scanner;

/**
 * Very simple program to read console input and capitalise each
 * second character, then print the result out.
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
        System.out.print(a);
    }
}
