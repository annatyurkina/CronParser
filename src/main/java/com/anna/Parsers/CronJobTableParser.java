package com.anna.Parsers;

import com.anna.CronJobTable.CronJobTable;
import com.anna.CronJobTable.CronJobTableItem;
import com.anna.FieldParsingInfos.CommandFieldParsingInfo;
import com.anna.FieldParsingInfos.RangeFieldParsingInfos.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class CronJobTableParser {

    private static final int CRON_JOB_PARTS_NUM = 6;

    final static Map<Integer, ParseFunction> map = new HashMap<>();
    static {
        map.put(0, value -> RangeFieldParser.parse(new MinuteFieldParsingInfo(), value));
        map.put(1, value -> RangeFieldParser.parse(new HourFieldParsingInfo(), value));
        map.put(2, value -> RangeFieldParser.parse(new DayOfMonthFieldParsingInfo(), value));
        map.put(3, value -> RangeFieldParser.parse(new MonthFieldParsingInfo(), value));
        map.put(4, value -> RangeFieldParser.parse(new DayOfWeekFieldParsingInfo(), value));
        map.put(5, value -> FieldParser.parse(new CommandFieldParsingInfo(), value));
     }

    public CronJobTable parse(String[] cronStringParts) throws ParseException {

        if (cronStringParts.length != CRON_JOB_PARTS_NUM) {
            throw new ParseException("Invalid number of cron jon parameters: expected " + CRON_JOB_PARTS_NUM
            + ", got " + cronStringParts.length, 0);
        }

        CronJobTable cronJobTable = new CronJobTable();
        CronJobTableItem[] items = new CronJobTableItem[CRON_JOB_PARTS_NUM];

        for(int i = 0; i < cronStringParts.length; i++) {

            items[i] = map.get(i).apply(cronStringParts[i]);
        }
        cronJobTable.setItems(items);

        return cronJobTable;

    }
}
