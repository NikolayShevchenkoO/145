package ru.javarush.shevchenko.cryptoanalizer.Interface;

import ru.javarush.shevchenko.cryptoanalizer.TaskQuery;

public interface TaskQueryBuilder {
    TaskQuery build(String[] args);
}
