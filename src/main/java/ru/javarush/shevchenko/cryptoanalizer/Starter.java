package ru.javarush.shevchenko.cryptoanalizer;

import ru.javarush.shevchenko.cryptoanalizer.Commands.*;
import ru.javarush.shevchenko.cryptoanalizer.Interface.EncDec;

// start by parametrs in edit config or cmd: decode in.txt out.txt 15 dictonary.txt


public class Starter {
    public static void main(String[] args) {
        //вход String[] args-> type: encode  path1: input.txt path2: output.txt  key: 12 ([0] [1] [2] [3]
        // String[] args->TaskQuery
        // TaskQuery -> Stnmg
        //выход String
        //validate input param 1
        //System.out.println(System.getProperty("user.dir")+ File.separator+ "Crypto"+ File.separator);


        if (args.length > 0) {

            TaskType type = TaskType.valueOf(args[0].toUpperCase());
            int offset = Integer.parseInt(args[3]); //args[3] ALPHABET.length = 40    key%ALPHABET.length

            EncDec encodeDecode = new EncodeDecode(offset, type);


            //String input = "нбнбарбрбащмк"; //args[1] нбнбарбрбащмк   мама папа шли
            String input = FileRead.fileReader(args[1]); // args[1]
            String fileDictonary = args[4]; // file name Dictionary


            //System.out.println(Constans.ALPHABET.length);
            //route task


            String result = "";
            if (type == TaskType.ENCODE) {
                result = encodeDecode.encdec(input);
            } else if (type == TaskType.DECODE) {
                result = encodeDecode.encdec(input);
            } else if (type == TaskType.BRUTE_FORCE) {
                var dictionary= FillDictionary.filDictonary(fileDictonary);
                var hacker = new BruteForce(dictionary);
                var resultList = hacker.hack(input);
                result = resultList.toString();
                //resultList.forEach(System.out::println); // output of txt
            }
            else {
                throw new AppException("invalid parameters");
            }
            //System.out.println(result);
            FileWrit.fileWriter(args[2], result);

        }
        else {
            throw new AppException("invalid parameters");
        }


    }
}


