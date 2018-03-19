package com.anna.Parsers;

import com.anna.CronJobTable.CronJobTableItem;

import java.text.ParseException;

@FunctionalInterface
public interface ParseFunction {
    CronJobTableItem apply(String value) throws ParseException;
}
