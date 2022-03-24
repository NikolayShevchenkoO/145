package ru.javarush.shevchenko.cryptoanalizer.Commands;

import java.util.HashSet;
import java.util.Set;

public class FillDictionary {
    public static Set<String> filDictonary(String firstDictonary) {
        Set<String> dict = new HashSet<>() ;
        var halfRslt = FileRead.fileReader(firstDictonary);
        var Rslt = halfRslt.toLowerCase();
        var resultSet = Rslt.split("[^а-яё]+"); //Очистка слов дописать
        for (String s : resultSet) {
            if (s.length()>2){
                dict.add(s);
               // System.out.println(s);
            }


        }
//        FileWrit.fileWriter("halfRslt.txt", halfRslt);
//        FileWrit.fileWriter("Rslt.txt", Rslt);
//        FileWrit.fileWriter("resSet.txt", String.valueOf(resultSet));
//
//        FileWrit.fileWriter("dist.txt", String.valueOf(dict));

        return dict;
    }
}
