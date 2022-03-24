package ru.javarush.shevchenko.cryptoanalizer.Commands;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static ru.javarush.shevchenko.cryptoanalizer.Constans.Constans.TXT_FOLDER;

public class FileRead {
    public static String fileReader(String arg) {
        StringBuilder builder = new StringBuilder();
        try (FileReader reader = new FileReader(TXT_FOLDER + arg)) {
            char[] buffer = new char[1024]; // 1024Kb
            while (reader.ready()) {
                int real = reader.read(buffer);
                builder.append(buffer, 0, real);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
