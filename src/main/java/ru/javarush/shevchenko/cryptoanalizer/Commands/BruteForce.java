package ru.javarush.shevchenko.cryptoanalizer.Commands;

import ru.javarush.shevchenko.cryptoanalizer.Interface.Brute;
import ru.javarush.shevchenko.cryptoanalizer.Constans.Constans;
import ru.javarush.shevchenko.cryptoanalizer.TaskType;

import java.util.*;

public class BruteForce implements Brute {
    private Set<String> dictionary;
    private final TreeMap<Integer, String> mapResult = new TreeMap<>();

    public BruteForce(Set<String> dictionary) {

        this.dictionary = dictionary;// TODO поправить словарь, наименование конструктора
    }

    @Override
    public List<String> hack(String input) {
        var alphabetSize = Constans.ALPHABET.length;
        for (int i = 1; i <= alphabetSize; i++) {
            var encoder = new EncodeDecode(i, TaskType.DECODE);
            var result = encoder.encdec(input);  //мама, как ела?
            var resultSet = result.split("[^а-яё]+"); //Очистка слов дописать
            int count = 0;
            for (var word : resultSet) {
                if (dictionary.contains(word)) {
                    count++;
                }
            }
            mapResult.put(count, result);
        }
        //решение о лучшем результате
        var mapResultKey = mapResult.lastEntry();

        return Collections.singletonList(mapResultKey.getValue());
    }
}

