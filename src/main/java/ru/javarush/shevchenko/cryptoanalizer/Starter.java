package ru.javarush.shevchenko.cryptoanalizer;

import ru.javarush.shevchenko.cryptoanalizer.Commands.BruteForce;
import ru.javarush.shevchenko.cryptoanalizer.Commands.EncodeDecode;
import ru.javarush.shevchenko.cryptoanalizer.Constans.Constans;
import ru.javarush.shevchenko.cryptoanalizer.Interface.EncDec;

import static ru.javarush.shevchenko.cryptoanalizer.Constans.Constans.ALPHABET;

public class Starter {
    public static void main(String[] args) {
        //вход String[] args-> type: encode  path1: input.txt path2: output.txt  key: 12 ([0] [1] [2] [3]
        // String[] args->TaskQuery
        // TaskQuery -> Stnmg
        //выход String


        //validate input param 1

        if (args.length > 0) {
            TaskType type = TaskType.valueOf(args[0].toUpperCase());
            String input = "нбнбарбрбащмк"; //args[1] нбнбарбрбащмк   мама папа шли
            int offset = 2; //args[3] ALPHABET.length = 40    key%ALPHABET.length
            //System.out.println(Constans.ALPHABET.length);
            //route task
            String result = "";
            EncDec encodeDecode = new EncodeDecode(offset, type);
            if (type == TaskType.ENCODE) {
                result = encodeDecode.encdec(input);
            } else if (type == TaskType.DECODE) {
                result = encodeDecode.encdec(input);
            } else if (type == TaskType.BRUTE_FORCE) {
                var hacker = new BruteForce();
                var resultList = hacker.hack(input);
                resultList.forEach(System.out::println); // output of txt

            }
            else {
                throw new AppException("invalid parameters");
            }
            System.out.println(result);
        }
        else {
            throw new AppException("invalid parameters");
        }


    }
}


