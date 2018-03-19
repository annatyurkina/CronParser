package com.anna.Parsers;

import com.anna.CronJobTable.CronJobTableItem;
import com.anna.CronJobTable.TextCronJobTableItem;
import com.anna.FieldParsingInfos.FieldParsingInfo;

import java.text.ParseException;

public class FieldParser {

    public static CronJobTableItem parse(FieldParsingInfo field, String value) throws ParseException {
        return new TextCronJobTableItem(field.getName(), value);
    }
}
