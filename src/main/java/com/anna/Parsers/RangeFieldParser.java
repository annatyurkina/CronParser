package com.anna.Parsers;

import com.anna.CronJobTable.CollectionCronJobTableItem;
import com.anna.CronJobTable.CronJobTableItem;
import com.anna.FieldParsingInfos.RangeFieldParsingInfos.RangeFieldParsingInfo;
import com.anna.Parsers.SpecialCharacterParsers.ISpecialCharacterParser;
import com.anna.Parsers.SpecialCharacterParsers.SpecialCharacterParserFactory;

import java.text.ParseException;

public class RangeFieldParser {

    public static CronJobTableItem parse(RangeFieldParsingInfo rangeField, String value) throws ParseException {
        String fieldType = classify(rangeField, value);
        ISpecialCharacterParser parser = SpecialCharacterParserFactory.getParser(fieldType);
        return new CollectionCronJobTableItem(rangeField.getName(), parser.parse(rangeField, value));
    }

    private static String classify(RangeFieldParsingInfo rangeField, String value) throws ParseException {
        if(value.contains(",")) {
            return SpecialCharacters.COMMA;
        }
        if(value.contains("-")) {
            return SpecialCharacters.DASH;
        }
        if(value.contains("/")) {
            return SpecialCharacters.SLASH;
        }
        if(value.equals("*")) {
            return SpecialCharacters.STAR;
        }

        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new ParseException("Invalid value for range field:" + value + ". " +
                    rangeField.getName() + " field has invalid format.", 0);
        }

        return SpecialCharacters.NONE;
    }
}
