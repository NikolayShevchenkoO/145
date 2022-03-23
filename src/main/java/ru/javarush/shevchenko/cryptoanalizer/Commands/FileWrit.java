package ru.javarush.shevchenko.cryptoanalizer.Commands;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static ru.javarush.shevchenko.cryptoanalizer.Constans.Constans.TXT_FOLDER;

public class FileWrit {


    public static  void fileWriter(String arg, String result) {

        try (FileWriter writer = new FileWriter(TXT_FOLDER + arg)) {
            writer.write(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // builder.toString();


    }


}

