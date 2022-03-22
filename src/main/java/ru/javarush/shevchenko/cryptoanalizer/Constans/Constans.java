package ru.javarush.shevchenko.cryptoanalizer.Constans;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Constans {

    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};


    public static final String TXT_FOLDER=System.getProperty("user.dir")+
            File.separator+
            "Crypto"+
            File.separator;

}
