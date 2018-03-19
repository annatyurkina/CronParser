package com.anna.Parsers.SpecialCharacterParsers;

import com.anna.ArrayHelper;
import com.anna.FieldParsingInfos.RangeFieldParsingInfos.RangeFieldParsingInfo;

import java.text.ParseException;

public class DashParser implements ISpecialCharacterParser {

    public int[] parse(RangeFieldParsingInfo rangeField, String value) throws ParseException {

        int start = getValidStart(rangeField, value);
        int end = getValidEnd(rangeField, value);

        if(start > end) {
            throw new ParseException("Invalid value for range field:" + value + ". " +
                    rangeField.getName() + " field cannot have start greater than end.", 0);
        }

        return ArrayHelper.generate(start, end, 1);
    }

    private static int getValidStart(RangeFieldParsingInfo rangeField, String value) throws ParseException {

        int start = Integer.parseInt(value.substring(0, value.indexOf('-')));

        if(start < rangeField.getMinValue() || start > rangeField.getMaxValue()) {
            throw new ParseException("Invalid value for range field:" + value + ". " +
                    rangeField.getName() + " field cannot have start " + start, 0);
        }

        return start;
    }

    private static int getValidEnd(RangeFieldParsingInfo rangeField, String value) throws ParseException {

        int end = Integer.parseInt(value.substring(value.indexOf('-') + 1));

        if(end < rangeField.getMinValue() || end > rangeField.getMaxValue()) {
            throw new ParseException("Invalid value for range field:" + value + ". " +
                    rangeField.getName() + " field cannot have end " + end, 0);
        }

        return end;
    }
}
