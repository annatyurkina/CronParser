package com.anna;

import com.anna.CronJobTable.CronJobTable;
import com.anna.Parsers.CronJobTableParser;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        CronJobTablePresenter cronJobTablePresenter = new CronJobTablePresenter();
        CronJobTableParser cronJobTableParser = new CronJobTableParser();

        CronJobTable cronTable = cronJobTableParser.parse(args);
        cronJobTablePresenter.present(cronTable);
    }
}
