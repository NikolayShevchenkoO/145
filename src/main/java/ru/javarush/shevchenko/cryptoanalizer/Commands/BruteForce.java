package ru.javarush.shevchenko.cryptoanalizer.Commands;

import ru.javarush.shevchenko.cryptoanalizer.Brute;
import ru.javarush.shevchenko.cryptoanalizer.Constans.Constans;

import java.util.*;

public class BruteForce implements Brute {
    private final Set<String> dictionary;
    private final Map<Integer, String> mapResult = new TreeMap<>();

    public BruteForce() {
        this.dictionary = Set.of("мама", "папа", "свет");// TODO поправить словарь, наименование конструктора
    }

    @Override
    public List<String> hack(String input) {
        var alphabetSize = Constans.ALPHABET.length;
        for (int i = 1; i <= alphabetSize; i++) {
            var encoder = new EncodeDecode(i);
            var result = encoder.encdec(input);  //мама, как ела?
            var resultSet = result.split(" "); //Очистка слов
            int count = 0;
            for (var word : resultSet) {
                if (dictionary.contains(word)) {
                    count++;
                }
            }
            mapResult.put(count, result);
        }
        //решение о лучшем результате
        var res = mapResult.values();
        return new ArrayList<>(res);
    }
}

