package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Text_Analyzer {
    public static void main(String[] args) {
        String line;
        int vowels = 0, consonants = 0, digits = 0, spaces = 0, special_char = 0;
        try {
            FileReader fr = new FileReader("src/com/company/a.txt");
            BufferedReader read = new BufferedReader(fr);

            while ((line = read.readLine()) != null) {
                System.out.println(line);
                line = line.toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'
                            || ch == 'u' || ch == 'y' || ch == 'ą' || ch == 'ę' || ch == 'ó') {
                        vowels++;
                    } else if ((ch >= 'a' && ch <= 'z' || ch == 'ż' || ch == 'ź'
                            || ch == 'ś' || ch == 'ń' || ch == 'ć' || ch == 'ł')) {
                        consonants++;
                    } else if (ch >= '0' && ch <= '9') {
                        digits++;
                    } else if (ch == ' ') {
                        spaces++;
                    } else {
                        special_char++;
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Nie udało się wczytać pliku: " + ex);
        }
        System.out.println("------------------------");
        System.out.println("Samogłoski: " + vowels);
        System.out.println("Spółgłoski: " + consonants);
        System.out.println("Cyfry: " + digits);
        System.out.println("Znaki białe: " + spaces);
        System.out.println("Znaki specjalne: " + special_char);

        try {
            FileWriter wr = new FileWriter("src/com/company/b.txt");
            wr.write("Samogłoski: " + vowels + "\n" + "Spółgłoski: " + consonants + "\n" +
                    "Cyfry: " + digits + "\n" + "Znaki białe: " + spaces + "\n" +
                    "Znaki specjalne: " + special_char);
            wr.close();
        } catch (IOException ex) {
            System.out.println("Nie udało się zapisać pliku: " + ex);
        }

    }

}
