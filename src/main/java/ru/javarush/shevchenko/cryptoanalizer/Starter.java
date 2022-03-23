package ru.javarush.shevchenko.cryptoanalizer;

import ru.javarush.shevchenko.cryptoanalizer.Commands.BruteForce;
import ru.javarush.shevchenko.cryptoanalizer.Commands.EncodeDecode;
import ru.javarush.shevchenko.cryptoanalizer.Commands.FileRead;
import ru.javarush.shevchenko.cryptoanalizer.Commands.FileWrit;
import ru.javarush.shevchenko.cryptoanalizer.Interface.EncDec;




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


            //System.out.println(Constans.ALPHABET.length);
            //route task


            String result = "";
            if (type == TaskType.ENCODE) {
                result = encodeDecode.encdec(input);
            } else if (type == TaskType.DECODE) {
                result = encodeDecode.encdec(input);
            } else if (type == TaskType.BRUTE_FORCE) {
                var hacker = new BruteForce();
                var resultList = hacker.hack(input);
                result = resultList.toString();
                //resultList.forEach(System.out::println); // output of txt
            }
            else if (type==TaskType.FREQUENCY){

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


