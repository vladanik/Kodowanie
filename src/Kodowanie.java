import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Kodowanie {

    static Scanner scan = new Scanner(System.in);

    static String szyfrGadery = "GADERYPOLUKIgaderypoluki";
    static String szyfrPangram = "PERFECTPANGRAMperfectpangram";


    public static void main(String[] args) throws IOException {
        String s = "";

        Scanner plik = new Scanner(new File("src/tekst.txt"));
        while (plik.hasNextLine()) {
            s = plik.nextLine();
        }

        System.out.println(s + "\n");

        System.out.println("GA-DE-RY-PO-LU-KI:");
        System.out.println(gadery(s, szyfrGadery));
        System.out.println();

        System.out.println("PERFECTPANGRAM:");
        czyPangram(s);
        System.out.println();

        System.out.println("Szyfr Cezara:");
        cezar(s);
        System.out.println();
    }

    public static String gadery(String s, String szyfr) {
        StringBuilder s1 = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < szyfr.length(); j++) {
                if ((s.charAt(i) == szyfr.charAt(j)) && (j % 2 == 0)) {
                    s1.setCharAt(i, szyfr.charAt(j + 1));
                } else if ((s.charAt(i) == szyfr.charAt(j)) && (j % 2 == 1)) {
                    s1.setCharAt(i, szyfr.charAt(j - 1));
                } else {
                    continue;
                }
            }
        }
        s = s1.toString();
        return s;
    }

    public static void czyPangram(String s) {
        boolean[] arr = new boolean[26];
        int index = 0;
        int f = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                index = s.charAt(i) - 'A';
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                index = s.charAt(i) - 'a';
            }
            arr[index] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == false) {
                f = 0;
            }
        }
        if (f == 1) {
            System.out.println("Jest pangramem!");
            System.out.println(gadery(s, szyfrPangram));
        } else {
            System.out.println("Nie jest pangramem");
        }
    }

    public static void cezar(String s) {
        System.out.println("Liczba przesuniecia: ");
        int przes = scan.nextInt();
        String c = "";
        char alfabet;
        for (int i=0; i < s.length(); i++)
        {
            alfabet = s.charAt(i);
            if (alfabet >= 'a' && alfabet <= 'z') {
                alfabet = (char)(alfabet + przes);
                if (alfabet > 'z') {
                    alfabet = (char)(alfabet + 'a' - 'z' - 1);
                }
                c += alfabet;
            } else if (alfabet >= 'A' && alfabet <= 'Z') {
                alfabet = (char)(alfabet + przes);
                if (alfabet > 'Z') {
                    alfabet = (char)(alfabet + 'A' - 'Z' - 1);
                }
                c += alfabet;
            }
            else {
                c += alfabet;
            }
        }
        System.out.println(c);
    }
}
