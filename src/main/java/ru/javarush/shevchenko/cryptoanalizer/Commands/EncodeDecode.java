package ru.javarush.shevchenko.cryptoanalizer.Commands;

import ru.javarush.shevchenko.cryptoanalizer.Constans.Constans;
import ru.javarush.shevchenko.cryptoanalizer.Interface.EncDec;
import ru.javarush.shevchenko.cryptoanalizer.TaskType;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecode implements EncDec {

    private final int offset;
    private  int typeoperacion;
    private final Map<Character, Integer> characterIntegerMap = new HashMap<>();

    public EncodeDecode(int offset, TaskType type) {

        this.offset = offset; // TODO перемножим и за один раз отработаем
        if (type==TaskType.ENCODE){
            typeoperacion =1;
        }
        else if (type==TaskType.DECODE){
            typeoperacion=-1;
        }
        for (int i = 0; i < Constans.ALPHABET.length; i++) {
            characterIntegerMap.put(Constans.ALPHABET[i], i);
        }
    }

    @Override
    public String encdec(String input) {
        var builder = new StringBuilder();
        var array = input.toLowerCase().toCharArray();
        for (var sourceChar : array) {
            var encdecChar = getEncodedDecodedChar(sourceChar);
            builder.append(encdecChar);
        }
        return builder.toString();
    }

    private char getEncodedDecodedChar(char ch) {
        //найтие его индекс
        if (characterIntegerMap.containsKey(ch)) {
            var index = characterIntegerMap.get(ch);
            var total = index + offset*typeoperacion;
            total = total % Constans.ALPHABET.length;
            if (total > Constans.ALPHABET.length - 1) {
                total = total - Constans.ALPHABET.length;
            } else if (total < 0) {
                total = Constans.ALPHABET.length + total;
            }
            return Constans.ALPHABET[total];
        }
        throw new IllegalArgumentException("char not found in alphabet");
    }

}